package fr.gtm.proxibanquev4.dao_springdata.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquev4.dao_springdata.IClientDao;
import fr.gtm.proxibanquev4.domaine.Client;
import junit.framework.TestCase;

public class TestClientDao extends TestCase {
	
	private Client client;
	private ClassPathXmlApplicationContext appContext;
	private IClientDao clientdao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		client = new Client("POULAIN", "clement");
		appContext = new ClassPathXmlApplicationContext("spring/application-config.xml");

		clientdao = (IClientDao) appContext.getBean("clientdao");
	}
	
	public void testAddClient() {
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

}
