package fr.gtm.proxibanquev4.dao.conseiller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquev4.domaine.Conseiller;
import fr.gtm.proxibanquev4.domaine.Directeur;

/**
 * Interface SpringDATA pour le DAO du Conseiller, h�rite de JpaRepository
 * @author  Benoit, Cl�mentP, Coralie, Margherita, Paul-Henri
 *
 */
public interface IConseillerDaoSD extends JpaRepository<Conseiller, Integer> {
	
	/**
	 * Trouve un conseiller par son nom
	 * @param nom
	 * @return liste des objets Conseiller
	 */
	public List<Conseiller> findByNom(String nom);
	public Conseiller findByLogin (String login);
	public List<Conseiller> findByDirecteur(Directeur directeur);

}
