package com.project.clients;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Presencetable implements Serializable{

		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		private String Code_etudiant;
		private String code_prof;
		private int Groupe;
		private boolean Presence;
		private String Code_Seance;
		
		public String getCode_Seance() {
			return Code_Seance;
		}
		public void setCode_Seance(String code_Seance) {
			Code_Seance = code_Seance;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getCode_etudiant() {
			return Code_etudiant;
		}
		public void setCode_etudiant(String code_etudiant) {
			Code_etudiant = code_etudiant;
		}
		public String getCode_prof() {
			return code_prof;
		}
		public void setCode_prof(String code_prof) {
			this.code_prof = code_prof;
		}
		public int getGroupe() {
			return Groupe;
		}
		public void setGroupe(int groupe) {
			Groupe = groupe;
		}
		public boolean isPresence() {
			return Presence;
		}
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
