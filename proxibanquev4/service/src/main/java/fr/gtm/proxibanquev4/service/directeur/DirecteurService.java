package fr.gtm.proxibanquev4.service.directeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquev4.dao.directeur.IDirecteurDaoSD;
import fr.gtm.proxibanquev4.domaine.Directeur;

@Component("directeurservice")
@Transactional
/**
 * Implementation des methodes de l'interface IDirecteurService
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public class DirecteurService implements IDirecteurService {

	@Autowired
	private IDirecteurDaoSD dao;
	
	public Directeur readDirecteurById(int id){
		
		return dao.findOne(id);
	}

	public void addDirecteur(Directeur dir) {
		dao.save(dir);

	}

}
