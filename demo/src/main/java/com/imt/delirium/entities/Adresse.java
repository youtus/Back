package com.imt.delirium.entities;

import javax.persistence.*;

@Entity
public class Adresse {

    @Id
    @GeneratedValue
    private Long id;

    private String rue;

    private String ville;

    private Integer cp;

    @OneToOne(mappedBy = "adresse")
    private Panier panier;

    public Panier panier() {
        return panier;
    }

    public Adresse setPanier(Panier panier) {
        this.panier = panier;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public Adresse setRue(String rue) {
        this.rue = rue;
        return this;
    }

    public String getVille() {
        return ville;
    }

    public Adresse setVille(String ville) {
        this.ville = ville;
        return this;
    }

    public Integer getCp() {
        return cp;
    }

    public Adresse setCp(Integer cp) {
        this.cp = cp;
        return this;
    }
}
