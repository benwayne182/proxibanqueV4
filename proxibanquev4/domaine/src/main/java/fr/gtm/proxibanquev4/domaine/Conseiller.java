package fr.gtm.proxibanquev4.domaine;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("CONSEILLER")
/**
 * Classe Conseiller, hérite de la classe User
 * Représente un conseiller de la banque
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public class Conseiller extends Users{




	@OneToMany(mappedBy="conseiller",cascade={CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.EAGER)
	/**
	 * La classe conseiller a comme attribut spécifique sa liste de clients
	 * Elle hérite des attributs d'un User : id, nom, prenom, login, password
	 */
	Collection<Client> listeClients = new ArrayList<Client>();
	
	@ManyToOne
	private Directeur directeur;

	public Collection<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(Collection<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public Directeur getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Directeur directeur) {
		this.directeur = directeur;
	}

	/**
	 * Constructeur vide d'un conseiller
	 */
	public Conseiller() {
		super();
	}

	/**
	 * Constructeur à paramètres d'un conseiller
	 * @param nom
	 * @param prenom
	 */
	public Conseiller(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Conseiller [listeClients=" + listeClients + ", login=" + login + ", password=" + password + ", nom="
				+ nom + ", prenom=" + prenom + ", id=" + id + "]";
	}

}
