package com.imt.delirium.services;

import com.imt.delirium.entities.Panier;
import com.imt.delirium.entities.Utilisateur;
import com.imt.delirium.repositories.PanierRepository;
import com.imt.delirium.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PanierRepository panierRepository;

    public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);

        Panier panier = new Panier();
        panier.setUtilisateur(utilisateur);
        panierRepository.save(panier);

        utilisateur.setPanier(panier);
        utilisateurRepository.save(utilisateur);
        System.out.println(utilisateur);
        return utilisateur;
    }
}
