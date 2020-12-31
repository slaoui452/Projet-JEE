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


/**
 *  
 * <b>EtudiantController est un Web Controller.</b>
 *
 * <p>
 * Cette classe est un controlleur  spring MVC  utilisé pour implementer les traitement concernant les etudiants dans l'application web.
 * </p>
 * <p>
 * l'annotation Controller permettera la detection de ces classes à travers le classpath scanning
 * </p>
 * <b>La classe ProfsController vas permettre le controle de la table des Proffesseurs, l'affichage des page html au besoin, 
 * la gestion de presence, la generation du tableux de presence et la verification de l'identité a travers l'identification </b>
 * 
 *
 * @author Mehdi
 * 
 */

@Controller

public class ProfsController {

	/**
	 * injection des repositories et liaison des beans
	 */
	@Autowired
	private PresenceRepository presencerepository;
	/**
	 * injection des repositories et liaison des beans
	 */
	@Autowired
	private EtudiantRepository etudiantrepository;
	/**
	 * injection des repositories et liaison des beans
	 */
	@Autowired
	private ProfsRepository profsrepository;
	/**
	 * injection des repositories et liaison des beans
	 */
	@Autowired
	private SeanceRepository seanceRepository;
	/**
	 * injection des repositories et liaison des beans
	 */
	@Autowired
	private Seance_actvRepository seance_actvrepository;
	
//-------------------------------------------------------------------------------------------------------------------------	
	
	/**
     * La méthode GetByCode_Prof Retourne les informations d'un Professeur à travers son code unique.
     *     
     * @see ProfsController#Espace_Prof(Model, String, int)
     * 
     * @param Code_Prof
     * 			L'identifiant unique du professeur.
     * @param Profs 
     * 			List extraite de la DataBase.
     * 
     * @return un bean contenant les informations du prof en question.
     * 
     */
	
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
	
//-------------------------------------------------------------------------------------------------------------------------	
	
	/**
	 *  La méthode GetRandomCode va être utilisée pour créer un code qui spécifie une séance, ce code va être
	 *  utiliser par la suite pour générer le Code Qr .
     * 
     * @see ProfsController#Espace_Prof(Model, String, int)
     * @see EtudiantController#getQRCodeImage(String, int, int)
     * 
     * @return Chaine de 6 randome caractére.
     * 
     */
	
	public String GetRandomCode() {
		String randomeCode="";
		Random rand = new Random();
		for(int i =0;i<6;i++) {
			char c = (char)(rand.nextInt(26) + 97);
			randomeCode=randomeCode + Character.toUpperCase(c);
		}
		return randomeCode;
	}
	
//-------------------------------------------------------------------------------------------------------------------------	
	
	/**
	 * La méthode insertTetudiant a pour but d'ajouter au repository PresenceRepository la liste des étudiants qui ont une séance active
	 * (À la création de la séance), ces nouvelles lignes seront identifiées par le code de la séance, et la valeur de l'attribut
	 * Présence sera initiée par "false".
     * 
     * @see ProfsController#Espace_Prof(Model, String, int)
     * 
     * @param etudianbygp
     * 			List Contenant tout les étudiants de l'ecole.
     * @param SeanceActv1 
     * 			Bean Seance_actv contenant les informations de la nouvelle Seance (Code_prof, Groupe, Code_Seance).
     * 
     */
	
	
	public void insertTEtudiant(List<Etudiant> etudianbygp,Seance_actv SeanceActv1) {
		for (int i = 0; i<etudianbygp.size();i++) {
			presencerepository.save(new Presencetable(0,etudianbygp.get(i).getCode_etudiant(),SeanceActv1.getCode_prof() , SeanceActv1.getGroupe(),false,SeanceActv1.getMdp()));
		}
	}
	
//-------------------------------------------------------------------------------------------------------------------------	

