package fr.gtm.proxibanquev4.service.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquev4.domaine.Conseiller;
import fr.gtm.proxibanquev4.service.conseiller.IConseillerService;
import junit.framework.TestCase;

/**
 * Test de la couche service du conseiller
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public class TestConseillerService extends TestCase {
	
	private Conseiller conseiller;
	private ClassPathXmlApplicationContext appContext;
	private IConseillerService conseillerservice;
	
	/**
	 * Mise en place du test
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		conseiller = new Conseiller("POULAIN", "clement");
		appContext = new ClassPathXmlApplicationContext("spring/application-config-service.xml");

		conseillerservice = (IConseillerService) appContext.getBean("conseillerservice");
	}
	
	public void testAddConseiller() {
		conseillerservice.addConseiller(conseiller);
	}
	
	public void testReadConseillerById() {
		Conseiller conseiller = conseillerservice.readConseillerById(1);
		assertNotNull(conseiller);
	}
	
	public void testDeleteConseiller() {
		conseillerservice.deleteConseiller(10);
	}
	
	public void testUpdateConseiller() {
		conseiller.setId(1);
		conseillerservice.updateConseiller(conseiller);
	}
	
	public void testReadAllConseillers() {
		List<Conseiller> listeConseiller = conseillerservice.readAllConseillers();
		assertNotNull(listeConseiller);
	}
	
	public void testReadConseillerByNom() {
		List<Conseiller> listeConseiller = conseillerservice.readConseillerByNom(conseiller.getNom());
		assertNotNull(listeConseiller);
	}

}
