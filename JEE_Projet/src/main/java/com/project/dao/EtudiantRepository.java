package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.clients.Etudiant;

/**
 * <b>interface de la couche dao.</b>
 * <p>
 * interdace Spring Data implementant l'API permettant les operations CRUD de bases pour les tables relationnelles
 * </p>
 * 
 * @author Sayfeddine
 * 
 */

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long>{

}
