package fr.gtm.proxibanquev4.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe CompteCourant, hérite de la classe abstraite Compte
 * Représente un compte courant détenu par un client
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
@Entity
@DiscriminatorValue("CCourant")
public class CompteCourant extends Compte{

	/**
	 * Attribut spécifique de la classe CompteCourant : decouvertAutorisé
	 * Cet attribut s'ajoute à ceux hérités de la classe Compte : id, solde et client
	 */
	private float decouvertAutorise;

	//getters et setters
	public float getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	/**
	 * Constructeur vide de la classe CompteCourant
	 */
	public CompteCourant() {

	}

	public CompteCourant(float decouvertAutorise) {
		super();
		this.decouvertAutorise = decouvertAutorise;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvertAutorise=" + decouvertAutorise + ", getId()=" + getId() + "]";
	}

}
