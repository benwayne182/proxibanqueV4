package fr.gtm.proxibanquev4.dao_springdata;

import java.util.List;

import fr.gtm.proxibanquev4.domaine.Client;

public interface IClientDao {
	
	public void create (Client client);
	public Client findById (int id);
	public void delete (int id);
	public void update (Client client);
	public List<Client> findAll();
	public List<Client> findByNom(String nom);

}
