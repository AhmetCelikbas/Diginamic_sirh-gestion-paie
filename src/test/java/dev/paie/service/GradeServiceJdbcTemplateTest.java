package dev.paie.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.entite.Grade;

//TODO compléter la configuration

@ContextConfiguration(classes = { DataSourceMySQLConfig.class })
@RunWith(SpringRunner.class)

public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		Grade nouveauGrade = new Grade();
		Random random = new Random();

		// TODO sauvegarder un nouveau grade
		nouveauGrade.setCode("AM" + random.nextInt(1000));
		nouveauGrade.setNbHeuresBase(BigDecimal.valueOf(random.nextDouble() * 100));
		nouveauGrade.setTauxBase(BigDecimal.valueOf(random.nextDouble() * 10));
		gradeService.sauvegarder(nouveauGrade);

		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister

		List<Grade> gradesFiltre = gradeService.lister().stream()
				.filter(grade -> grade.getCode().equals(nouveauGrade.getCode())).collect(Collectors.toList());

		assertEquals(nouveauGrade.getCode(), gradesFiltre.get(0).getCode());

		// TODO modifier un grade

		String ancienCode = gradesFiltre.get(0).getCode();
		String nouveauCode = "AM" + random.nextInt(1000);

		// modifier le grade
		gradesFiltre.get(0).setCode(nouveauCode);

		// mettre a jour le grade de la bdd avec le grade midifié
		gradeService.mettreAJour(gradesFiltre.get(0));

		Optional<Grade> OptGrade = gradeService.lister().stream().filter(grade -> grade.getCode().equals(nouveauCode))
				.findFirst();

		Grade grade = null;
		if (OptGrade.isPresent()) {
			grade = OptGrade.get();
		}

		
		assertNotNull(grade);
		assertEquals(nouveauCode, grade.getCode());

	}
}
