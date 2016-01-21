package fr.gtm.proxibanquev4.service.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;
import fr.gtm.proxibanquev4.service.client.IClientService;
import fr.gtm.proxibanquev4.service.conseiller.IConseillerService;
import junit.framework.TestCase;

public class TestClientService extends TestCase {
	
	private Client client;
	private Conseiller conseiller;
	private ClassPathXmlApplicationContext appContext;
	private IClientService clientservice;
	private IConseillerService conseillerservice;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		client = new Client("POULAIN", "clement");
		appContext = new ClassPathXmlApplicationContext("spring/application-config-service.xml");

		clientservice = (IClientService) appContext.getBean("clientservice");
		conseillerservice = (IConseillerService) appContext.getBean("conseillerservice");
	}
	
	public void testAddClient() {
		conseiller = conseillerservice.readConseillerById(1);
		client.setConseiller(conseiller);
		clientservice.addClient(client);
	}
	
	public void testReadClientById() {
		Client client = clientservice.readClientById(2);
		assertNotNull(client);
	}
	
	public void testDeleteClient() {
		clientservice.deleteClient(10);
	}
	
	public void testUpdateClient() {
		client.setId(1);
		clientservice.updateClient(client);
	}
	
	public void testReadAllClients() {
		List<Client> listeClient = clientservice.readAllClients();
		assertNotNull(listeClient);
	}
	
	public void testReadClientByNom() {
		List<Client> listeClient = clientservice.readClientByNom(client.getNom());
		assertNotNull(listeClient);
	}
	
	public void testReadClientByConseiller() {
		conseiller = conseillerservice.readConseillerById(1);
		List<Client> listeClient = clientservice.readClientByConseiller(conseiller);
		assertNotNull(listeClient);
	}

}
