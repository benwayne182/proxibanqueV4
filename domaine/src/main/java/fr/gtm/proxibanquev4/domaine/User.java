package fr.gtm.proxibanquev4.domaine;

public abstract class User extends Personne{
	
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
	public User() {
		
	}
	
	
	

}
