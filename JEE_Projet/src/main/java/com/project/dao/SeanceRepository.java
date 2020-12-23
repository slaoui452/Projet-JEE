package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.clients.Seances;

public interface SeanceRepository extends JpaRepository<Seances,Long>{

}
