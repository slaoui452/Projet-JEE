package com.project.clients;



/**
 * <b>La classe PresProf est un Bean qui represente le tableau de presence d'un groupe dans un module, il s'agit du tableau a genere par demande du prof </b>
 * <p>
 * Un PresProf est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement.</li>
 * <li>Un Code unique à l'etudiant.</li>
 * <li>Nom, Prenom de l'etudiant.</li>
 * <li>Groupe de l'etudiant.</li>
 * <li>les 10 autres variables vont etre utiliser pour stocker la presence selon la seance. Soit Abs = Absent, P = Present et vide pour les seances qui viennent  </li>
 * </ul>
 * </p>
 * 
 * @see ProfsController#GetTablePresProf(List<Presencetable>,List<String>,int)
 * @author Aymane
 */

public class PresProf {
	/**
     * L'ID de chaque membre de la table. 
     * @see getId()	
     * @see setId(long id)
     * Cet Id est automatiquement incrémenté dans la table de base des données
     */
	private long id;
	/**
     * Le Code_Etudiant de chaque étudiant. 
     * @see getCode_Etudiant()	
     * @see setCode_Etudiant(String Code_Etudiant)
     */
	private String Code_Etudiant;
	/**
     * Le Nom de chaque étudiant. 
     * @see getNom()	
     * @see setNom(String Nom)
     */
	private String Nom;
	/**
     * Le prenom de chaque étudiant. 
     * @see getprenom()	
     * @see setprenom(String prenom)
     */
	private String prenom;
	/**
     * Le Groupe de chaque étudiant. 
     * @see getGroupe()	
     * @see setGroupe(int Groupe)
     */
	private int Groupe;
	/**
     * La Seance0 Represente la presence de l'étudiant dans la premiere seance entre Prof/groupe specifique. 
     * <br><p><b>P.S : </b> De meme pour tous les autres variables seanceN qui representent la présence de la n+1éme séance de l'étudiant</p>
     * 
     */
	private String Seance0;
	/**
     * @see #Seance0
     */
	private String Seance1;
	/**
     * @see #Seance0
     */
	private String Seance2;
	/**
     * @see #Seance0
     */
	private String Seance3;
	/**
     * @see #Seance0
     */
	private String Seance4;
	/**
     * @see #Seance0
     */
	private String Seance5;
	/**
     * @see #Seance0
     */
	private String Seance6;
	/**
     * @see #Seance0
     */
	private String Seance7;
	/**
     * @see #Seance0
     */
	private String Seance8;
	/**
     * @see #Seance0
     */
	private String Seance9;

	/**
     * Retourne l'id du module d'un groupe.
     * 
     * @return L'Id du module.
     * 
     */
	
	public long getId() {
		return id;
	}
	
	/**
     * Met à jour l'Id.
     * 
     * @param id
     *            Le nouveau id.
     */
	
	public void setId(long id) {
		this.id = id;
	}
	

	/**
     * Retourne Code_Etudiant.
     * 
     * @return le Code_Etudiant.
     * 
     */
	
	public String getCode_Etudiant() {
		return Code_Etudiant;
	}
	
	/**
     * Met à jour le Code_Etudiant en cas d'erreur.
     * 
     * @param Code_Etudiant
     *            Le nouveau Code_Etudiant .
     */
	public void setCode_Etudiant(String code_Etudiant) {
		Code_Etudiant = code_Etudiant;
	}
	
	/**
     * Retourne le Nom de l'etudiant.
     * 
     * @return Le Nom de l'etudiant.
     * 
     */
	public String getNom() {
		return Nom;
	}
	/**
     * Met à jour le nom de l'etudiant en cas d'erreur.
     * 
     * @param nom
     *            Le nouveau nom .
     */
	public void setNom(String nom) {
		Nom = nom;
	}

	/**
     * Retourne le prenom de l'etudiant.
     * 
     * @return Le prenom de l'etudiant.
     * 
     */
	public String getprenom() {
		return prenom;
	}
	
