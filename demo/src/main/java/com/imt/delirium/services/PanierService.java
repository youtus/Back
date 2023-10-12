package com.imt.delirium.services;

import com.imt.delirium.entities.ObjetPanier;
import com.imt.delirium.entities.Panier;
import com.imt.delirium.entities.Produit;
import com.imt.delirium.entities.Utilisateur;
import com.imt.delirium.repositories.PanierRepository;
import com.imt.delirium.repositories.ProduitRepository;
import com.imt.delirium.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Panier getPanierByUtilisateurId(Long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        return utilisateur.getPanier();
    }

    public void ajouterProduit(Long panierId, Long produitId, int quantite) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier non trouvé"));
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

        ObjetPanier objetPanier = new ObjetPanier();
        objetPanier.setProduit(produit);
        objetPanier.setQuantite(quantite);

        panier.getListObjetPanier().add(objetPanier);
        panierRepository.save(panier);
    }

    public void retirerProduit(Long panierId, Long produitId) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier non trouvé"));
        ObjetPanier objetPanier = panier.getListObjetPanier().stream()
                .filter(op -> op.getProduit().getId().equals(produitId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Produit non trouvé dans le panier"));

        panier.getListObjetPanier().remove(objetPanier);
        panierRepository.save(panier);
    }

    public void modifierQuantiteProduit(Long panierId, Long produitId, int nouvelleQuantite) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier non trouvé"));
        ObjetPanier objetPanier = panier.getListObjetPanier().stream()
                .filter(op -> op.getProduit().getId().equals(produitId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Produit non trouvé dans le panier"));

        objetPanier.setQuantite(nouvelleQuantite);
        panierRepository.save(panier);
    }
}
