package com.imt.delirium.ressources;

import com.imt.delirium.entities.Produit;
import com.imt.delirium.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.List;

@Path("produits")
public class ProduitResource {

    @Autowired
    private ProduitRepository produitRepository;

    @GET
    @Produces(value = "application/json")
    public List<Produit> getProduits(){
        return produitRepository.findAll();
    }

    @POST
    @Consumes(value = "application/json")
    public void createProduits(@NotNull @RequestBody Produit produit){
        produitRepository.save(produit);
    }

}
