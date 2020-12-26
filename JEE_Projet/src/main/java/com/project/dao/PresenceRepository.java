package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.clients.Presencetable;
/**
 * <b>interface de la couche dao.</b>
 * <p>
 * interdace Spring Data implementant l'API permettant les operations CRUD de bases pour les tables relationnelles
 * </p>
 * 
 * @author Sayfeddine
 * 
 */
public interface PresenceRepository extends JpaRepository<Presencetable,Long> {

	
}
