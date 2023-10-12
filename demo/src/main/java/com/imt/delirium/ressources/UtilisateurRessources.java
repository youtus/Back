package com.imt.delirium.ressources;


import com.imt.delirium.entities.Utilisateur;
import com.imt.delirium.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("utilisateurs")
public class UtilisateurRessources {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurRepository AuthData;

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
    public void createUtilisateur(@NotNull @RequestBody Utilisateur utilisateur){utilisateurRepository.save(utilisateur);}

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
            System.out.println("mail: "+authData.getEmail()+" password: "+authData.getPassword());
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}