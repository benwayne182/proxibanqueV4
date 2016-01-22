package fr.gtm.proxibanquev4.service.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Compte;
import fr.gtm.proxibanquev4.domaine.CompteCourant;
import fr.gtm.proxibanquev4.domaine.CompteEpargne;
import fr.gtm.proxibanquev4.service.client.IClientService;
import fr.gtm.proxibanquev4.service.compte.ICompteService;
import junit.framework.TestCase;

/**
 * Test de la couche service des comptes
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public class TestCompteService extends TestCase {
	
	private Client client;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private ClassPathXmlApplicationContext appContext;
	private IClientService clientservice;
	private ICompteService compteservice;
	
	/**
	 * Mise en place du test, création de comptes et récupération des beans
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		compteCourant = new CompteCourant(100);
		compteEpargne = new CompteEpargne(200);
		compteCourant.setSolde(500);
		compteEpargne.setSolde(500);
		appContext = new ClassPathXmlApplicationContext("spring/application-config-service.xml");

		clientservice = (IClientService) appContext.getBean("clientservice");
		compteservice = (ICompteService) appContext.getBean("compteservice");
	}
	
	/**
	 * Test d'ajout de compte
	 */
	public void testAddCompte() {
		client = clientservice.readClientById(2);
		compteCourant.setClient(client);
		compteEpargne.setClient(client);
		compteservice.addCompte(compteCourant);
		compteservice.addCompte(compteEpargne);
	}
	
	/**
	 * Test de lecture du compte par son ID
	 */
	public void testReadCompteById() {
		Compte compte = compteservice.readCompteById(6);
		assertNotNull(compte);
	}
	
	/**
	 * Test de suppression de compte
	 */
	public void testDeleteCompte() {
		compteservice.deleteCompte(6);
	}
	
	/**
	 * Test de modification de compte
	 */
	public void testUpdateCompte() {
		Compte compte = compteservice.readCompteById(7);
		compte.setSolde(300);
		compteservice.updateCompte(compte);
	}
	
	/**
	 * Test de récupération de tous les comptes
	 */
	public void testReadAllComptes() {
		List<Compte> listeComptes = compteservice.readAllComptes();
		assertNotNull(listeComptes);
	}
	
	/**
	 * Test de récupération des comptes d'un client
	 */
	public void testReadCompteByClient() {
		client = clientservice.readClientById(2);
		List<Compte> listeComptes = compteservice.readCompteByClient(client);
		assertNotNull(listeComptes);
	}
	
	/**
	 * Test de la fonction de virement entre deux comptes, pour un montant de 50 000 crédits
	 */
	public void testVirement() {
		compteservice.virement(compteCourant, compteEpargne, 50000);
	}

}
