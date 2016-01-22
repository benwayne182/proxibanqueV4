package fr.gtm.proxibanquev4.dao.directeur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquev4.domaine.Conseiller;
import fr.gtm.proxibanquev4.domaine.Directeur;

/**
 * Interface SpringDATA pour le DAO du Directeur, h�rite de JpaRepository
 * @author  Benoit, Cl�mentP, Coralie, Margherita, Paul-Henri
 *
 */
public interface IDirecteurDaoSD extends JpaRepository<Directeur, Integer> {
	public List<Conseiller> findByNom(String nom);
	public Directeur findByLogin(String login);

}
