package com.project.clients;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seances implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String Code_Prof;
	private int Groupe;
	private String Seance1;
	private String Seance2;
	private String Seance3;
	private String Seance4;
	private String Seance5;
	private String Seance6;
	private String Seance7;
	private String Seance8;
	private String Seance9;
	private String Seance0;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode_Prof() {
		return Code_Prof;
	}
	public void setCode_Prof(String code_Prof) {
		Code_Prof = code_Prof;
	}
	public int getGroupe() {
		return Groupe;
	}
	public void setGroupe(int groupe) {
		Groupe = groupe;
	}
	public String getSeance1() {
		return Seance1;
	}
	public void setSeance1(String seance1) {
		Seance1 = seance1;
	}
	public String getSeance2() {
		return Seance2;
	}
	public void setSeance2(String seance2) {
		Seance2 = seance2;
	}
	public String getSeance3() {
		return Seance3;
	}
	public void setSeance3(String seance3) {
		Seance3 = seance3;
	}
	public String getSeance4() {
		return Seance4;
	}
	public void setSeance4(String seance4) {
		Seance4 = seance4;
	}
	public String getSeance5() {
		return Seance5;
	}
	public void setSeance5(String seance5) {
		Seance5 = seance5;
	}
	public String getSeance6() {
		return Seance6;
	}
	public void setSeance6(String seance6) {
		Seance6 = seance6;
	}
	public String getSeance7() {
		return Seance7;
	}
	public void setSeance7(String seance7) {
		Seance7 = seance7;
	}
	public String getSeance8() {
		return Seance8;
	}
	public void setSeance8(String seance8) {
		Seance8 = seance8;
	}
	public String getSeance9() {
		return Seance9;
	}
	public void setSeance9(String seance9) {
		Seance9 = seance9;
	}
	public String getSeance0() {
		return Seance0;
	}
	public void setSeance0(String Seance0) {
		this.Seance0 = Seance0;
	}
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