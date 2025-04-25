package ProjetIng2;

import java.sql.Date;

public class Creance {
	private String id_Creance;
	private String id_client;
	private double montantTotal;
	private double montantRestant;
	private String date_creance;
	private String statut;
	
	
	
	public Creance (String id_Creance ,String id_client , double montantTotal , double montantRestant ,String statut) {
		
		this.id_Creance = id_Creance;
		this.id_client = id_client;
		this.montantTotal = montantTotal;
		this.montantRestant = montantTotal;
		this.date_creance = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		this.statut = statut;
		
		
	}



	public String getId_Creance() {
		return id_Creance;
	}



	public void setId_Creance(String id_Creance) {
		id_Creance = id_Creance;
	}



	public String getid_client() {
		return id_client;
	}



	public void setid_client(String id_client) {
		this.id_client = id_client;
	}



	public double getMontantTotal() {
		return montantTotal;
	}



	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}



	public double getMontantRestant() {
		return montantRestant;
	}



	public void setMontantRestant(double montantRestant) {
		this.montantRestant = montantRestant;
	}



	public String getdate_creance() {
		return date_creance;
	}



	



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	

}
