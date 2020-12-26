package com.project.web;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.clients.Etudiant;
import com.project.clients.Presencetable;
import com.project.clients.Profs;
import com.project.clients.Seance_actv;
import com.project.dao.EtudiantRepository;
import com.project.dao.PresenceRepository;
import com.project.dao.ProfsRepository;
import com.project.dao.Seance_actvRepository;

import java.util.ArrayList;
import java.util.Base64;

/**
 * <b>EtudiantController est un Web Controller.</b>
 *
 * <p>
 * Cette classe est un controlleur  spring MVC  utilisé pour implementer les traitement concernant les etudiants dans l'application web.
 * </p>
 * <p>
 * l'annotation Controller permettera la detection de ces classes à travers le classpath scanning
 * </p>
 * @see Etudiant
 * @author khalil
 * 
 */
@Controller
public class EtudiantController {
	
	/**
     * 	cherche un etudiant dans la base de données a travers son code.
     *
     * @param Code_Etudiant
     *            	le code indentifiant l'etudiant cherché.
     * @param etudiants
     * 				liste implementant la table dans une base de donné de tout les élèves.
     * @return	les attributs de l'etudiant cherché
     * @see Etudiant 
     * 				         
     */
	public static Etudiant GetByCode_etudiant(String Code_Etudiant, List<Etudiant> etudiants) {
		int i =0;
		while ((!etudiants.get(i).getCode_etudiant().equals(Code_Etudiant)) && i<etudiants.size()-1 ) {
			  i++;
			}
		if (etudiants.get(i).getCode_etudiant().equals(Code_Etudiant))
			return etudiants.get(i);
		else 
			return null;
	}
	/**
     * 	cherche a filtrer les etudiant appartenant a un groupe.
     *
     * @param groupe
     *            	le groupe demandé.
     * @param etudiants
     * 				liste implementant la table dans base de donné de tout les élèves.
     * @return	table contenant les eleve du groupe concerné
     * @see Etudiant 
     * 				         
     */
	
	public static List<Etudiant> GetlisteByGroupe(int groupe, List<Etudiant> etudiants) {
		List<Etudiant> liste = new ArrayList<Etudiant>();
		for (int i =0;i<etudiants.size();i++) {
			if (etudiants.get(i).getGroupe()==groupe) {
				liste.add(etudiants.get(i));
			}
		}
		return liste;
	}
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
	

