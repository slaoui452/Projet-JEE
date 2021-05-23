package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


import com.project.clients.Seance_actv;

/**
 * <b>interface de la couche dao.</b>
 * <p>
 * interdace Spring Data implementant l'API permettant les operations CRUD de bases pour les tables relationnelles
 * </p>
 * 
 * @author Sayfeddine
 * 
 */
public interface Seance_actvRepository extends JpaRepository<Seance_actv,Long> {
	 @Transactional
	void deleteById(int id);
}
