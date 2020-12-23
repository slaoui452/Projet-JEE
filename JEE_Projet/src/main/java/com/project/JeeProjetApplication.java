package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.project.clients.Etudiant;

import com.project.clients.Presencetable;
import com.project.clients.Profs;
import com.project.dao.EtudiantRepository;
import com.project.dao.PresenceRepository;
import com.project.dao.ProfsRepository;
import com.project.dao.SeanceRepository;

@SpringBootApplication
public class JeeProjetApplication implements CommandLineRunner {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private PresenceRepository presenceRepository;
	@Autowired
    private ProfsRepository profRepository ;
    //@Autowired
    //private Seance_actvRepository seance_actvRepository;
	//@Autowired
    //private SeanceRepository seanceRepository ;
	public static void main(String[] args) {
		SpringApplication.run(JeeProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	

}
