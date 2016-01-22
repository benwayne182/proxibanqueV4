package fr.gtm.proxibanquev4.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.impl.AddDelegateTransformer;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquev4.domaine.Conseiller;
import fr.gtm.proxibanquev4.domaine.Directeur;
import fr.gtm.proxibanquev4.service.conseiller.IConseillerService;
import fr.gtm.proxibanquev4.service.directeur.IDirecteurService;

@ManagedBean
@SessionScoped
@Component
public class UserBean {

	@Autowired
	private IConseillerService servicecons;
	@Autowired
	private IDirecteurService servicedir;

	protected String login;
	protected String password;

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
}
