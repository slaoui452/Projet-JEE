package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.clients.Presencetable;

public interface PresenceRepository extends JpaRepository<Presencetable,Long> {

	
}
