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
@Controller

public class EtudiantController {
	
	
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
	
	public static List<Etudiant> GetlisteByGroupe(int groupe, List<Etudiant> etudiants) {
		List<Etudiant> liste = new ArrayList<Etudiant>();
		for (int i =0;i<etudiants.size();i++) {
			if (etudiants.get(i).getGroupe()==groupe) {
				liste.add(etudiants.get(i));
			}
		}
		return liste;
	}

	@Autowired
	private EtudiantRepository etudiantrepository;
	@Autowired
	private Seance_actvRepository seance_actvrepository;
	@Autowired
	private ProfsRepository profsrepository;
	@Autowired
	private PresenceRepository presencerepository;
	

	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model) {

		 return "Etudiants";
	}
	


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
			System.out.println("------>>>>>   " + tab[0][0].toString());
			return tab;
		}
		
	@RequestMapping(value="/Espace_Etudiant",method=RequestMethod.GET)
	public String index1(Model model,
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
	
	
	@RequestMapping(value="/TableauEtud",method=RequestMethod.GET)
	public String index2(Model model,
			@RequestParam(name="uidetd",defaultValue="") String Code_Etudiant){
		 String[][] Etudiant_Abs=Get_Absence(Code_Etudiant);
		 model.addAttribute("Etudiant_Abs",Etudiant_Abs);
		 model.addAttribute("Code_Etudiant",Code_Etudiant);
		 return "EtudPres";
		 
	}

	

	
	static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
	    QRCodeWriter qrCodeWriter = new QRCodeWriter();
	    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
	    
	    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
	    byte[] pngData = pngOutputStream.toByteArray(); 
	    return pngData;
	}

	
	

}
