package fr.gtm.proxibanquev4.service.conseiller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquev4.dao.conseiller.IConseillerDaoSD;
import fr.gtm.proxibanquev4.domaine.Conseiller;

@Component("conseillerservice")
@Transactional
/**
 * Implementation des methodes de l'interface IConseillerService
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public class ConseillerService implements IConseillerService {
	
	@Autowired
	private IConseillerDaoSD dao;

	public void addConseiller(Conseiller conseiller) {
		dao.save(conseiller);
	}

	public Conseiller readConseillerById(int id) {
		return dao.findOne(id);
	}

	public void deleteConseiller(int id) {
		dao.delete(id);
	}

	public void updateConseiller(Conseiller conseiller) {
		dao.save(conseiller);
	}

	public List<Conseiller> readAllConseillers() {
		return dao.findAll();
	}

	public List<Conseiller> readConseillerByNom(String nom) {
		return dao.findByNom(nom);
	}

	
	public Conseiller readConseillerByLogin(String login) {
		return dao.findByLogin(login);
	}

}
