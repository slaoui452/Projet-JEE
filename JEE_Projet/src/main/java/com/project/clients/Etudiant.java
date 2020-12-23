package com.project.clients;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Etudiant implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Code_etudiant;
	private String Nom;
	private String prenom;
	private int Groupe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode_etudiant() {
		return Code_etudiant;
	}
	public void setCode_etudiant(String code_etudiant) {
		Code_etudiant = code_etudiant;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getprenom() {
		return prenom;
	}
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	public int getGroupe() {
		return Groupe;
	}
	public void setGroupe(int groupe) {
		Groupe = groupe;
	}
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
