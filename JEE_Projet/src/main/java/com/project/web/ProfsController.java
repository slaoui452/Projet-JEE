package com.project.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.clients.Etudiant;
import com.project.clients.PresProf;
import com.project.clients.Presencetable;
import com.project.clients.Profs;
import com.project.clients.Seance_actv;
import com.project.clients.Seances;
import com.project.dao.EtudiantRepository;
import com.project.dao.PresenceRepository;
import com.project.dao.ProfsRepository;
import com.project.dao.SeanceRepository;
import com.project.dao.Seance_actvRepository;

//import java.util.Base64.Encoder;	

@Controller

public class ProfsController {

	@Autowired
	private PresenceRepository presencerepository;
	@Autowired
	private EtudiantRepository etudiantrepository;
	@Autowired
	private ProfsRepository profsrepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private Seance_actvRepository seance_actvrepository;
	
	
	public static Profs GetByCode_Prof(String Code_Prof, List<Profs> Profs) {
		int i =0;
		while (!Profs.get(i).getCode_prof().equals(Code_Prof) && i<Profs.size()-1) {
			  i++;
			}
		if (Profs.get(i).getCode_prof().equals(Code_Prof))
			return Profs.get(i);
		else
			return null;
	}
	
	
	public String GetRandomCode() {
		String randomeCode="";
		Random rand = new Random();
		for(int i =0;i<6;i++) {
			char c = (char)(rand.nextInt(26) + 97);
			randomeCode=randomeCode + Character.toUpperCase(c);
		}
		return randomeCode;
	}
	
	public void insertTEtudiant(List<Etudiant> etudianbygp,Seance_actv SeanceActv1) {
		for (int i = 0; i<etudianbygp.size();i++) {
			presencerepository.save(new Presencetable(0,etudianbygp.get(i).getCode_etudiant(),SeanceActv1.getCode_prof() , SeanceActv1.getGroupe(),false,SeanceActv1.getMdp()));
		}
	}


	//@Autowired
	//Name names;
	@RequestMapping(value="/Espace_Profs",method=RequestMethod.GET)
	public String index(Model model,
			@RequestParam(name="uidprof",defaultValue="") String Code_Prof,
			@RequestParam(name="groupe",defaultValue="") int Groupe){
		
		 String rand=GetRandomCode();
		 List<Seance_actv> seance_actv=seance_actvrepository.findAll();
		 Seance_actv SeanceActv=SeanceActvController.GetByGroupe(Groupe,seance_actv);
		 List<Profs> Profs=profsrepository.findAll();
		 Profs prof=GetByCode_Prof(Code_Prof,Profs);

		 if (SeanceActv==null) {
			 seance_actvrepository.save(new Seance_actv(0,Groupe,Code_Prof,rand));
			 List<Seance_actv> seance_actv1=seance_actvrepository.findAll();
			 Seance_actv SeanceActv1=SeanceActvController.GetByGroupe(Groupe,seance_actv1);
			 List<Seances> seance=seanceRepository.findAll();
			 Seances Seance=SeanceActvController.GetByGroupeprof(SeanceActv1.getGroupe(),SeanceActv1.getCode_prof(),seance);
			 setSeance(Seance,SeanceActv1,prof);
			 List<Etudiant> etudiants=etudiantrepository.findAll();
			 List<Etudiant> etudianbygp = EtudiantController.GetlisteByGroupe(Groupe,etudiants);
			 insertTEtudiant(etudianbygp,SeanceActv1);
			 
		 }
		 model.addAttribute("code_prof",Code_Prof);
		 model.addAttribute("prof",prof);
		 model.addAttribute("listprofs",Profs);
		 model.addAttribute("groupe",Groupe);
		 return "VueProf";
	}
	
	public List<Presencetable> GetByQR(String CodeQr) {
		List<Presencetable> presence = presencerepository.findAll();
		List<Presencetable> presenceSeance = new ArrayList<Presencetable>();
		int i;
		for (i=0;i<presence.size();i++) {
			if (presence.get(i).getCode_Seance().equals(CodeQr))
				presenceSeance.add(presence.get(i));
		}
		return presenceSeance;
	}
	
