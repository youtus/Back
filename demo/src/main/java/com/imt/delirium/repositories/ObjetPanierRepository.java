package com.imt.delirium.repositories;

import com.imt.delirium.entities.ObjetPanier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetPanierRepository extends JpaRepository<ObjetPanier, Long> {
}