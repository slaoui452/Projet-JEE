package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


import com.project.clients.Seance_actv;

public interface Seance_actvRepository extends JpaRepository<Seance_actv,Long> {
	 @Transactional
	void deleteById(int id);
}
