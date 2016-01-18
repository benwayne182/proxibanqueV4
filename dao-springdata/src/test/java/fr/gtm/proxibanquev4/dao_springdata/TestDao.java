package fr.gtm.proxibanquev4.dao_springdata;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquev4.domaine.Client;
import junit.framework.TestCase;

public class TestDao extends TestCase {
	
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
	
	public void testCreate() {
		clientdao.create(client);
	}
	
	public void testFindById() {
		Client client = clientdao.findById(1);
		assertNotNull(client);
	}
	
	public void testDelete() {
		clientdao.delete(10);
	}
	
	public void testUpdate() {
		client.setId(1);
		clientdao.update(client);
	}
	
	public void testFindAll() {
		List<Client> listeClient = clientdao.findAll();
		assertNotNull(listeClient);
	}
	
	public void testFindByNom() {
		List<Client> listeClient = clientdao.findByNom(client.getNom());
		assertNotNull(listeClient);
	}

}
