package fr.gtm.proxibanquev4.service.conseiller;

import java.util.List;

import fr.gtm.proxibanquev4.domaine.Conseiller;

public interface IConseillerService {
	
	public void addConseiller (Conseiller conseiller);
	public Conseiller readConseillerById (int id);
	public void deleteConseiller (int id);
	public void updateConseiller (Conseiller conseiller);
	public List<Conseiller> readAllConseillers();
	public List<Conseiller> readConseillerByNom(String nom);

}