	/**
	 * La méthode setSeance est la méthode qui permet d'enregistrer le code des seances dans le tableau Seances.
	 * <br> Premièrement, ce tableau va permettre de savoir le nombre de séance restante pour un prof/groupe.
	 * <br> Deuxièmement, les codes des séances vont permettre d'extraire les presences par séance du repository Presencetable.
	 * 
     * @see ProfsController#GetTablePresProf(List, List, int)
     * 
     * @param Seance
     * 			Bean contenant les informations de la seance entre prof/group specifique (null s'il s'agit de la premiere séance)
     * @param seanceactv 
     * 			Bean Seance_actv contenant les informations de la nouvelle Seance (Code_prof, Groupe, Code_Seance).
     * @param prof
     * 			Informations sur le Professeur encadrant.
     * 
     */
	
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
	
//-------------------------------------------------------------------------------------------------------------------------	

	/**
     * La methode Espace_Prof sera appelé a travers le Mapping c'est a dire à partir de l'url. Cette methode nous offre
     * plusieur fonctiannalité :
     * <ul>
     * <li>Verifier l'identification.</li>
     * <li>Générer Le Code QR.</li>
     * <li>Tester s'il s'agit d'un reconnexion à la seance ou s'il s'agit d'une nouvelle qu'on doit créer.</li>
     * <li>Ajouter les attributs au model et faire appele à la page html VueProf.html</li>
     * </ul>
     * 
     * 
     * @param Code_Prof (RequestParam entrée par l'utilisateur dans la page etudiants.html) 
     * 			<p>L'identifiant unique du proffeseur</p>
     * @param Groupe (RequestParam entrée par l'utilisateur dans la page etudiants.html)
     * 			<p>Le groupe avec le quel le prof a cour.</p>
     * 
     */

	//@Autowired
	//Name names;
	@RequestMapping(value="/Espace_Profs",method=RequestMethod.GET)
	public String Espace_Prof(Model model,
			@RequestParam(name="uidprof",defaultValue="") String Code_Prof,
			@RequestParam(name="groupe",defaultValue="") int Groupe){
		
		 
		 List<Seance_actv> seance_actv=seance_actvrepository.findAll();
		 Seance_actv SeanceActv=SeanceActvController.GetByGroupe(Groupe,seance_actv);
		 List<Profs> Profs=profsrepository.findAll();
		 Profs prof=GetByCode_Prof(Code_Prof,Profs);
		 if (prof==null) {
			 model.addAttribute("ERREUR","ERREUR: Code Professeur Incorrect, Veuillez Réessayer! ");
			 return "Etudiants";
		 }
		 if (SeanceActv==null) {
			 List<Etudiant> etudiants=etudiantrepository.findAll();
			 List<Etudiant> etudianbygp = EtudiantController.GetlisteByGroupe(Groupe,etudiants);

			 if (etudianbygp.size()==0) {
				    model.addAttribute("ERREUR","ERREUR: Le Groupe Que Vous Demandez N'existe Pas!");
				    return "Etudiants";
			 }
			 String rand=GetRandomCode();
			 seance_actvrepository.save(new Seance_actv(0,Groupe,Code_Prof,rand));
			 List<Seance_actv> seance_actv1=seance_actvrepository.findAll();
			 Seance_actv SeanceActv1=SeanceActvController.GetByGroupe(Groupe,seance_actv1);

			 List<Seances> seance=seanceRepository.findAll();
			 Seances Seance=SeanceActvController.GetByGroupeprof(SeanceActv1.getGroupe(),SeanceActv1.getCode_prof(),seance);
			 setSeance(Seance,SeanceActv1,prof);
			 insertTEtudiant(etudianbygp,SeanceActv1); 
			 model.addAttribute("code_prof",Code_Prof);
			 model.addAttribute("prof",prof);
			 model.addAttribute("listprofs",Profs);
			 model.addAttribute("groupe",Groupe);
			 return "VueProf";
		 }

		 if (SeanceActv.getCode_prof().equals(Code_Prof)) {
			 model.addAttribute("code_prof",Code_Prof);
			 model.addAttribute("prof",prof);
			 model.addAttribute("listprofs",Profs);
			 model.addAttribute("groupe",Groupe);
			 return "VueProf";
			 }
		 else {
			    model.addAttribute("ERREUR","ERREUR: Le Groupe Que Vous Demandez A Deja Une Seance Avec Un Autre Enseignant!");
			    return "Etudiants";
		 }
		 
	}
	
//-------------------------------------------------------------------------------------------------------------------------	
	
