package com.imt.delirium;

import com.imt.delirium.config.CORSFilter;
import com.imt.delirium.entities.Produit;
import com.imt.delirium.ressources.*;
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
        register(UtilisateurRessources.class);
        register(AuthData.class);
        register(AjouterProduitData.class);
        register(CORSFilter.class);
    }
}
