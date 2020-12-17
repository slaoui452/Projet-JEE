package com.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.clients.Etudiant;
import com.project.dao.EtudiantRepository;

@Controller

public class EtudiantController {

	@Autowired
	private EtudiantRepository etudiantrepository;
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model) {
		 List<Etudiant> etudiants=etudiantrepository.findAll();
		 model.addAttribute("listEtudiants",etudiants);
		 return "etudiants";
	}
	
}
