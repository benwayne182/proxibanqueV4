package fr.gtm.proxibanquev4.service.compte;

import java.util.List;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Compte;

/**
 * Interface de la couche service pour le compte
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public interface ICompteService {
	
	/**
	 * Ajouter un compte à la base
	 * @param compte
	 */
	public void addCompte (Compte compte);
	/**
	 * Lire un compte à partir de son ID
	 * @param id
	 * @return objet de type Compte
	 */
	public Compte readCompteById (int id);
	/**
	 * Effacer un compte identifie par son ID
	 * @param id
	 */
	public void deleteCompte (int id);
	/**
	 * Mettre à jour un compte
	 * @param compte
	 */
	public void updateCompte (Compte compte);
	/**
	 * Lire tous les comptes de la base
	 * @return liste des objets Compte
	 */
	public List<Compte> readAllComptes();
	/**
	 * Lire les comptes associes à un client
	 * @param client
	 * @return liste des comptes
	 */
	public List<Compte> readCompteByClient(Client client);
	/**
	 * Effectuer un virement
	 * @param debiteur objet du Compte a debiter
	 * @param crediteur objet du Compte a crediter
	 * @param montant montant du virement
	 */
	public void virement (Compte debiteur, Compte crediteur, float montant);

}
