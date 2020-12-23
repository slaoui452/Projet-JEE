package com.project.clients;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Seance_actv implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;
	private int groupe ;
	private String Code_prof;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupe() {
		return groupe;
	}
	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}
	public String getCode_prof() {
		return Code_prof;
	}
	public void setCode_prof(String code_prof) {
		Code_prof = code_prof;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
