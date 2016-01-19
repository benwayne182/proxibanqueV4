package fr.gtm.proxibanquev4.dao_springdata.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquev4.dao_springdata.client.IClientDao;
import fr.gtm.proxibanquev4.dao_springdata.conseiller.IConseillerDao;
import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;
import junit.framework.TestCase;

public class TestClientDao extends TestCase {
	
	private Client client;
	private Conseiller conseiller;
	private ClassPathXmlApplicationContext appContext;
	private IClientDao clientdao;
	private IConseillerDao conseillerdao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		client = new Client("POULAIN", "clement");
		appContext = new ClassPathXmlApplicationContext("spring/application-config.xml");

		clientdao = (IClientDao) appContext.getBean("clientdao");
		conseillerdao = (IConseillerDao) appContext.getBean("conseillerdao");
	}
	
	public void testAddClient() {
		conseiller = conseillerdao.readConseillerById(1);
		client.setConseiller(conseiller);
		clientdao.addClient(client);
	}
	
	public void testReadClientById() {
		Client client = clientdao.readClientById(1);
		assertNotNull(client);
	}
	
	public void testDeleteClient() {
		clientdao.deleteClient(10);
	}
	
	public void testUpdateClient() {
		client.setId(1);
		clientdao.updateClient(client);
	}
	
	public void testReadAllClients() {
		List<Client> listeClient = clientdao.readAllClients();
		assertNotNull(listeClient);
	}
	
	public void testReadClientByNom() {
		List<Client> listeClient = clientdao.readClientByNom(client.getNom());
		assertNotNull(listeClient);
	}
	
	public void testReadClientByConseiller() {
		conseiller = conseillerdao.readConseillerById(1);
		List<Client> listeClient = clientdao.readClientByConseiller(conseiller);
		assertNotNull(listeClient);
	}

}
