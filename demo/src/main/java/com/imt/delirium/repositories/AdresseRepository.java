package com.imt.delirium.repositories;

import com.imt.delirium.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AdresseRepository extends JpaRepository<Adresse, Long>{
}
