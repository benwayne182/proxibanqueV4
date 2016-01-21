package fr.gtm.proxibanquev4.service.conseiller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquev4.dao_springdata.conseiller.IConseillerDaoSD;
import fr.gtm.proxibanquev4.domaine.Conseiller;

@Service("conseillerservice")
@Transactional
public class ConseillerService implements IConseillerService {
	
	@Autowired
	private IConseillerDaoSD dao;

	public void addConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		dao.save(conseiller);
	}

	public Conseiller readConseillerById(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

	public void deleteConseiller(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public void updateConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		dao.save(conseiller);
	}

	public List<Conseiller> readAllConseillers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Conseiller> readConseillerByNom(String nom) {
		// TODO Auto-generated method stub
		return dao.findByNom(nom);
	}

}
