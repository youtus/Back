package com.imt.delirium.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Panier {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany ( cascade = CascadeType.ALL )
    @JoinColumn
    private List<Produit> listProduit;

    @OneToOne ( cascade = CascadeType.ALL )
    @JoinColumn(name = "adresse", nullable = false)
    private Adresse adresse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produit> getlistProduit() {
        return listProduit;
    }

    public Panier setListProduit(ArrayList<Produit> listProduit) {
        this.listProduit = listProduit;
        return this;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
