package fr.gtm.proxibanquev4.service.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquev4.dao_springdata.conseiller.IConseillerDao;
import fr.gtm.proxibanquev4.domaine.Conseiller;
import junit.framework.TestCase;

public class TestConseillerService extends TestCase {
	
	private Conseiller conseiller;
	private ClassPathXmlApplicationContext appContext;
	private IConseillerDao conseillerdao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		conseiller = new Conseiller("POULAIN", "clement");
		appContext = new ClassPathXmlApplicationContext("application-config-service.xml");

		conseillerdao = (IConseillerDao) appContext.getBean("conseillerdao");
	}
	
	public void testAddConseiller() {
		conseillerdao.addConseiller(conseiller);
	}
	
	public void testReadConseillerById() {
		Conseiller conseiller = conseillerdao.readConseillerById(1);
		assertNotNull(conseiller);
	}
	
	public void testDeleteConseiller() {
		conseillerdao.deleteConseiller(10);
	}
	
	public void testUpdateConseiller() {
		conseiller.setId(1);
		conseillerdao.updateConseiller(conseiller);
	}
	
	public void testReadAllConseillers() {
		List<Conseiller> listeConseiller = conseillerdao.readAllConseillers();
		assertNotNull(listeConseiller);
	}
	
	public void testReadConseillerByNom() {
		List<Conseiller> listeConseiller = conseillerdao.readConseillerByNom(conseiller.getNom());
		assertNotNull(listeConseiller);
	}

}
