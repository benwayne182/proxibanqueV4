package fr.gtm.proxibanquev4.dao_springdata.compte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Compte;

@Component("comptedao")
@Transactional
public class CompteDao implements ICompteDao {
	
	@Autowired
	private ICompteDaoSD dao;

	public void addCompte(Compte compte) {
		// TODO Auto-generated method stub
		dao.save(compte);
	}

	public Compte readCompteById(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

	public void deleteCompte(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public void updateCompte(Compte compte) {
		// TODO Auto-generated method stub
		dao.save(compte);
	}

	public List<Compte> readAllComptes() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Compte> readCompteByClient(Client client) {
		// TODO Auto-generated method stub
		return dao.findByClient(client);
	}

}
