package fr.gtm.proxibanquev4.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Classe client. La classe client hérite des attributs d'une personne (nom, prénom, id).
 * Représente un client. 
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
@Entity
public class Client extends Personne{
	
	/**
	 * Attributs spécifiques de la classe Client : adresse, codePostal, ville, tel, email
	 * Ces attributs s'ajoutent aux attributs hérités de la classe Personne : id, nom, prenom
	 */
	private String adresse;
	private int codePostal;
	private String ville;
	private String tel;
	private String email;
	
	@ManyToOne
	private Conseiller conseiller;
	
	/**
	 * Constructeur vide de la classe Client
	 */
	public Client() {
		super();
	}

	/**
	 * Constructeur avec paramètres de la classe Client
	 * @param nom
	 * @param prenom
	 */
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}


	//Getters et setters de la classe Client
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	
	
}
