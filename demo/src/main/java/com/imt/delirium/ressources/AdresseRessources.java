package com.imt.delirium.ressources;

import com.imt.delirium.entities.Adresse;
import com.imt.delirium.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.List;

@Path("adresses")
public class AdresseRessources {

    @Autowired
    private AdresseRepository adresseRepository;

    @GET
    @Produces(value = "application/json")
    public List<Adresse> getAdresse(){
        return adresseRepository.findAll();
    }

    @POST
    @Consumes(value = "application/json")
    public void createAdresse(@NotNull @RequestBody Adresse adresse){adresseRepository.save(adresse);}

    @DELETE
    @Consumes(value = "application/json")
    @Path("/{id}")
    public void deleteAdresse(@NotNull @PathParam("id") Long id){adresseRepository.deleteById(id);}
}