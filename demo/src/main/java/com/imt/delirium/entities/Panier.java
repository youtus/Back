package com.imt.delirium.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Panier {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany ( cascade = CascadeType.ALL )
    @JoinColumn
    private List<Produit> listProduit;

    @OneToOne ( cascade = CascadeType.ALL )
    @JoinColumn(name = "adresse", nullable = false)
    private Adresse adresse;

    public Integer id() {
        return id;
    }

    public Panier setId(Integer id) {
        this.id = id;
        return this;
    }

    public List<Produit> listProduit() {
        return listProduit;
    }

    public Panier setListProduit(ArrayList<Produit> listProduit) {
        this.listProduit = listProduit;
        return this;
    }

    public Adresse adresse() {
        return adresse;
    }

    public Panier setAdresse(Adresse adresse) {
        this.adresse = adresse;
        return this;
    }
}
