package fr.gtm.proxibanquev4.dao_springdata.directeur;

import fr.gtm.proxibanquev4.domaine.Directeur;

public interface IDirecteurDao {
	
	public Directeur readDirecteurById(int id);
	public void addDirecteur(Directeur dir);

}
