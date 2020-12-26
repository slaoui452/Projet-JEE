package com.project.clients;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

/**
 * <b>Profs est un bean  représentant les membres de la table des profs  dans la base de données.</b>
 * <p>
 * Un membre de la table profs est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement.</li>
 * <li>le code unique indentifiant chaque profs.</li>
 * <li>le nom et le prenom de chaque profs</li>
 * <li>la matière enseigné</li>
 * </ul>
 * </p>
 * 
 * <p>
 * La Sérialisation servira a rendre la classe persistante, permettant un flux pour le stockage et l’échange des données.
 * </p>
 *  <p>
 * L'annotation Entity specifie que cette classe est liée a une table dans notre base de données
 * </p>
 * @author sayfedine
 * 
 */


public class Profs implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	/**
     * L'ID de chaque membre de la table. 
     * @see getId()	
     * @see setId(long id)
     * Cet Id est automatiquement incrémenté dans la table de base des données
     */
	private long id;
	/**
     * Le Code du prof presentant  une séance.
     * @see getCode_prof()	
     * @see setCode_prof(String code_prof)
     */
	private String Code_prof;
	/**
     * Le nom du prof presentant  une séance.
     * @see getNom()	
     * @see setNom(String nom)
     */
	private String Nom;
	/**
     * Le prenom du prof presentant  une séance.
     * @see getprenom()	
     * @see setprenom(String prenom)
     */
	private String prenom;
	/**
     * La matière enseigné par ce prof.
     * @see getmatiere()	
     * @see setmatiere(String matiere)
     */
	private String matiere;
	
	@Override
	public String toString() {
		return "Profs [id=" + id + ", Code_prof=" + Code_prof + ", Nom=" + Nom + ", prenom=" + prenom + ", matiere="
				+ matiere + "]";
	}
	public Profs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profs(long id, String code_prof, String nom, String prenom, String matiere) {
		super();
		this.id = id;
		Code_prof = code_prof;
		Nom = nom;
		this.prenom = prenom;
		this.matiere = matiere;
	}
	/**
     * Retourne l'Id.
     * 
     * @return retourne l'ID generé pour chaque membre de la table.
     */
	public long getId() {
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
	public void setId(long id) {
		this.id = id;
	}
	/**
     * Retourne le code du prof .
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
     * Retourne le nom du prof .
     * 
     * @return Le nom du prof.
     * 
     */
	public String getNom() {
		return Nom;
	}
	/**
     * Met à jour le nom du prof .
     * 
     * @param nom
     *            Le nouveau nom du prof .
     * 
     * 
     */
	public void setNom(String nom) {
		Nom = nom;
	}
	/**
     * Retourne le prenom du prof .
     * 
     * @return Le prenom du prof.
     * 
     */
	public String getprenom() {
		return prenom;
	}
	/**
     * Met à jour le prenom du prof .
     * 
     * @param prenom
     *            Le nouveau prenom du prof .
     * 
     * 
     */
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	/**
     * Retourne le matiere enseigné par ce prof .
     * 
     * @return le matiere .
     * 
     */
	public String getMatiere() {
		return matiere;
	}
	/**
     * Met à jour la matière enseigné .
     * 
     * @param matiere
     *            La nouvelle matiere.
     * 
     * 
     */
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
}
