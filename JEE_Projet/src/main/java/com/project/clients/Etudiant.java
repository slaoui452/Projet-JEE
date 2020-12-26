package com.project.clients;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * <b>La classe Etudiant est un Bean qui represente un Client de cette application Web</b>
 * <p>
 * Un Etudiant est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement.</li>
 * <li>Un Code unique à l'etudiant.</li>
 * <li>Nom, Prenom de l'etudiant.</li>
 * <li>Groupe de l'etudiant.</li>
 * </ul>
 * </p>
 * La Sérialisation servira a rendre la classe persistante, permettant un flux pour le stockage et l’échange des données.
 * 
 * <p>
 * L'annotation Entity specifie que cette classe est liée a une table dans notre base de données
 * </p>
 * @author Mehdi
 */

@Entity
public class Etudiant implements Serializable {


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	/**
     * L'ID de chaque Etudiant de la table. 
     * @see getId()	
     * @see setId(int id)
     * Cet Id est automatiquement incrémenté dans la table de base des données
     */
	private int id;
	/**
     * Le Code_etudiant est unique pour chaque etudiant. 
     * @see getCode_etudiant()	
     * @see setCode_etudiant(String Code_etudiant)

     */
	private String Code_etudiant;
	/**
     * Il s'agit du nom de l'étudiant
     * @see getNom()	
     * @see setNom(String Nom)
     */
	private String Nom;
	/**
     * Il s'agit du prenom de l'étudiant
     * @see getprenom()	
     * @see setprenom(String prenom)
     */
	private String prenom;
	/**
     * Le Groupe de l'etudiant
     * @see getGroupe()	
     * @see setGroupe(int Groupe)
     */
	private int Groupe;
	
	/**
     * Retourne l'Id.
     * 
     * @return retourne l'ID generé pour chaque etudiant de la table.
     */
	
	public int getId() {
		return id;
	}
	
	/**
     * Met à jour l'ID.
     * @param id
     *            Le nouveau ID .
     */
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
     * Retourne le code de l'etudiant.
     * 
     * @return Le code de l'etudiant.
     * 
     */
	
	public String getCode_etudiant() {
		return Code_etudiant;
	}
	
	/**
     * Met à jour le code de l'etudiant en cas d'erreur.
     * 
     * @param code_etudiant
     *            Le nouveau code_etudiant .
     */
	public void setCode_etudiant(String code_etudiant) {
		Code_etudiant = code_etudiant;
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
     * Met à jour le Nom de l'etudiant en cas d'erreur.
     * 
     * @param nom
     *            Le nouveau Nom .
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
     * Met à jour le groupe de l'etudiant en cas d'erreur..
     * 
     * @param groupe
     *            Le nouveau groupe .
     */
	public void setGroupe(int groupe) {
		Groupe = groupe;
	}
	
    /**
     * Constructeur Etudiant.
     */
	
	public Etudiant(int id, String code_etudiant, String nom, String prenom, int groupe) {
		super();
		this.id = id;
		Code_etudiant = code_etudiant;
		Nom = nom;
		this.prenom = prenom;
		Groupe = groupe;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", Code_etudiant=" + Code_etudiant + ", Nom=" + Nom + ", prenom=" + prenom
				+ ", Groupe=" + Groupe + "]";
	}
	
	

}