	/**
     * Met à jour le prenom de l'etudiant en cas d'erreur.
     * 
     * @param prenom
     *            Le nouveau prenom .
     */
	
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}

	/**
     * Retourne le groupe de l'etudiant.
     * 
     * @return Le groupe de l'etudiant.
     * 
     */
	
	public int getGroupe() {
		return Groupe;
	}
	
	/**
     * Met à jour le groupe de l'etudiant en cas d'erreur.
     * 
     * @param groupe
     *            Le nouveau groupe .
     */
	
	public void setGroupe(int groupe) {
		Groupe = groupe;
	}
	/**
     * Retourne:
     * <ul>
     * <li> "Abs" : Si l'etudiant n'etait pas present dans la seance0 .</li> 
     *  <li> "P" : Si l'etudiant etait present dans la seance0 .</li> 
     *   <li> "" : si le cours est a venir. </li> 
     *   </ul>
     *   
     * <br><b>P.S :</b> tous les autres methodes getSeanceN ont le meme rôle.
     * 
     * @return La presence de l'etudiant durant la seance0.
     * 
     * 
     * 
     */
	public String getSeance0() {
		return Seance0;
	}
	
	/**
     * Met à jour la presence de l'étudiant dans la seance0.
     * <br><b>P.S :</b> tous les autres methodes setSeanceN ont le meme rôle.
     * 
     * @param seance0
     *            La nouvelle seance0.
     */
	
	public void setSeance0(String seance0) {
		Seance0 = seance0;
	}	
	/**
     * @see #getSeance0()
     */
	public String getSeance1() {
		return Seance1;
	}
	/**
     * @see #setSeance0()
     */
	public void setSeance1(String seance1) {
		Seance1 = seance1;
	}
	/**
     * @see #getSeance0()
     */
	public String getSeance2() {
		return Seance2;
	}
	/**
     * @see #setSeance0()
     */
	public void setSeance2(String seance2) {
		Seance2 = seance2;
	}
	/**
     * @see #getSeance0()
     */
	public String getSeance3() {
		return Seance3;
	}
	/**
     * @see #setSeance0()
     */
	public void setSeance3(String seance3) {
		Seance3 = seance3;
	}
	/**
     * @see #getSeance0()
     */
	public String getSeance4() {
		return Seance4;
	}
	/**
     * @see #setSeance0()
     */
	public void setSeance4(String seance4) {
		Seance4 = seance4;
	}
	/**
     * @see #getSeance0()
     */
	public String getSeance5() {
		return Seance5;
	}
	/**
     * @see #setSeance0()
     */
	public void setSeance5(String seance5) {
		Seance5 = seance5;
	}
	/**
     * @see #getSeance0()
     */
	public String getSeance6() {
		return Seance6;
	}
	/**
     * @see #setSeance0()
     */
	public void setSeance6(String seance6) {
		Seance6 = seance6;
	}
	/**
     * @see #getSeance0()
     */
	public String getSeance7() {
		return Seance7;
	}
	/**
     * @see #setSeance0()
     */
	public void setSeance7(String seance7) {
		Seance7 = seance7;
	}
	/**
     * @see #getSeance0()
     */
	public String getSeance8() {
		return Seance8;
	}
	/**
     * @see #setSeance0()
     */
	public void setSeance8(String seance8) {
		Seance8 = seance8;
	}
	/**
     * @see #getSeance0()
     */
	public String getSeance9() {
		return Seance9;
	}
	/**
     * @see #setSeance0()
     */
	public void setSeance9(String seance9) {
		Seance9 = seance9;
	}
	
    /**
     * Constructeur PresProf.
     */
	public PresProf(long id, String code_Etudiant, String nom, String prenom, int groupe, String seance0,
			String seance1, String seance2, String seance3, String seance4, String seance5, String seance6,
			String seance7, String seance8, String seance9) {
		super();
		this.id = id;
		Code_Etudiant = code_Etudiant;
		Nom = nom;
		this.prenom = prenom;
		Groupe = groupe;
		Seance0 = seance0;
		Seance1 = seance1;
		Seance2 = seance2;
		Seance3 = seance3;
		Seance4 = seance4;
		Seance5 = seance5;
		Seance6 = seance6;
		Seance7 = seance7;
		Seance8 = seance8;
		Seance9 = seance9;
	}
	public PresProf() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