	/**
	 * La méthode DeleteSeane_Actv permet de mettre fin à la séance par le professeur;
	 * (la présence des élèves n'est plus enregistrée après)
     * @param Code_Prof (RequestParam entrée par l'utilisateur dans la page etudiants.html) 
     * 			<p>L'identifiant unique du proffeseur</p>
     * @param Groupe (RequestParam entrée par l'utilisateur dans la page etudiants.html)
     * 			<p>Le groupe avec le quel le prof a cour.</p>
     * 
     */

	
	@RequestMapping(value="/Acceuil",method=RequestMethod.GET)
	public String DeleteSeane_Actv(Model model,
			@RequestParam(name="groupe",defaultValue="") int Groupe){

		 List<Seance_actv> seance_actv=seance_actvrepository.findAll();
		 Seance_actv SeanceActv=SeanceActvController.GetByGroupe(Groupe,seance_actv);
		 int x=SeanceActv.getId();
		 seance_actvrepository.deleteById(x);
		 return "redirect:/index";
		 
	}
	
//-------------------------------------------------------------------------------------------------------------------------	

	/**
	 * Extraire tous les etudiants du groupe qui avais la seance "CodeQr" de la liste presencetable
	 * A laide de cette extraction nous allons pouvoir savoire les etudiant presenté dans une seance est 
	 * l'enregistrer sur les tableaux a genere par demande des etudiants ou des professeurs.
	 *  
     * @see #GetTablePresProf(List, List, int)
     */

	public List<Presencetable> GetByQR(String CodeQr) {
		List<Presencetable> presence = presencerepository.findAll();
		List<Presencetable> presenceSeance = new ArrayList<Presencetable>();
		int i;
		for (i=0;i<presence.size();i++) {
			if (presence.get(i).getCode_Seance().equalsIgnoreCase(CodeQr))
				presenceSeance.add(presence.get(i));
		}
		return presenceSeance;
	}
	
//-------------------------------------------------------------------------------------------------------------------------	

	
	/**
     * La méthode GetTablePresProf Retourne une liste de PresProf plein avec les presences de toutes les seances passée avec le groupe.
     *     
     * 
     * @param presences
     * 			une liste Presencetable extraite de la database.
     * @param Seance_code 
     * 			List de string qui contient toutes les code des seance du module entre le Prof et groupe specifique.
     * @param Groupe 
     * 			Le groupe concernée.
     * 
     * @return une liste de PresProf contenant toutes les pressences des seances antecedante du professeur avec le groupe.
     * 
     * @see #Tableau_Presence_Prof(Model, String, String, int)
     * 
     */
	public List<PresProf> GetTablePresProf(List<Presencetable> presences,List<String> Seance_code, int Groupe){
		
		List<PresProf> List_Presence= new ArrayList<PresProf>();
		List<Etudiant> etudiants=etudiantrepository.findAll();

		int j=0;
		List<List<Presencetable>> Etd_Seance= new ArrayList<List<Presencetable>>();
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
//-------------------------------------------------------------------------------------------------------------------------	

	
	/**
     * La méthode Tableau_Presence_Prof Retourne une page Html "PresProf", cette page contenera le tableaux des presences:
     * <ul>
     * <li>"Abs" : Absent</li>
     * <li>"P" : Present </li>
     * <li>"" : Seance pas encore animée</li>
     * </ul>
     * 
     * @return Page Html "PresProf" contenant la liste complete des presences.
     * 
     * 
     */
	
	@RequestMapping(value="/Presence",method=RequestMethod.GET)
	public String Tableau_Presence_Prof(Model model,
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


	
}