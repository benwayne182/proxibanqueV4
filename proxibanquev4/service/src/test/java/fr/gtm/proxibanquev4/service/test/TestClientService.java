package fr.gtm.proxibanquev4.service.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;
import fr.gtm.proxibanquev4.service.client.IClientService;
import fr.gtm.proxibanquev4.service.conseiller.IConseillerService;
import junit.framework.TestCase;

/**
 * Classe de tests pour la couche service du client
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public class TestClientService extends TestCase {
	
	private Client client;
	private Conseiller conseiller;
	private ClassPathXmlApplicationContext appContext;
	private IClientService clientservice;
	private IConseillerService conseillerservice;
	
	/**
	 * Initialisation du test, création d'un client, récupération des beans
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		client = new Client("POULAIN", "clement");
		appContext = new ClassPathXmlApplicationContext("spring/application-config-service.xml");

		clientservice = (IClientService) appContext.getBean("clientservice");
		conseillerservice = (IConseillerService) appContext.getBean("conseillerservice");
	}
	
	/**
	 * Test d'ajout de client
	 */
	public void testAddClient() {
		conseiller = conseillerservice.readConseillerById(1);
		client.setConseiller(conseiller);
		clientservice.addClient(client);
	}
	
	/**
	 * Test de lecture du client par son ID
	 */
	public void testReadClientById() {
		Client client = clientservice.readClientById(2);
		assertNotNull(client);
	}
	
	/**
	 * Test du suppression d'un client
	 */
	public void testDeleteClient() {
		clientservice.deleteClient(10);
	}
	
	/**
	 * Test de mise à jour du client
	 */
	public void testUpdateClient() {
		client.setId(1);
		clientservice.updateClient(client);
	}
	
	/**
	 * Test de récupération de la liste de tous les clients
	 */
	public void testReadAllClients() {
		List<Client> listeClient = clientservice.readAllClients();
		assertNotNull(listeClient);
	}
	
	/**
	 * Test de lecture du client par son nom
	 */
	public void testReadClientByNom() {
		List<Client> listeClient = clientservice.readClientByNom(client.getNom());
		assertNotNull(listeClient);
	}
	
	/**
	 * Test de récupération de la liste des clients d'un conseiller
	 */
	public void testReadClientByConseiller() {
		conseiller = conseillerservice.readConseillerById(1);
		List<Client> listeClient = clientservice.readClientByConseiller(conseiller);
		assertNotNull(listeClient);
	}

}
