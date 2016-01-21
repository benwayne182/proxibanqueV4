package fr.gtm.proxibanquev4.dao.compte;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Compte;

/**
 * Interface SpringDATA pour le DAO du Compte, h�rite de JpaRepository
 * @author  Benoit, Cl�mentP, Coralie, Margherita, Paul-Henri
 *
 */
public interface ICompteDaoSD extends JpaRepository<Compte, Integer> {
	
	/**
	 * Trouver la liste des comptes associ�s � un client
	 * @param client
	 * @return lsite des objets Compte
	 */
	public List<Compte> findByClient(Client client);

}
