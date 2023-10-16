package com.imt.delirium.ressources;

import com.imt.delirium.entities.Produit;
import com.imt.delirium.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.imt.delirium.enumeration.Categories;


@Path("produits")
public class ProduitResource {

    public static final List<String> ListCategories = Arrays.stream(Categories.values())
            .map(Enum::name)
            .collect(Collectors.toList());


    @Autowired
    private ProduitRepository produitRepository;

    @GET
    @Produces(value = "application/json")
    public List<Produit> getProduits(){
        return produitRepository.findAll();
    }

    @GET
    @Path("/categories")
    @Produces(value = "application/json")
    public List<String> getCategorie(){
        return ListCategories;
    }

    @POST
    @Consumes(value = "application/json")
    public void createProduits(@NotNull @RequestBody Produit produit){
        produitRepository.save(produit);
    }

}
