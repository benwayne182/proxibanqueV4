package fr.gtm.proxibanquev4.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquev4.domaine.Conseiller;
import fr.gtm.proxibanquev4.service.conseiller.IConseillerService;

@ManagedBean
@SessionScoped
@Component
public class ConseillerBean {

	protected String nom;
	protected String prenom;
	protected String login;
	protected String password;
	@Autowired
	private IConseillerService service;

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

	public String creationConseiller(){
		Conseiller conseiller = new Conseiller(nom,prenom);
		conseiller.setLogin(login);
		conseiller.setPassword(password);
		service.addConseiller(conseiller);
		return "ListeConseiller";

	}
	

}
