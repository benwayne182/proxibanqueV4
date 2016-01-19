package fr.gtm.proxibanquev4.domaine;

/**
 * Classe CompteEpargne, hérite de la classe abstraite Compte
 * Représente un compte épargne détenu par un client
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public class CompteEpargne extends Compte {

	/**
	 * Attribut spécifique de la classe CompteEpargne : tauxDInteret
	 * Cet attribut s'ajoute aux attributs hérités de la classe Compte : id, solde et client
	 */
	private float tauxDInteret;

	//getters et setters
	public float getTauxDInteret() {
		return tauxDInteret;
	}

	public void setTauxDInteret(float tauxDInteret) {
		this.tauxDInteret = tauxDInteret;
	}

	/**
	 * Constructeur vide de la classe CompteEpargne
	 */
	public CompteEpargne() {
		
	}
	
	
	
}
