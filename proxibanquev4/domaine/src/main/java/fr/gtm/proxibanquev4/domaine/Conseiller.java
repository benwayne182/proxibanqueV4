package fr.gtm.proxibanquev4.domaine;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Classe Conseiller, hérite de la classe User
 * Représente un conseiller de la banque
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
@Entity
@DiscriminatorValue("CONSEILLER")
public class Conseiller extends Users{
	
	/**
	 * La classe conseiller a comme attribut spécifique sa liste de clients
	 * Elle hérite des attributs d'un User : id, nom, prenom, login, password
	 */
	@OneToMany(mappedBy="conseiller",cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	Collection<Client> listeClients = new ArrayList<Client>();
	
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



}
