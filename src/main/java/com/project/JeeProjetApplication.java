package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.project.clients.Etudiant;

import com.project.clients.Presencetable;
import com.project.dao.EtudiantRepository;
import com.project.dao.PresenceRepository;

@SpringBootApplication
public class JeeProjetApplication implements CommandLineRunner {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private PresenceRepository presenceRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JeeProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		etudiantRepository.save(new Etudiant(0,"BB177207","Mehdi","Slaoui", 1));
		etudiantRepository.save(new Etudiant(0,"HH25146","Khalil","Hadji", 2));
		etudiantRepository.save(new Etudiant(0,"OO666666","Sayfdinne","Addou", 3));
		etudiantRepository.save(new Etudiant(0,"OO485926","Aymane","Hmidich", 4));
		presenceRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
	}
	

}
