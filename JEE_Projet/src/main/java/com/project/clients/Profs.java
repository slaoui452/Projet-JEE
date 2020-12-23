package com.project.clients;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Profs implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String Code_prof;
	private String Nom;
	private String prenom;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode_prof() {
		return Code_prof;
	}
	public void setCode_prof(String code_prof) {
		Code_prof = code_prof;
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
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
}
