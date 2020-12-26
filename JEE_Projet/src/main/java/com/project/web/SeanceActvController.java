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
/**
 * <b>SeanceActvtController est un web Controller .</b>
 * <p>
 * Cette classe est un controlleur  spring MVC  utilisé pour implementer les traitement concernant les séances dans l'application web.
 * </p>
 * <p>
 * l'annotation Controller permettera la detection de ces classes à travers le classpath scanning
 * </p>
 * @see Seance_actv
 * 
 * @author aymane
 * 
 */

@Controller
public class SeanceActvController {
	/**
	 * injection des repositories et liaison des beans
	 */
	@Autowired
	private EtudiantRepository etudiantrepository;
	/**
	 * injection des repositories et liaison des beans
	 */
	@Autowired
	private Seance_actvRepository seance_actvrepository;
	/**
	 * injection des repositories et liaison des beans
	 */
	@Autowired
	private ProfsRepository profsrepository;
	/**
	 * injection des repositories et liaison des beans
	 */
	@Autowired
	private PresenceRepository presencerepository;
	
	
//----------------------------------------------------------------------------------------------------

	/**
     * 	cherche a filtrer les séances appartenant a un groupe.
     *
     * @param groupe
     *            	le groupe demandé.
     * @param seance_actv
     * 				liste implementant la table dans base de donné des seances actives.
     * @return	table contenant les seance du groupe concerné
     * @see Etudiant 
     * 				         
     */
	
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
	
	
//----------------------------------------------------------------------------------------------------

	/**
     * 	cherche a filtrer les séances appartenant a un groupe.
     *
     * @param groupe
     *            	le groupe demandé.
     * @param seance_actv
     * 				liste implementant la table dans base de donné des seances actives.
     * @param Code_prof
     * 				code du prof concerné
     * @return	table contenant les seance presente par le prof pour le groupe concerné 
     * @see Etudiant 
     * @see Profs
     * 				         
     */
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

	
//----------------------------------------------------------------------------------------------------

	/**
     * Cherche a touver la ligne contenant l'etudiant et la seance pour marquer sa presence dans la database.
     *
     * @param CodeQr
     *            	Le code de la seance.
     * @param Code_Etudiant
     * 				Code de l'etudiant.
     * @return Presencetable contenant le code_etudiant et le Code Seance.
     * 
     * @see #present(String, String)
     * 				         
     */
	
	public Presencetable GetByQRCode_Etd(String CodeQr, String Code_Etudiant) {
		List<Presencetable> presence = presencerepository.findAll();
		int i = 0;
		while(!presence.get(i).getCode_etudiant().equals(Code_Etudiant) || !presence.get(i).getCode_Seance().equals(CodeQr)) {
			i++;
		}
		return presence.get(i);
	}
	
	
//----------------------------------------------------------------------------------------------------
	
	/**
     * Marquer la presence d'un etudiant dant la database
     *
     * @see #Acces(Model, String, String)
     * 				         
     */
	
	
	public void present(String CodeQr, String Code_Etudiant) {
		Presencetable ligneEtd = GetByQRCode_Etd(CodeQr,Code_Etudiant);
		ligneEtd.setPresence(true);
		presencerepository.save(ligneEtd);
	}
	
	
//----------------------------------------------------------------------------------------------------

	/**
     * Verifier la validiter du Code Qr.
     *
     * @param CodeQr
     *            	Le code de la seance.
     * @param CodeTab
     * 				Le code entrer par l'étudiant.
     * @return True or False.
     * 
     * @see #present(String, String)
     * 				         
     */

	public static boolean CodeCorrect(String CodeIN,String CodeTab) {
		return CodeIN.equals(CodeTab);
	}
	
	
//----------------------------------------------------------------------------------------------------

	/**
     * La méthode Acces Retourne une page Html, cette page contiendra la conference en cas de validation du code,
     * sinon il demendra de réessayer la saisie.
     * @param CodeQr 
     * 		celle entrer par l'etudiant dans la page vueEtudiant.html
     */
	
	@RequestMapping(value="/AccessSucces",method=RequestMethod.GET)
	public String Acces(Model model,
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
	
	
//----------------------------------------------------------------------------------------------------
	/**
     * 	Aprés la vérification de la validité du code Qr, l'etape de rejoindre la conference est cette methode
     *
     * @param Code_Etudiant
     * 				code de l'etudiant concerné afin de pouvoire afficher ses information dans la page Conférence.html
     * @return La page HTML "Conference"
     * 				         
     */

	@RequestMapping(value="/Conference",method=RequestMethod.GET)
	public String Conference(Model model,
			@RequestParam(name="EtuId",defaultValue="") String Code_Etudiant) {
		 List<Etudiant> etudiants=etudiantrepository.findAll();
		 Etudiant etudiant=EtudiantController.GetByCode_etudiant(Code_Etudiant,etudiants);
		 model.addAttribute("etudiant",etudiant);
		 return "Conference";
	}

}
