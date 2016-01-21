package fr.gtm.proxibanquev4.service.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquev4.dao_springdata.client.IClientDao;
import fr.gtm.proxibanquev4.dao_springdata.compte.ICompteDao;
import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Compte;
import fr.gtm.proxibanquev4.domaine.CompteCourant;
import fr.gtm.proxibanquev4.domaine.CompteEpargne;
import junit.framework.TestCase;

public class TestCompteService extends TestCase {
	
	private Client client;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private ClassPathXmlApplicationContext appContext;
	private IClientDao clientdao;
	private ICompteDao comptedao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		compteCourant = new CompteCourant(100);
		compteEpargne = new CompteEpargne(200);
		appContext = new ClassPathXmlApplicationContext("application-config-service.xml");

		clientdao = (IClientDao) appContext.getBean("clientdao");
		comptedao = (ICompteDao) appContext.getBean("comptedao");
	}
	
	public void testAddCompte() {
		client = clientdao.readClientById(2);
		compteCourant.setClient(client);
		compteEpargne.setClient(client);
		comptedao.addCompte(compteCourant);
		comptedao.addCompte(compteEpargne);
	}
	
	public void testReadCompteById() {
		Compte compte = comptedao.readCompteById(6);
		assertNotNull(compte);
	}
	
	public void testDeleteCompte() {
		comptedao.deleteCompte(6);
	}
	
	public void testUpdateCompte() {
		Compte compte = comptedao.readCompteById(7);
		compte.setSolde(300);
		comptedao.updateCompte(compte);
	}
	
	public void testReadAllComptes() {
		List<Compte> listeComptes = comptedao.readAllComptes();
		assertNotNull(listeComptes);
	}
	
	public void testReadCompteByClient() {
		client = clientdao.readClientById(2);
		List<Compte> listeComptes = comptedao.readCompteByClient(client);
		assertNotNull(listeComptes);
	}

}
