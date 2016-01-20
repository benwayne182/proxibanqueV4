package fr.gtm.proxibanquev4.dao_springdata.directeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import fr.gtm.proxibanquev4.domaine.Directeur;

@Component("dirdao")
@Transactional
public class DirecteurDao implements IDirecteurDao {

	@Autowired
	private IDirecteurDaoSD dao;
	
	public Directeur readDirecteurById(int id){
		
		return dao.findOne(id);
	}

	public void addDirecteur(Directeur dir) {
		dao.save(dir);

	}

}
