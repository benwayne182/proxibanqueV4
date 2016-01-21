package fr.gtm.proxibanquev4.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe Directeur, hérite de la classe User
 * Représente un directeur d'agence
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
@Entity
@DiscriminatorValue("DIRECTEUR")
public class Directeur extends Users{

	/**
	 * Constructeur vide d'un directeur
	 */
	public Directeur() {
		super();
	}
	
	
	
	

}
