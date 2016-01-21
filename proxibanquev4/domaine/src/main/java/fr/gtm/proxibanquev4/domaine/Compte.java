package fr.gtm.proxibanquev4.domaine;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 * Classe abstraite Compte
 * Représente un compte en banque détenu par un client.
 * La classe compte possède deux sous-classes concrètes : CompteCourant et CompteEpargne
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_COMPTE")
public abstract class Compte {
	
	/**
	 * Attributs spécifiques à la classe abstraite Compte : id, solde et client
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private float solde;
	
	@ManyToOne
	private Client client;
	
	
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
