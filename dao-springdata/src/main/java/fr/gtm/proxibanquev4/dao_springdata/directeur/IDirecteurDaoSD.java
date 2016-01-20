package fr.gtm.proxibanquev4.dao_springdata.directeur;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquev4.domaine.Directeur;

public interface IDirecteurDaoSD extends JpaRepository<Directeur, Integer> {

}
