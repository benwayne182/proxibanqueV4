package fr.gtm.proxibanquev4.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquev4.dao.client.IClientDaoSD;
import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;


@Component("clientservice")
@Transactional
/**
 * Implementation des methodes de la couche service pour le Client
 * @author Benoit, Cl�mentP, Coralie, Margherita, Paul-Henri
 *
 */
public class ClientService implements IClientService {


	@Autowired
	/**
	 * Injection de l'interface de la couche Dao
	 */
	private IClientDaoSD dao;

	public void addClient(Client client) {
		dao.save(client);
	}

	public Client readClientById(int id) {
		return dao.findOne(id);
	}

	public void deleteClient(int id) {
		dao.delete(id);
	}

	public void updateClient(Client p) {
		dao.save(p);
	}

	public List<Client> readAllClients() {
		return dao.findAll();
	}

	public List<Client> readClientByNom(String nom) {
		return dao.findByNom(nom);
	}

	public List<Client> readClientByConseiller(Conseiller conseiller) {
		return dao.findByConseiller(conseiller);
	}

}
