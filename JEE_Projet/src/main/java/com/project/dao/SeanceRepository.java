package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.clients.Seances;
/**
 * <b>interface de la couche dao.</b>
 * <p>
 * interdace Spring Data implementant l'API permettant les operations CRUD de bases pour les tables relationnelles
 * </p>
 * 
 * @author Sayfeddine
 * 
 */
public interface SeanceRepository extends JpaRepository<Seances,Long>{

}
