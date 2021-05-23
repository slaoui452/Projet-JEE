package com.project.clients;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
/**
 * <b>Seance_actv est un bean  représentant les membres de la table des profs  dans la base de données.</b>
 * <p>
 * Un membre de la table profs est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement.</li>
 * <li>le code unique indentifiant chaque profs.</li>
 * <li>Le mot de passe permettant traduit en code QR</li>
 * <li>le groupe concerné par la seance</li>
 * </ul>
 * </p>
 * <p>
 * L'annotation Entity specifie que cette classe est liée a une table dans notre base de données
 * </p>
 * <p>
 * La Sérialisation servira a rendre la classe persistante, permettant un flux pour le stockage et l’échange des données.
 * </p>
 * @author sayfeddine
 * 
 */
public class Seance_actv implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	/**
     * L'ID de chaque membre de la table. 
     * @see getId()	
     * @see setId(long id)
     * Cet Id est automatiquement incrémenté dans la table de base des données
     */
	private int id;
	/**
     * Le Groupe des etudiant concerné par la séance
     * @see getGroupe()	
     * @see setGroupe(int groupe)
     */
	private int groupe ;
	/**
     * Le Code du prof presentant cette séance.
     * @see getCode_prof()	
     * @see setCode_prof(String code_prof)
     */
	private String Code_prof;
	/**
     * Le mot de passe permettant l'accès a la seance.
     * @see getCode_prof()	
     * @see setCode_prof(String code_prof)
     * @see EtudiantController#index1
     */
	private String mdp;
	public Seance_actv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Seance_actv(int id, int groupe, String code_prof, String mdp) {
		super();
		this.id = id;
		this.groupe = groupe;
		Code_prof = code_prof;
		this.mdp = mdp;
	}
	@Override
	
	public String toString() {
		return "Seance_actv [id=" + id + ", groupe=" + groupe + ", Code_prof=" + Code_prof + ", mdp=" + mdp + "]";
	}
	
	/**
     * Retourne l'Id.
     * 
     * @return retourne l'ID generé pour chaque membre de la table.
     */
	public int getId() {
		return id;
	}
	/**
     * Met à jour l'ID.
     * 
     * @param id
     *            Le nouveau ID .
     * 
     * 
     */
	public void setId(int id) {
		this.id = id;
	}
	/**
     * Retourne le groupe des etudiant ayant la séance.
     * 
     * @return le groupe des etudiant.
     */
	public int getGroupe() {
		return groupe;
	}
	/**
     * Met à jour le groupe d'un etudiant.
     * 
     * @param groupe
     *            Le nouveau groupe .
     * 
     * 
     */
	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}
	/**
     * Retourne le code du prof responsable de la séance.
     * 
     * @return Le code du prof.
     * 
     */
	public String getCode_prof() {
		return Code_prof;
	}
	/**
     * Met à jour le code du prof .
     * 
     * @param code_prof
     *            Le nouveau code du prof .
     * 
     * 
     */
	public void setCode_prof(String code_prof) {
		Code_prof = code_prof;
	}
	/**
     * Retourne le mot de passe de cette séance.
     * 
     * @return le mot de passe.
     * 
     */
	public String getMdp() {
		return mdp;
	}
	/**
     * Met à jour le mot de passe de la séance.
     * 
     * @param mdp
     *            Le nouveau mot de passe .
     * 
     * 
     */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
