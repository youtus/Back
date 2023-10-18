package com.imt.delirium.ressources;

import org.springframework.stereotype.Component;

@Component
public class AjouterProduitData {

    private Long panierId;
    private Long produitId;
    private int quantity;

    public Long getPanierId() {
        return panierId;
    }

    public void setPanierId(Long panierId) {
        this.panierId = panierId;}

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;}
}
