package com.imt.delirium.ressources;

import com.imt.delirium.entities.Panier;
import com.imt.delirium.services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Path("/{panierId}/produits/{produitId}/{quantite}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ajouterProduit(@PathParam("panierId") Long panierId, @PathParam("produitId") Long produitId, @PathParam("quantite") int quantite) {
        panierService.ajouterProduit(panierId, produitId, quantite);
        return Response.status(Response.Status.CREATED).build();
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
