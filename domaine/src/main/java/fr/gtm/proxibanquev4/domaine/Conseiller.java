package fr.gtm.proxibanquev4.domaine;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conseiller extends User{
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int id;
//	
//	private String login;
//	private String password;
//	private String nom;
//	private String prenom;
	
	@OneToMany(mappedBy="conseiller",cascade=CascadeType.PERSIST)
	Collection<Client> listeClients = new ArrayList<Client>();
	
	public Conseiller() {
		super();
	}

	public Conseiller(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}



}
