package com.project.clients;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * <b>La classe Seances est un Bean qui represente le nombre de seances faites par un prof, il sert principalement à stoker 
 * les codes des seances pour pouvoir acceder facilement a la liste de presence d'une seance specifique. </b>
 * <p>
 * Une ligne de Seances est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement.</li>
 * <li>Un Code Unique au Prof ( Animateur de la seance ) + le groupe. </li>
 * <li>les 10 autres variables vont etre utiliser pour stocker le code des seances entre les memes intervenant.</li>
 * </ul>
 * 
 * </p>
 * 
 * @author Aymane
 * 
 */

@Entity
public class Seances implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	/**
     * L'id de chaque membre de la table. 
     * <b><br>Cet Id est automatiquement incrémenté dans la table de base des données<b>
     * @see getId()	
     * @see setId(long id)
     */
	private long id;
	/**
     * Le Code du prof encadrant un module pour un groupe.
     * @see getCode_prof()	
     * @see setCode_prof(String code_prof)
     */
	private String Code_Prof;
	/**
     * Le Groupe qu le professeur encadre.
     * @see getGroupe()	
     * @see setGroupe(int Groupe)
     */
	private int Groupe;
	/**
     * La Seance0 Represente le code de la premiére seance entre Prof/groupe specifique. 
     * <br><p><b>P.S : </b> De meme pour tous les autres variables seanceN qui representent le code de la n+1éme séance de entre le Prof/groupe</p>
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
     * Retourne l'Id.
     * 
     * @return retourne l'ID generé pour chaque module encadree par un prof a un groupe.
     * 
     */
	public long getId() {
		return id;
	}
	 /**
     * Met à jour l'ID.
     * 
     * @param id
     *            Le nouveau ID .
     */

	public void setId(long id) {
		this.id = id;
	}
	/**
     * Retourne le code du prof responsable du module.
     * 
     * @return Le code du prof.
     * 
     */
	public String getCode_Prof() {
		return Code_Prof;
	}
	 /**
     * Met à jour le code du prof .
     * 
     * @param code_prof
     *            Le nouveau code du prof .
     */

	public void setCode_Prof(String code_Prof) {
		Code_Prof = code_Prof;
	}
	/**
     * Retourne le groupe des etudiant ayant la séance.
     * 
     * @return le groupe des etudiants.
     */
	public int getGroupe() {
		return Groupe;
	}
	 /**
     * Met à jour le groupe d'un module.
     * 
     * @param groupe
     *            Le nouveau groupe .
     */

	public void setGroupe(int groupe) {
		Groupe = groupe;
	}
	/**
     * Retourne Le code de la 1 er Seance.
     * <br><b>P.S :</b> tous les autres methodes getSeanceN ont le meme rôle, c'est a dire qu'ils retourne le code de la N+1 eme seance.
     * 
     * @return Le code de la seance.
     */
	
	public String getSeance0() {
		return Seance0;
	}
	
	/**
     * Met à jour le code de la premiere seance.
     * <br><b>P.S :</b> tous les autres methodes setSeanceN ont le meme rôle, c'est a dire mettre a jour le code de la N+1 seance.
     * 
     * @param seance0
     *            La nouvelle seance0.
     */
	
	public void setSeance0(String Seance0) {
		this.Seance0 = Seance0;
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
     * Constructeur Seances.
     */ 
	
	public Seances(long id, String code_Prof, int groupe,String Seance0, String seance1, String seance2, String seance3,
			String seance4, String seance5, String seance6, String seance7, String seance8, String seance9) {
		super();
		this.id = id;
		Code_Prof = code_Prof;
		Groupe = groupe;
		Seance1 = seance1;
		Seance2 = seance2;
		Seance3 = seance3;
		Seance4 = seance4;
		Seance5 = seance5;
		Seance6 = seance6;
		Seance7 = seance7;
		Seance8 = seance8;
		Seance9 = seance9;
		this.Seance0 = Seance0;
	}
	public Seances() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Seances [id=" + id + ", Code_Prof=" + Code_Prof + ", Groupe=" + Groupe + ", Seance1=" + Seance1
				+ ", Seance2=" + Seance2 + ", Seance3=" + Seance3 + ", Seance4=" + Seance4 + ", Seance5=" + Seance5
				+ ", Seance6=" + Seance6 + ", Seance7=" + Seance7 + ", Seance8=" + Seance8 + ", Seance9=" + Seance9
				+ ", Seance0=" + Seance0 + "]";
	}

}