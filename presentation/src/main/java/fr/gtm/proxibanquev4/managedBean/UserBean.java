package fr.gtm.proxibanquev4.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@ManagedBean
@SessionScoped
@Component
public class UserBean {

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
	
	public String connection()
	{
		if(getLogin().equalsIgnoreCase("toto") && getPassword().equals("toto"))
		{
			return "ConseillerAcceuil";
		}
		else
		{
			return "ConseillerErreur";
		}
	}
}
