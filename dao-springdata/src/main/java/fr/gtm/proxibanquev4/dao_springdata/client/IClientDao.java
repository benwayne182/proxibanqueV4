package fr.gtm.proxibanquev4.dao_springdata.client;

import java.util.List;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;

public interface IClientDao {
	
	public void addClient (Client client);
	public Client readClientById (int id);
	public void deleteClient (int id);
	public void updateClient (Client client);
	public List<Client> readAllClients();
	public List<Client> readClientByNom(String nom);
	public List<Client> readClientByConseiller(Conseiller conseiller);

}
