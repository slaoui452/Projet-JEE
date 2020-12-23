package com.project.web;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.WriterException;
import com.project.clients.Etudiant;
import com.project.clients.Presencetable;
import com.project.clients.Profs;
import com.project.clients.Seance_actv;
import com.project.clients.Seances;
import com.project.dao.EtudiantRepository;
import com.project.dao.PresenceRepository;
import com.project.dao.ProfsRepository;
import com.project.dao.Seance_actvRepository;


@Controller

public class SeanceActvController {

	@Autowired
	private EtudiantRepository etudiantrepository;
	@Autowired
	private Seance_actvRepository seance_actvrepository;
	@Autowired
	private ProfsRepository profsrepository;
	@Autowired
	private PresenceRepository presencerepository;
	
	
	public static Seance_actv GetByGroupe(int Groupe, List<Seance_actv> seance_actv) {
		int i =0;
		if (seance_actv.size()==0)
			return null;
		while (seance_actv.get(i).getGroupe()!=Groupe && i<seance_actv.size()-1) {
			  i++;
			}
		if (seance_actv.get(i).getGroupe()==Groupe)
			return seance_actv.get(i);
		else
			return null;
	}
	
	public static Seances GetByGroupeprof(int groupe,String Code_prof, List<Seances> seance ) {

		if (seance.size()==0)
			return null;
		System.out.println(seance.size());
		for (int i = 0 ; i<seance.size();i++) {
			
			if (i<10) {
				if(seance.get(i).getGroupe()==groupe && seance.get(i).getCode_Prof().equals(Code_prof) ) {
					return seance.get(i);
				}
			}
		}
		return null;
	}
	
	public Presencetable GetByQRCode_Etd(String CodeQr, String Code_Etudiant) {
		List<Presencetable> presence = presencerepository.findAll();
		int i = 0;
		while(!presence.get(i).getCode_etudiant().equals(Code_Etudiant) || !presence.get(i).getCode_Seance().equals(CodeQr)) {
			i++;
		}
		return presence.get(i);
	}
	
	public void present(String CodeQr, String Code_Etudiant) {
		Presencetable ligneEtd = GetByQRCode_Etd(CodeQr,Code_Etudiant);
		ligneEtd.setPresence(true);
		presencerepository.save(ligneEtd);
	}
	
	public static boolean CodeCorrect(String CodeIN,String CodeTab) {
		return CodeIN.equals(CodeTab);
	}
	
	@RequestMapping(value="/AccessSucces",method=RequestMethod.GET)
	public String index(Model model,
			@RequestParam(name="codeQr",defaultValue="") String CodeQr,
			@RequestParam(name="EtuId",defaultValue="") String Code_Etudiant) throws WriterException, IOException {
		
		 List<Seance_actv> seance_actv=seance_actvrepository.findAll();
		 List<Etudiant> etudiants=etudiantrepository.findAll();
		 List<Profs> Profs=profsrepository.findAll();
		 
		 Etudiant etudiant=EtudiantController.GetByCode_etudiant(Code_Etudiant,etudiants);
		 Seance_actv SeanceActv=SeanceActvController.GetByGroupe(etudiant.getGroupe(),seance_actv);
		 Profs prof=ProfsController.GetByCode_Prof(SeanceActv.getCode_prof(),Profs);
		 
		 model.addAttribute("prof",prof);
		 model.addAttribute("SeanceActv",SeanceActv);
		 model.addAttribute("etudiant",etudiant);
		 model.addAttribute("QR_1",Base64.getEncoder().encodeToString(EtudiantController.getQRCodeImage(SeanceActv.getMdp(),500,500)));
		 if (CodeCorrect(CodeQr,SeanceActv.getMdp()))
		 {
			 present(CodeQr,Code_Etudiant);
		     return "Conference";
		     
		 }
		 return "VueEtudiant";
	}
	
	@RequestMapping(value="/Conference",method=RequestMethod.GET)
	public String index(Model model,
			@RequestParam(name="EtuId",defaultValue="") String Code_Etudiant) {
		 List<Etudiant> etudiants=etudiantrepository.findAll();
		 Etudiant etudiant=EtudiantController.GetByCode_etudiant(Code_Etudiant,etudiants);
		 model.addAttribute("etudiant",etudiant);
		 return "Conference";
	}
}