	public List<PresProf> GetTablePresProf(List<Presencetable> presences,List<String> Seance_code, int Groupe){
		
		List<PresProf> List_Presence= new ArrayList<PresProf>();
		List<Etudiant> etudiants=etudiantrepository.findAll();

		int j=0;
		List<List<Presencetable>> Etd_Seance= new ArrayList<List<Presencetable>>();
		System.out.println(Seance_code.size());
		while (!Seance_code.get(j).equals("") && j< Seance_code.size()-1) {
			List<Presencetable> Etd_Seance1 = GetByQR(Seance_code.get(j));
			Etd_Seance.add(Etd_Seance1);
			j++;
		}
		if (!Seance_code.get(j).equals(""))	{
			List<Presencetable> Etd_Seance1 = GetByQR(Seance_code.get(j));
			Etd_Seance.add(Etd_Seance1);	
		}

		for (int i =0 ;i<Etd_Seance.get(0).size();i++){
			List<String> Presence = new ArrayList<String>();
			Etudiant etudiant=EtudiantController.GetByCode_etudiant(Etd_Seance.get(0).get(i).getCode_etudiant(),etudiants);
			
			for (int a=0;a<Etd_Seance.size();a++) {
				String Etd1 = Etd_Seance.get(a).get(i).isPresence() ? "P" : "Abs";
				Presence.add(Etd1);
			}
			while(Presence.size()<10)
				Presence.add("");
			PresProf Etd =new PresProf(0,etudiant.getCode_etudiant() , etudiant.getNom(), etudiant.getprenom(),etudiant.getGroupe(), 
					Presence.get(0),Presence.get(1),Presence.get(2),Presence.get(3),Presence.get(4),Presence.get(5),Presence.get(6),
					Presence.get(7), Presence.get(8), Presence.get(9));
			List_Presence.add(Etd);
	    }
	    return List_Presence;
	}
	
	@RequestMapping(value="/Presence",method=RequestMethod.GET)
	public String index2(Model model,
			@RequestParam(name="uidprof",defaultValue="") String Code_Prof,
			@RequestParam(name="matiere",defaultValue="") String Matiere,
			@RequestParam(name="groupe",defaultValue="") int Groupe){
		 List<Presencetable> presences=presencerepository.findAll();
		 List<Seances> seance=seanceRepository.findAll();
		 Seances Seance=SeanceActvController.GetByGroupeprof(Groupe,Code_Prof,seance);
		 List<String> Seance_code = Arrays.asList(Seance.getSeance0(),Seance.getSeance1(),
				 Seance.getSeance2(),Seance.getSeance3(),Seance.getSeance4(),Seance.getSeance5(),Seance.getSeance6(),
				 Seance.getSeance7(),Seance.getSeance8(),Seance.getSeance9());
		 List<PresProf> presenceTable = GetTablePresProf(presences,Seance_code,Groupe);
		 model.addAttribute("matiere", Matiere);
		 model.addAttribute("Code_Prof", Code_Prof);
		 model.addAttribute("Tableau",presenceTable);
		 return "PresProf";
		 
	}
	
	@RequestMapping(value="/Acceuil",method=RequestMethod.GET)
	public String index1(Model model,
			@RequestParam(name="groupe",defaultValue="") int Groupe){

		 List<Seance_actv> seance_actv=seance_actvrepository.findAll();
		 Seance_actv SeanceActv=SeanceActvController.GetByGroupe(Groupe,seance_actv);
		 int x=SeanceActv.getId();
		 seance_actvrepository.deleteById(x);
		 return "redirect:/index";
		 
	}


	public void setSeance(Seances Seance,Seance_actv seanceactv, Profs prof) {
		if (Seance==null) {
		seanceRepository.save(new Seances(0, prof.getCode_prof(),seanceactv.getGroupe(),seanceactv.getMdp(),"","","","","","","","",""));	
		}
		else if (Seance.getSeance1().equals("")) {
			Seance.setSeance1(seanceactv.getMdp());
			seanceRepository.save(Seance);}	
		else if (Seance.getSeance2().equals("")){
			Seance.setSeance2(seanceactv.getMdp());
			seanceRepository.save(Seance);}	
		else if (Seance.getSeance3().equals("")){
			Seance.setSeance3(seanceactv.getMdp());
			seanceRepository.save(Seance);}
		else if (Seance.getSeance4().equals("")){
			Seance.setSeance4(seanceactv.getMdp());;
			seanceRepository.save(Seance);}
		else if (Seance.getSeance5().equals("")){
			Seance.setSeance5(seanceactv.getMdp());
			seanceRepository.save(Seance);}
		else if (Seance.getSeance6().equals("")){
			Seance.setSeance6(seanceactv.getMdp());
			seanceRepository.save(Seance);}
		else if (Seance.getSeance7().equals("")){
			Seance.setSeance7(seanceactv.getMdp());
			seanceRepository.save(Seance);}
		else if (Seance.getSeance8().equals("")){
			Seance.setSeance8(seanceactv.getMdp());
			seanceRepository.save(Seance);}
		else if (Seance.getSeance9().equals("")){
			Seance.setSeance9(seanceactv.getMdp());
			seanceRepository.save(Seance);}
		
		else {
			seanceRepository.save(Seance);
			System.out.println("Vous avez fais tous vos seances");
		}
		
	}
	
	
}