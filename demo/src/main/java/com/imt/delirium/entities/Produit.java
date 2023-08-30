package com.imt.delirium.entities;



import javax.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String titre;

    @Column
    private Long prix;

    @Column
    private String categories;

    @Column
    private String description;


    private String allergenes;
    @Column
    public Integer id() {
        return id;
    }

    public Produit setId(Integer id) {
        this.id = id;
        return this;
    }

    public String titre() {
        return titre;
    }

    public Produit setTitre(String titre) {
        this.titre = titre;
        return this;
    }

    public Long prix() {
        return prix;
    }

    public Produit setPrix(Long prix) {
        this.prix = prix;
        return this;
    }

    public String categories() {
        return categories;
    }

    public Produit setCategories(String categories) {
        this.categories = categories;
        return this;
    }

    public String description() {
        return description;
    }

    public Produit setDescription(String description) {
        this.description = description;
        return this;
    }

    public String allergenes() {
        return allergenes;
    }

    public Produit setAllergenes(String allergenes) {
        this.allergenes = allergenes;
        return this;
    }
}
