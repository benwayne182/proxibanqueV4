package fr.gtm.proxibanquev4.dao_springdata.compte;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquev4.domaine.Client;
import fr.gtm.proxibanquev4.domaine.Compte;

public interface ICompteDaoSD extends JpaRepository<Compte, Integer> {
	
	public List<Compte> findByClient(Client client);

}
