package fr.gtm.proxibanquev4.service.compte;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquev4.dao.compte.ICompteDaoSD;
import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Compte;
import fr.gtm.proxibanquev4.domaine.CompteCourant;
import fr.gtm.proxibanquev4.domaine.CompteEpargne;

@Component("compteservice")
@Transactional
public class CompteService implements ICompteService {
	
	@Autowired
	private ICompteDaoSD dao;
	
	Logger logger=Logger.getLogger(this.getClass().getName());

	public void addCompte(Compte compte) {
		dao.save(compte);
	}

	public Compte readCompteById(int id) {
		return dao.findOne(id);
	}

	public void deleteCompte(int id) {
		dao.delete(id);
	}

	public void updateCompte(Compte compte) {
		dao.save(compte);
	}

	public List<Compte> readAllComptes() {
		return dao.findAll();
	}

	public List<Compte> readCompteByClient(Client client) {
		return dao.findByClient(client);
	}

	public void virement(Compte debiteur, Compte crediteur, float montant) {
		float soldeDebiteur = debiteur.getSolde();
		float soldeCrediteur = crediteur.getSolde();
		
		if(debiteur instanceof CompteCourant && montant <= soldeDebiteur + ((CompteCourant) debiteur).getDecouvertAutorise()
				|| debiteur instanceof CompteEpargne && montant <= soldeDebiteur) {
			soldeDebiteur -= montant;
			soldeCrediteur += montant;
			
			debiteur.setSolde(soldeDebiteur);
			crediteur.setSolde(soldeCrediteur);
			
			dao.save(debiteur);
			dao.save(crediteur);
		} else logger.info("Le compte ne peut être débité.");
		
	}

}
