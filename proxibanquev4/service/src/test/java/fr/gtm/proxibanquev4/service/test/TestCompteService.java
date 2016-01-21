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

public class TestCompteService extends TestCase {
	
	private Client client;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private ClassPathXmlApplicationContext appContext;
	private IClientService clientservice;
	private ICompteService compteservice;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		compteCourant = new CompteCourant(100);
		compteEpargne = new CompteEpargne(200);
		appContext = new ClassPathXmlApplicationContext("spring/application-config-service.xml");

		clientservice = (IClientService) appContext.getBean("clientservice");
		compteservice = (ICompteService) appContext.getBean("compteservice");
	}
	
	public void testAddCompte() {
		client = clientservice.readClientById(2);
		compteCourant.setClient(client);
		compteEpargne.setClient(client);
		compteservice.addCompte(compteCourant);
		compteservice.addCompte(compteEpargne);
	}
	
	public void testReadCompteById() {
		Compte compte = compteservice.readCompteById(6);
		assertNotNull(compte);
	}
	
	public void testDeleteCompte() {
		compteservice.deleteCompte(6);
	}
	
	public void testUpdateCompte() {
		Compte compte = compteservice.readCompteById(7);
		compte.setSolde(300);
		compteservice.updateCompte(compte);
	}
	
	public void testReadAllComptes() {
		List<Compte> listeComptes = compteservice.readAllComptes();
		assertNotNull(listeComptes);
	}
	
	public void testReadCompteByClient() {
		client = clientservice.readClientById(2);
		List<Compte> listeComptes = compteservice.readCompteByClient(client);
		assertNotNull(listeComptes);
	}

}
