package fr.gtm.proxibanquev4.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScope
@Component
public class ConseillerBean {

	protected String nom;
	protected String prenom;
	protected String login;
	protected String password;
	
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
	
}
