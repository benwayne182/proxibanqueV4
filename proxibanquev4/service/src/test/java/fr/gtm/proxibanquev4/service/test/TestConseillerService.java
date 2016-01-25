package fr.gtm.proxibanquev4.service.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;
import fr.gtm.proxibanquev4.domaine.Directeur;
import fr.gtm.proxibanquev4.service.conseiller.IConseillerService;
import fr.gtm.proxibanquev4.service.directeur.IDirecteurService;
import junit.framework.TestCase;

/**
 * Test de la couche service du conseiller
 * @author Benoit, ClémentP, Coralie, Margherita, Paul-Henri
 *
 */
public class TestConseillerService extends TestCase {
	
	private Conseiller conseiller;
	private Directeur directeur;
	private ClassPathXmlApplicationContext appContext;
	private IConseillerService conseillerservice;
	private IDirecteurService directeurservice;
	
	/**
	 * Mise en place du test, création d'un conseiller, récupération des beans
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		conseiller = new Conseiller("POULAIN", "clement");
		appContext = new ClassPathXmlApplicationContext("spring/application-config-service.xml");

		conseillerservice = (IConseillerService) appContext.getBean("conseillerservice");
		directeurservice = (IDirecteurService) appContext.getBean("directeurservice");
	}
	
	/**
	 * Test d'ajout de conseiller
	 */
	public void testAddConseiller() {
		directeur = directeurservice.readDirecteurByLogin("michel");
		conseiller.setDirecteur(directeur);
		conseillerservice.addConseiller(conseiller);
	}
	
	/**
	 * Test de lecture d'un conseiller par son ID
	 */
	public void testReadConseillerById() {
		Conseiller conseiller = conseillerservice.readConseillerById(2);
		assertNotNull(conseiller);
	}
	
	/**
	 * Test de suppression du conseiller
	 */
	public void testDeleteConseiller() {
		conseillerservice.deleteConseiller(10);
	}
	
	/**
	 * Test de mise à jour du conseiller
	 */
	public void testUpdateConseiller() {
		conseiller.setId(1);
		conseillerservice.updateConseiller(conseiller);
	}
	
	/**
	 * Test de lecture de tous les conseillers
	 */
	public void testReadAllConseillers() {
		List<Conseiller> listeConseiller = conseillerservice.readAllConseillers();
		assertNotNull(listeConseiller);
	}
	
	/**
	 * Test de récupération des conseillers par leur nom
	 */
	public void testReadConseillerByNom() {
		List<Conseiller> listeConseiller = conseillerservice.readConseillerByNom(conseiller.getNom());
		assertNotNull(listeConseiller);
	}
	
	public void testReadConseillerByDirecteur() {
		List<Conseiller> listeConseiller = conseillerservice.readConseillerByDirecteur(directeur);
		assertNotNull(listeConseiller);
	}

}
