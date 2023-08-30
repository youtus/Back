package com.imt.delirium.repositories;

import com.imt.delirium.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
