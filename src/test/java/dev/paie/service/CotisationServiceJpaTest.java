package dev.paie.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JpaConfig;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { JpaConfig.class })
@RunWith(SpringRunner.class)

public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		Random random = new Random();
		Cotisation cotisationEnBase;
		Optional<Cotisation> OptGrade;

		// TODO sauvegarder une nouvelle cotisation
		Cotisation nouvelleCotisation = new Cotisation();
		nouvelleCotisation.setCode("cotisation" + random.nextInt(1000));
		nouvelleCotisation.setLibelle("cotisationLIBELLE" + random.nextInt(1000));
		nouvelleCotisation.setTauxPatronal(BigDecimal.valueOf(random.nextDouble() * 100));
		nouvelleCotisation.setTauxSalarial(BigDecimal.valueOf(random.nextDouble() * 10));

		cotisationService.sauvegarder(nouvelleCotisation);

		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via
		// la méthode lister
		OptGrade = cotisationService.lister().stream()
				.filter(cotisation -> cotisation.getCode().equals(nouvelleCotisation.getCode())).findFirst();

		cotisationEnBase = null;
		if (OptGrade.isPresent()) {
			cotisationEnBase = OptGrade.get();
		}

		assertNotNull(cotisationEnBase);
		assertEquals(nouvelleCotisation.getCode(), cotisationEnBase.getCode());

		// for(Cotisation cotisation: cotisationService.lister()) {
		// System.out.println(cotisation.getCode());
		// }

		// TODO modifier une cotisation
		
		nouvelleCotisation.setCode("cotisation" + random.nextInt(1000));

		cotisationService.mettreAJour(nouvelleCotisation);

		// TODO vérifier que les modifications sont bien prises en compte via la m
		// éthode lister
//		 for(Cotisation cotisationsss: cotisationService.lister()) {
//		 System.out.println(cotisationsss.getCode());
//		 }

		OptGrade = cotisationService.lister().stream()
				.filter(cotisation -> cotisation.getCode().equals(nouvelleCotisation.getCode())).findFirst();

		cotisationEnBase = null;
		if (OptGrade.isPresent()) {
			cotisationEnBase = OptGrade.get();
		}

		assertNotNull(cotisationEnBase);
		assertEquals(nouvelleCotisation.getCode(), cotisationEnBase.getCode());

	}

}
