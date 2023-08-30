package com.imt.delirium;

import com.imt.delirium.entities.Produit;
import com.imt.delirium.ressources.AdresseRessources;
import com.imt.delirium.ressources.PanierRessource;
import com.imt.delirium.ressources.ProduitResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("demo")
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(ProduitResource.class);
        register(AdresseRessources.class);
        register(PanierRessource.class);
    }
}
