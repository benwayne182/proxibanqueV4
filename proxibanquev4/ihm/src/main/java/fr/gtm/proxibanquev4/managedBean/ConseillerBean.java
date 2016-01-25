package fr.gtm.proxibanquev4.managedBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;
import fr.gtm.proxibanquev4.domaine.Directeur;
import fr.gtm.proxibanquev4.service.client.IClientService;
import fr.gtm.proxibanquev4.service.conseiller.IConseillerService;
import fr.gtm.proxibanquev4.service.directeur.IDirecteurService;

@ManagedBean
@Scope
@Component
public class ConseillerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String password;
	private Directeur directeur;
	
	@Autowired
	private IConseillerService service;
	@Autowired
	private IClientService servicecl;
	@Autowired
	private IDirecteurService serviced;

	private Client selectedClient;
	private Client client;
	
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

	public Client getSelectedClient() {
		return selectedClient;
	}
	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Directeur getDirecteur() {
		return directeur;
	}
	public void setDirecteur(Directeur directeur) {
		this.directeur = directeur;
	}
	public IDirecteurService getServiced() {
		return serviced;
	}
	public void setServiced(IDirecteurService serviced) {
		this.serviced = serviced;
	}
	public IConseillerService getService() {
		return service;
	}
	public void setService(IConseillerService service) {
		this.service = service;
	}
	public IClientService getServicecl() {
		return servicecl;
	}
	public void setServicecl(IClientService servicecl) {
		this.servicecl = servicecl;
	}
	
	public String creationConseiller(){
		Conseiller conseiller = new Conseiller(nom,prenom);
		conseiller.setLogin(login);
		conseiller.setPassword(password);
		
		Map<String,String> params = 
	            FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		String loginUser = params.get("loginUser");
		
		directeur = serviced.readDirecteurByLogin(loginUser);
		
		conseiller.setDirecteur(directeur);
		service.addConseiller(conseiller);
		return "ListeConseiller";
	}
	
	public Conseiller readConseillerByLogin(String login){
		
		return service.readConseillerByLogin(login);
		
	}


	public List<Client> readClientByConseiller(Conseiller cons){
		List<Client> listeClient = servicecl.readClientByConseiller(cons);
		System.out.println(listeClient);
		return listeClient;
	}
	
	public void onClientSelect(SelectEvent event){ 
    	this.selectedClient =  (Client)event.getObject();
    }
	
	public String updateClient()
    {
        servicecl.updateClient(this.selectedClient);
        return "ListeClient";
    }
	
	public ConseillerBean() {
		super();
	}
	
}
