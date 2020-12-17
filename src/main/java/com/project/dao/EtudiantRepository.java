package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.clients.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long>{

	
}
