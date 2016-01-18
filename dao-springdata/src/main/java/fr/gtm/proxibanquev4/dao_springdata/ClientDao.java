package fr.gtm.proxibanquev4.dao_springdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquev4.domaine.Client;


@Component("clientdao")
@Transactional
public class ClientDao implements IClientDao {

	@Autowired
	private IDao dao;

	public void create(Client client) {
		// TODO Auto-generated method stub
		dao.save(client);
	}

	public Client findById(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public void update(Client p) {
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Client> findByNom(String nom) {
		// TODO Auto-generated method stub
		return dao.findByNom(nom);
	}

}
