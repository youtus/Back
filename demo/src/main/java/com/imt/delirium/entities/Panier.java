package com.imt.delirium.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Panier {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "panier", cascade = CascadeType.ALL)
    @JsonBackReference
    private Utilisateur utilisateur;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "panier_id")
    private List<ObjetPanier> listObjetPanier = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<ObjetPanier> getListObjetPanier() {
        return listObjetPanier;
    }

    public void setListObjetPanier(List<ObjetPanier> listObjetPanier) {
        this.listObjetPanier = listObjetPanier;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {this.adresse = adresse;}
}
