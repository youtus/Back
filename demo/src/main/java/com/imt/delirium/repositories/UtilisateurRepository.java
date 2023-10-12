package com.imt.delirium.repositories;

import com.imt.delirium.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email AND u.password = :password")
    Utilisateur findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
