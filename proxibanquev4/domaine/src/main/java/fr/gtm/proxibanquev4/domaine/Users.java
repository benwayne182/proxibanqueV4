package fr.gtm.proxibanquev4.domaine;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe abstraite User, hérite de la classe Personne, et possède deux classes filles : Conseiller et Directeur
 * Représente un utilisateur du programme
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_USER")
public class Users extends Personne{
	
	/**
	 * Attributs spécifiques de la clase User : login, password
	 */
	protected String login;
	protected String password;
	
	//getters et setters
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Constructeur vide de la classe User
	 */
	public Users() {
		
	}
	
	
	

}
