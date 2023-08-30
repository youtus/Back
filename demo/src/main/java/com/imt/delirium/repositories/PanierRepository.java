package com.imt.delirium.repositories;

import com.imt.delirium.entities.Adresse;
import com.imt.delirium.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PanierRepository extends JpaRepository<Panier, Long>{
}
