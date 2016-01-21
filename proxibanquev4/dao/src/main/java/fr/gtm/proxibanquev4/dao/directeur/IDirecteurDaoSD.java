package fr.gtm.proxibanquev4.dao.directeur;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquev4.domaine.Directeur;

/**
 * Interface SpringDATA pour le DAO du Directeur, hérite de JpaRepository
 * @author  Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public interface IDirecteurDaoSD extends JpaRepository<Directeur, Integer> {

}
