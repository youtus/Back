package com.imt.delirium.ressources;

import com.imt.delirium.entities.Panier;
import com.imt.delirium.services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/paniers")
public class PanierRessource {

    @Autowired
    PanierService panierService;

    @GET
    @Path("/{utilisateurId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPanierByUtilisateurId(@PathParam("utilisateurId") Long utilisateurId) {
        Panier panier = panierService.getPanierByUtilisateurId(utilisateurId);
        return Response.ok(panier).build();
    }

    @POST
    @Path("/ajouterproduit")
    @Consumes(value = "application/json")
    //@Produces(value = "application/json")
    public Response ajouterProduit(@NotNull @RequestBody AjouterProduitData data) {
        panierService.ajouterProduit(data.getPanierId(), data.getProduitId(), data.getQuantity());
        return Response.ok().build();
    }

    @PUT
    @Path("/{panierId}/produits/{produitId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifierQuantiteProduit(@PathParam("panierId") Long panierId, @PathParam("produitId") Long produitId, int nouvelleQuantite) {
        panierService.modifierQuantiteProduit(panierId, produitId, nouvelleQuantite);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{panierId}/produits/{produitId}")
    public Response retirerProduit(@PathParam("panierId") Long panierId, @PathParam("produitId") Long produitId) {
        panierService.retirerProduit(panierId, produitId);
        return Response.ok().build();
    }
}
