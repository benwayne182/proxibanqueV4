package fr.gtm.proxibanquev4.service.conseiller;

import java.util.List;

import fr.gtm.proxibanquev4.domaine.Conseiller;
/**
 * Interface de la couche service pour le traitement des objets Conseiller
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public interface IConseillerService {
	
	/**
	 * Ajouter un conseiller
	 * @param conseiller
	 */
	public void addConseiller (Conseiller conseiller);
	/**
	 * Trouver un conseiler par son numero ID
	 * @param id
	 * @return objet Conseiller
	 */
	public Conseiller readConseillerById (int id);
	/**
	 * Effacer un conseiller
	 * @param id numero ID du conseiller
	 */
	public void deleteConseiller (int id);
	/**
	 * Mettre a joru un conseiller
	 * @param conseiller nouveau conseiller à saisir dans la base
	 */
	public void updateConseiller (Conseiller conseiller);
	/**
	 * Trouver tous les conseillers
	 * @return liste des conseillers 
	 */
	public List<Conseiller> readAllConseillers();
	/**
	 * Trouver un conseiller par son nom
	 * @param nom strign du nom du conseiller
	 * @return liste des conseillers avec le meme nom
	 */
	public List<Conseiller> readConseillerByNom(String nom);
	
	public Conseiller readConseillerByLogin(String login);

}
