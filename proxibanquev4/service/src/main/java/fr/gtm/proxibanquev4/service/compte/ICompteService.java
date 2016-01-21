package fr.gtm.proxibanquev4.service.compte;

import java.util.List;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Compte;

public interface ICompteService {
	
	public void addCompte (Compte compte);
	public Compte readCompteById (int id);
	public void deleteCompte (int id);
	public void updateCompte (Compte compte);
	public List<Compte> readAllComptes();
	public List<Compte> readCompteByClient(Client client);
	public void virement (Compte debiteur, Compte crediteur, float montant);

}
