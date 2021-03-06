package fr.gtm.proxibanquev4.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
/**
 * Classe abstraite Personne
 * Elle possède plusieurs classes filles : User et Client
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public abstract class Personne {

	/**
	 * Attributs de la classe Personne : nom, prenom, id
	 */
	protected String nom;
	protected String prenom;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int id;
	
	//getters et setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Constructeur à paramètres de la classe abstraite Personne
	 * @param nom
	 * @param prenom
	 */
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * Constructeur vide de la classe abstraite Personne
	 */
	public Personne() {
		
	}
	
	
	
	
	
}
