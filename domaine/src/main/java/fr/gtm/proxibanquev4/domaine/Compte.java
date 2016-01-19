package fr.gtm.proxibanquev4.domaine;

public abstract class Compte {
	
	protected int id;
	protected float solde;
	protected Client client;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public float getSolde() {
		return solde;
	}


	public void setSolde(float solde) {
		this.solde = solde;
	}



	public Client getClient() {
		return client;
	}




	public void setClient(Client client) {
		this.client = client;
	}








}
