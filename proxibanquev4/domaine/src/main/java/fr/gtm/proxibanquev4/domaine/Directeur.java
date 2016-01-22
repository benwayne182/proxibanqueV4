package fr.gtm.proxibanquev4.domaine;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("DIRECTEUR")
/**
 * Classe Directeur, hérite de la classe User
 * Représente un directeur d'agence
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public class Directeur extends Users{

	/**
	 * Constructeur vide d'un directeur
	 */
	public Directeur() {
		super();
	}
	
	@OneToMany(mappedBy="directeur",cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	Collection<Conseiller> listeConseillers = new ArrayList<Conseiller>();
	
	

}
