package fr.gtm.proxibanquev4.dao_springdata.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Conseiller;

public interface IClientDaoSD extends JpaRepository<Client, Integer>{
	
	public List<Client> findByNom(String nom);
	public List<Client> findByConseiller(Conseiller conseiller);

}
