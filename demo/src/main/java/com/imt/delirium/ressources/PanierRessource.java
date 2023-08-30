package com.imt.delirium.ressources;

import com.imt.delirium.entities.Adresse;
import com.imt.delirium.entities.Panier;
import com.imt.delirium.repositories.AdresseRepository;
import com.imt.delirium.repositories.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.List;

@Path("paniers")
public class PanierRessource {

    @Autowired
    private PanierRepository panierRepository;

    @GET
    @Produces(value = "application/json")
    public List<Panier> getPanier(){
        return panierRepository.findAll();
    }

    @POST
    @Consumes(value = "application/json")
    public void createPanier(@NotNull @RequestBody Panier panier){panierRepository.save(panier);}

    @DELETE
    @Consumes(value = "application/json")
    @Path("/{id}")
    public void deletePanier(@NotNull @PathParam("id") Long id){panierRepository.deleteById(id);}
}