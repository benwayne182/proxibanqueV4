package fr.gtm.proxibanquev4.dao.conseiller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquev4.domaine.Conseiller;

public interface IConseillerDaoSD extends JpaRepository<Conseiller, Integer> {
	
	public List<Conseiller> findByNom(String nom);

}
