package fr.gtm.proxibanquev4.domaine;

/**
 * Classe abstraite User, hérite de la classe Personne, et possède deux classes filles : Conseiller et Directeur
 * Représente un utilisateur du programme
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public abstract class User extends Personne{
	
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
	public User() {
		
	}
	
	
	

}
