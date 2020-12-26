package com.project.clients;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity



/**
 * <b>Presencetable est un bean représentant les membres de la table de presence dans la base de données .</b>
 * <p>
 * Un membre de la Presencetable est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement.</li>
 * <li>le code unique indentifiant chaque etudiant.</li>
 * <li>le groupe de cet etudiant</li>
 * <li>un attribut qui cite si l'etudiant est present ou non</li>
 * <li>le mot de passe de la seance</li>
 * <li>est le prof chargé par le groupe </li>
 * </ul>
 * </p>
 * <p>
 * De plus, les étudiants d'un groupe sont ajouté a la table dans la base de données 
 * dès qu'une seance active est généré par un prof
 * La Sérialisation servira a rendre la classe persistante, permettant un flux pour le stockage et l’échange des données.
 * </p>
 * <p>
 * L'annotation Entity specifie que cette classe est liée a une table dans notre base de données
 * </p>
 * @see Seance_actv
 * 
 * @author khalil
 * 
 */


public class Presencetable implements Serializable{
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		/**
	     * L'ID de chaque membre de la table. 
	     * @see getId()	
	     * @see setId(long id)
	     * Cet Id est automatiquement incremente dans la table de base des données
	     */
		private long id;
		/**
	     * Le Code etudiant de chaque etudiant concerné par une seance.
	     * @see getCode_etudiant()	
	     * @see setCode_etudiant(String code_etudiant)
	     */
		private String Code_etudiant;
		/**
	     * Le Code du prof presentant cette séance.
	     * @see getCode_prof()	
	     * @see setCode_prof(String code_prof)
	     */
		private String code_prof;
		/**
	     * Le Groupe des etudiant concerné par la séance
	     * @see getGroupe()	
	     * @see setGroupe(int groupe)
	     */
		private int Groupe;
		/**
	     * Signale si l'etudiant concerné etait présent
	     * @see isPresence()	
	     * @see setPresence(boolean presence)
	     */
		private boolean Presence;
		/**
	     * L'ID de chaque memebre de la table. Cet ID n'est pas modifiable.
	     * @see getCode_Seance()	
	     * @see setCode_Seance(String code_Seance)
	     */
		private String Code_Seance;
		
		/**
         * Retourne le code d'une séance.
         * 
         * @return code d'une séance.
         * 
         */
		
		public String getCode_Seance() {
			return Code_Seance;
		}
		 /**
         * Met à jour le Code_Seance .
         * 
         * @param Code_Seance
         *            Le nouveau Code Seance .
         */
		public void setCode_Seance(String code_Seance) {
			Code_Seance = code_Seance;
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
         */
		
		public void setId(long id) {
			this.id = id;
		}
		/**
         * Retourne le code de l'etudiant concerné par la presence dans la seance.
         * 
         * @return le code de l'etudiant concerné .
         * 
         */
		public String getCode_etudiant() {
			return Code_etudiant;
		}
		 /**
         * Met à jour le Code etudiant .
         * 
         * @param code_etudiant
         *            Le nouveau Code_etudiant .
         */
		public void setCode_etudiant(String code_etudiant) {
			Code_etudiant = code_etudiant;
		}
		/**
         * Retourne le code du prof responsable de la séance.
         * 
         * @return Le code du prof.
         * 
         */
		public String getCode_prof() {
			return code_prof;
		}
		 /**
         * Met à jour le code du prof .
         * 
         * @param code_prof
         *            Le nouveau code du prof .
         */
		public void setCode_prof(String code_prof) {
			this.code_prof = code_prof;
		}
		/**
         * Retourne le groupe des etudiant ayant la séance.
         * 
         * @return le groupe des etudiant.
         */
		public int getGroupe() {
			return Groupe;
		}
		 /**
         * Met à jour le groupe d'un etudiant.
         * 
         * @param groupe
         *            Le nouveau groupe .
         */
		public void setGroupe(int groupe) {
			Groupe = groupe;
		}
		/**
         * Retourne si cet etudiant est present ou non.
         * 
         * @return True si l'etudiant est present, false sinon.
         * 
         */
		public boolean isPresence() {
			return Presence;
		}
		 /**
         * Met à jour la presence d'un etudiant .
         * 
         * @param presence
         *            La presence de cet etudiant .
         */
		public void setPresence(boolean presence) {
			Presence = presence;
		}
		public Presencetable(long id, String code_etudiant, String code_prof, int groupe, boolean presence,String Code_Seance) {
			super();
			this.id = id;
			Code_etudiant = code_etudiant;
			this.code_prof = code_prof;
			Groupe = groupe;
			Presence = presence;
			this.Code_Seance=Code_Seance;
		}
		public Presencetable() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Presencetable [id=" + id + ", Code_etudiant=" + Code_etudiant + ", code_prof=" + code_prof
					+ ", Groupe=" + Groupe + ", Presence=" + Presence + ", Code_Seance=" + Code_Seance + "]";
		}



}