	/**
     * 	cherche un etudiant dans la base de données a travers son code.
     *
     *   @param model         	
     * @return	la vue Etudiants
     * 				         
     */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model) {
		 return "Etudiants";
	}
	

	/**
     * Permet de calculer le nombre d'absence d'un etudiant dans chaque matière.
     *
     * @param code_Etudiant
     *            	le code indentifiant l'etudiant cherché.
     *
     * @return	un tableau double contenant la matière et le nombre de seance absenté correspondant.
     * 
     * 				         
     */
		public String[][] Get_Absence(String code_Etudiant) {
			String[][] tab =new String[400][2];
			List<Presencetable> presences=presencerepository.findAll();
			List<Etudiant> etudiants=etudiantrepository.findAll();
			List<Profs> Profs=profsrepository.findAll();

			for (int i=0 ; i< Profs.size() ; i++){
				
				int abs = 0;
				for ( int j=0 ; j<presences.size();j++ ){
					
					if (presences.get(j).getCode_etudiant().equals(code_Etudiant) &&  presences.get(j).getCode_prof().equals(Profs.get(i).getCode_prof()))
					{	
						tab[i][0]=Profs.get(i).getMatiere(); // element 0 de chaque table represente 
						if (!(presences.get(j).isPresence())) 
							{abs++;}
					}
			
				}
			tab[i][1]=Integer.toString(abs); // element 1 de chaque table est le nombre d abs sur chaque
			
			}
			//System.out.println("------>>>>>   " + tab[0][0].toString());
			return tab;
		}
	//----------------------------------------------------------------------------------------------------
		
		
		/**
	     * La methode Espace_Etudiant sera appelé a travers le Mapping c'est a dire à partir de l'url. Cette methode nous offre
	     * plusieur fonctiannalité :
	     * <ul>
	     * <li>Verifier l'identification.</li>
	     * <li>Savoir s'il exeste une seance active ou non avec son groupe</li>
	     * <li>Générer Le Code QR.</li>
	     * <li>Ajouter les attributs au model et faire appele à la page html adequate 
	     * <ul>
	     * <li>"Etudiants" : si les identifianr sont incorecte</li>
	     * <li>"PasCours" : si le groupe n'a pas de seance active</li>
	     * <li>"VueEtudiant" : si il existe une seance</li>
	     * </ul>
	     * </li>
	     * </ul>
	     * @param model
	     * @param Code_Etudiant
	     * @return page html

	     */
	@RequestMapping(value="/Espace_Etudiant",method=RequestMethod.GET)
	public String Espace_Etudiant(Model model,
			@RequestParam(name="uidetd",defaultValue="") String Code_Etudiant)  throws WriterException, IOException {
		
		 List<Seance_actv> seance_actv=seance_actvrepository.findAll();
		 List<Etudiant> etudiants=etudiantrepository.findAll();
		 List<Profs> Profs=profsrepository.findAll();


		 try {
		 Etudiant etudiant=GetByCode_etudiant(Code_Etudiant,etudiants);
		 Seance_actv SeanceActv=SeanceActvController.GetByGroupe(etudiant.getGroupe(),seance_actv);
			}

			catch(Exception e) {
			  return "Etudiants";
			}
		 
		 Etudiant etudiant=GetByCode_etudiant(Code_Etudiant,etudiants);
		 
		 model.addAttribute("etudiant",etudiant);
		 model.addAttribute("listEtudiants",etudiants);
		 try {
			 Seance_actv SeanceActv=SeanceActvController.GetByGroupe(etudiant.getGroupe(),seance_actv);
			 Profs prof=ProfsController.GetByCode_Prof(SeanceActv.getCode_prof(),Profs);
			 model.addAttribute("prof",prof);
			 model.addAttribute("SeanceActv",SeanceActv);
			 model.addAttribute("QR_1",Base64.getEncoder().encodeToString(getQRCodeImage(SeanceActv.getMdp(),500,500)));
			 return "VueEtudiant";
		 }
			catch(Exception e) {
				  return "PasCours";
				}
		 
	}
	//----------------------------------------------------------------------------------------------------

	
	//----------------------------------------------------------------------------------------------------
	/**
     * Cette methode a pour but d'afficher les nombres d'absence par seance d'un etudiant a la demande.
     * @param model
     * @param Code_Etudiant
     * 				code de l'etudiant concerné afin de pouvoire afficher les informations adequate
     * @return La page HTML "EtudPres"
     * 				         
     */
	@RequestMapping(value="/TableauEtud",method=RequestMethod.GET)
	public String PresenceEtud(Model model,
			@RequestParam(name="uidetd",defaultValue="") String Code_Etudiant){
		 String[][] Etudiant_Abs=Get_Absence(Code_Etudiant);
		 model.addAttribute("Etudiant_Abs",Etudiant_Abs);
		 model.addAttribute("Code_Etudiant",Code_Etudiant);
		 return "EtudPres";
		 
	}
	//----------------------------------------------------------------------------------------------------


	

	/**
     * 	Convertir une chaine de caractère en code QR 2D.
     *
     * @param text
     *            	le code qu'on cherche a convertir.
     * @param width
     * 				largeur de l'image
     * @param height
     * 				
     * @return	image du Qr code generé
     * @see Etudiant 	         
     */
	
	static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
	    QRCodeWriter qrCodeWriter = new QRCodeWriter();
	    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
	    
	    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
	    byte[] pngData = pngOutputStream.toByteArray(); 
	    return pngData;
	}
	//----------------------------------------------------------------------------------------------------


	
	

}
