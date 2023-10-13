package com.imt.delirium.ressources;


import com.imt.delirium.entities.Utilisateur;
import com.imt.delirium.repositories.UtilisateurRepository;
import com.imt.delirium.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("utilisateurs")
public class UtilisateurRessources {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private AuthData AuthData;

    @Autowired
    private UtilisateurService utilisateurService;

    @GET
    @Produces(value = "application/json")
    public List<Utilisateur> getUtilisateur(){
        return utilisateurRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(value = "application/json")
    public Optional<Utilisateur> getUtilisateur(@NotNull @PathParam("id") Long id){return utilisateurRepository.findById(id);}

    @POST
    @Consumes(value = "application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUtilisateur(@NotNull @RequestBody Utilisateur utilisateur){
        Utilisateur verifUtil = utilisateurRepository.findByEmailAndPassword(utilisateur.getEmail(), utilisateur.getPassword());
        if (verifUtil == null) {
            return Response.status(Response.Status.CONFLICT).build();
        } else {
            Utilisateur utili = utilisateurRepository.save(utilisateur);
            return Response.ok(utilisateur).build();
        }
    }

    @DELETE
    @Consumes(value = "application/json")
    @Path("/{id}")
    public void deleteUtilisateur(@NotNull @PathParam("id") Long id){utilisateurRepository.deleteById(id);}


    @POST
    @Path("/auth")
    @Consumes(value = "application/json")
    @Produces(value = "application/json")
    public Response authenticateUser(@NotNull @RequestBody AuthData authData) {
        Utilisateur utilisateur = utilisateurRepository.findByEmailAndPassword(authData.getEmail(), authData.getPassword());
        if (utilisateur != null) {
            return Response.ok(utilisateur).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}