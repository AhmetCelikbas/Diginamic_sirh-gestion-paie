package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Repository
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		// TODO Auto-generated method stub
		em.persist(nouvelleCotisation);
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		// TODO Auto-generated method stub
		Cotisation nouvelleCotisation = em.find(Cotisation.class, cotisation.getId());		
		nouvelleCotisation.setCode(cotisation.getCode());
		nouvelleCotisation.setLibelle(cotisation.getLibelle());
		nouvelleCotisation.setTauxSalarial(cotisation.getTauxSalarial());
		nouvelleCotisation.setTauxPatronal(cotisation.getTauxPatronal());
	}

	@Override
	@Transactional
	public List<Cotisation> lister() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cotisation", Cotisation.class).getResultList(); 
	}

}
