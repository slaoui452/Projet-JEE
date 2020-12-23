package com.project.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.clients.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long>{

}
