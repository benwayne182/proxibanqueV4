package fr.gtm.proxibanquev4.domaine;

/**
 * Classe abstraite Compte
 * Représente un compte en banque détenu par un client.
 * La classe compte possède deux sous-classes concrètes : CompteCourant et CompteEpargne
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public abstract class Compte {
	
	/**
	 * Attributs spécifiques à la classe abstraite Compte : id, solde et client
	 */
	protected int id;
	protected float solde;
	protected Client client;
	
	
	//getters et setters
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
