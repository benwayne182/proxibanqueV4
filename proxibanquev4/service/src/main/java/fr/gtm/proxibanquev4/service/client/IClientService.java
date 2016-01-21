package fr.gtm.proxibanquev4.service.client;

import java.util.List;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;

/**
 * Interface des methodes de la couche service du Client
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public interface IClientService {
	
	/**
	 * Ajouter un client
	 * @param client
	 */
	public void addClient (Client client);
	/**
	 * Lire un client avec numero d'identification
	 * @param id
	 * @return objet du Client
	 */
	public Client readClientById (int id);
	
	/**
	 * Effacer un client identifie par son ID
	 * @param id
	 */
	public void deleteClient (int id);
	
	/**
	 * Mettre à jour un Client
	 * @param client
	 */
	public void updateClient (Client client);
	/**
	 * Trouve la liste de tous les clients de la base
	 * @return liste des objets Client
	 */
	public List<Client> readAllClients();
	/**
	 * Trouver des clients par leur nom
	 * @param nom
	 * @return liste des objets Client
	 */
	public List<Client> readClientByNom(String nom);
	/**
	 * Lire les clients associes à un conseiller
	 * @param conseiller
	 * @return liste des objets Client
	 */
	public List<Client> readClientByConseiller(Conseiller conseiller);

}
