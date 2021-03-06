package fr.gtm.proxibanquev4.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Directeur;
import fr.gtm.proxibanquev4.service.client.IClientService;

@ManagedBean
@SessionScoped
@Component
public class ClientBean {


	@Autowired
	private IClientService cliserv;
	
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected int codePostal;
	protected String ville;
	protected String telephone;
	protected String email;
	
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
		return telephone;
	}

	public void setTel(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
public String creationClient(){
		Client client = new Client();
		client.setAdresse(adresse);
		client.setCodePostal(codePostal);
		client.setEmail(email);
		client.setTel(telephone);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setVille(ville);
		
		cliserv.addClient(client);
		
		return "ListeClient";
		
	}
}

