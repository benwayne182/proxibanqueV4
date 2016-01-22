package fr.gtm.proxibanquev4.service.directeur;

import fr.gtm.proxibanquev4.domaine.Directeur;
/**
 * Interface avec les methodes pour le traitement des objets de type Directeur
 * @author Benoit, Cl�mentP, Coralie, Margherita, Paul-Henri
 *
 */
public interface IDirecteurService {
	/**
	 * Trouver un directer par son ID
	 * @param id
	 * @return objet Directeur
	 */
	public Directeur readDirecteurById(int id);
	/**
	 * Ajouter un nouuveau directeur
	 * @param dir objet Directeur � inserer dans la base
	 */
	public void addDirecteur(Directeur dir);
	
	public Directeur readDirecteurByLogin(String login);

}
