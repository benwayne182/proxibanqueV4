package fr.gtm.proxibanquev4.dao.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;
/**
 * Interface SpringDATA pour le DAO du Client, hérite de JpaRepository
 * @author  Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */

public interface IClientDaoSD extends JpaRepository<Client, Integer>{
	
	/**
	 * Trouver un client par son nom
	 * @param nom
	 * @return liste des clients avec le nom defini
	 */
	public List<Client> findByNom(String nom);
	
	/**
	 * Trouver les clients en fonction du conseiller associé
	 * @param conseiller
	 * @return liste des objets Client
	 */
	public List<Client> findByConseiller(Conseiller conseiller);

}
