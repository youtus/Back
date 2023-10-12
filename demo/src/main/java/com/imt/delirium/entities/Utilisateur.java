package com.imt.delirium.entities;


import javax.persistence.*;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Long solde;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "panier_id", referencedColumnName = "id")
    private Panier panier;

    public Long getId() {
        return id;
    }

    public Utilisateur setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Utilisateur setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public Utilisateur setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Utilisateur setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getSolde() {
        return solde;
    }

    public Utilisateur setSolde(Long solde) {
        this.solde = solde;
        return this;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
}
