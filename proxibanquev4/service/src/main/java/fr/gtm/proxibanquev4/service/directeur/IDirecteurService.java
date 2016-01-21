package fr.gtm.proxibanquev4.service.directeur;

import fr.gtm.proxibanquev4.domaine.Directeur;

public interface IDirecteurService {
	
	public Directeur readDirecteurById(int id);
	public void addDirecteur(Directeur dir);

}
