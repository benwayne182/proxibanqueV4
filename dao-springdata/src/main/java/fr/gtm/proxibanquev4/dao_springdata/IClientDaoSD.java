package fr.gtm.proxibanquev4.dao_springdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquev4.domaine.Client;

public interface IClientDaoSD extends JpaRepository<Client, Integer>{
	
	public List<Client> findByNom(String nom);

}
