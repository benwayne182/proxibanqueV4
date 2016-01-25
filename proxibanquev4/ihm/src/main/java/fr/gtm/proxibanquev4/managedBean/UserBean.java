package fr.gtm.proxibanquev4.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquev4.domaine.Conseiller;
import fr.gtm.proxibanquev4.domaine.Directeur;
import fr.gtm.proxibanquev4.service.conseiller.IConseillerService;
import fr.gtm.proxibanquev4.service.directeur.IDirecteurService;

@ManagedBean
@Scope
@Component
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IConseillerService servicecons;
	@Autowired
	private IDirecteurService servicedir;

	protected String login;
	protected String password;
	
	private Conseiller selectedConseiller;
	
	private List<Conseiller> conseillers;

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
	public IConseillerService getServicecons() {
		return servicecons;
	}
	public void setServicecons(IConseillerService servicecons) {
		this.servicecons = servicecons;
	}
	public IDirecteurService getServicedir() {
		return servicedir;
	}
	public void setServicedir(IDirecteurService servicedir) {
		this.servicedir = servicedir;
	}
	public Conseiller getSelectedConseiller() {
		return selectedConseiller;
	}
	public void setSelectedConseiller(Conseiller selectedConseiller) {
		this.selectedConseiller = selectedConseiller;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public UserBean() {
		super();
	}
	
	public String connection(){
		Conseiller conseiller = servicecons.readConseillerByLogin(login);
		Directeur directeur = servicedir.readDirecteurByLogin(login);
		if(conseiller != null){
			if(getLogin().equalsIgnoreCase(conseiller.getLogin()) && getPassword().equals(conseiller.getPassword()))
			{
				return "ConseillerAcceuil";
			}
			else{
				return "connexion";
			}
		}
		else if (directeur != null){ 
			if(getLogin().equalsIgnoreCase(directeur.getLogin()) && getPassword().equals(directeur.getPassword())){
				return "DirecteurAcceuil";
			}
			else{
			return "connexion";
			}
		}
		else{
			return "connexion";
		}
	}
	
	public List<Conseiller> readConseillerByDirecteur() {
		Directeur directeur = servicedir.readDirecteurByLogin(login);
		conseillers = servicecons.readConseillerByDirecteur(directeur);
		return conseillers;
	}
	
	public Directeur readDirecteurByLogin(String login) {
		return servicedir.readDirecteurByLogin(login);
	}
	
	public void onConseillerSelect(SelectEvent event){ 
    	this.selectedConseiller =  (Conseiller)event.getObject();
    }
	
	public void rowSelect(SelectEvent event) {
		this.selectedConseiller = (Conseiller) event.getObject();
	}
	
	public void onRowEdit(RowEditEvent event) {
		Conseiller conseiller = new Conseiller();
		//ClientService servcli = new ClientService();
		conseiller = (Conseiller) event.getObject();
		FacesMessage msg = new FacesMessage("Client modifié", "Client n° : "+conseiller.getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		try {
			servicecons.updateConseiller(conseiller);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulé", "Conseiller n° : "+((Conseiller) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void deleteConseiller() {
        servicecons.deleteConseiller(selectedConseiller.getId());
        selectedConseiller = null;
    }
	
	public String update() {
		servicecons.updateConseiller(selectedConseiller);
		FacesMessage msg = new FacesMessage("Mse à jour effectuée");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "ListeConseiller";
	}
	
}
