package fr.gtm.proxibanquev4.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquev4.dao_springdata.client.IClientDaoSD;
import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;


@Service("clientservice")
@Transactional
public class ClientService implements IClientService {

	@Autowired
	private IClientDaoSD dao;

	public void addClient(Client client) {
		// TODO Auto-generated method stub
		dao.save(client);
	}

	public Client readClientById(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

	public void deleteClient(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public void updateClient(Client p) {
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public List<Client> readAllClients() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Client> readClientByNom(String nom) {
		// TODO Auto-generated method stub
		return dao.findByNom(nom);
	}
	
	public List<Client> readClientByConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return dao.findByConseiller(conseiller);
	}

	public IClientDaoSD getDao() {
		return dao;
	}

	public void setDao(IClientDaoSD dao) {
		this.dao = dao;
	}

}
