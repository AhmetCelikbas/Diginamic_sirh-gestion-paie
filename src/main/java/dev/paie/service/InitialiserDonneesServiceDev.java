package dev.paie.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	/*
	 * REPOSITORY
	 */
	@Autowired
	private CotisationRepository cotisationRepository;
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired 
	private ProfilRemunerationRepository profilRemunerationRepository;
	
	@Autowired
	private PeriodeRepository periodeRepository;
	
	/* 
	 * DATA FROM Context
	 */
	
	@Autowired
	private List<Cotisation> cotisations;
	
	@Autowired
	private List<Entreprise> entreprises;
	
	@Autowired
	private List<Grade> grades;
	
	@Autowired
	private List<ProfilRemuneration> profilRemunerations;

	
	
	@Override
	public void initialiser() {
		
		System.out.println("INITALISER DONNES SERVICE");
		
		
		for(Cotisation cotisation: cotisations) {
			cotisationRepository.save(cotisation);
		}
		
		for(Entreprise entreprise: entreprises) {
			entrepriseRepository.save(entreprise);
		}
		
		for(Grade grade: grades) {
			gradeRepository.save(grade);
		}
		
		for(ProfilRemuneration profilRemuneration: profilRemunerations) {
			profilRemunerationRepository.save(profilRemuneration);
		}
		
		for(int numMois = 1; numMois <=12; numMois++) {
			periodeRepository.save(new Periode(numMois));
		}
		
		
	}
}
