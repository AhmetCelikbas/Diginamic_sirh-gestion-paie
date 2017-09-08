//package dev.paie.repository;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.math.BigDecimal;
//import java.util.Random;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import dev.paie.config.DataSourceMySQLConfig;
//import dev.paie.config.JpaConfig;
//import dev.paie.config.JpaTransactionManagerConfig;
//import dev.paie.config.ServicesConfig;
//import dev.paie.entite.Avantage;
//
////@ComponentScan({"dev.paie.entite"})
//@ContextConfiguration(
//		classes = { 
//			ServicesConfig.class, 
//			JpaConfig.class, 
//			JpaTransactionManagerConfig.class, 
//			DataSourceMySQLConfig.class 
//		}
//	)
//
//@RunWith(SpringRunner.class)
//public class AvantageRepositoryTest {
//
//	@Autowired 
//	private AvantageRepository avantageRepository;
//	
//	@Test
//	public void test_sauvegarder_lister_mettre_a_jour() {
//		// TODO sauvegarder un nouvel avantage
//		
//			Random random = new Random();
//					
//			Avantage nouvelAvantage = new Avantage();
//			nouvelAvantage.setCode("avt" + random.nextInt(1000));
//			nouvelAvantage.setMontant(BigDecimal.valueOf(random.nextInt(1000)));
//			nouvelAvantage.setNom("nouvelAvantage");
//			
//			avantageRepository.save(nouvelAvantage);
//		
//		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la m éthode findOne
//			Avantage avantageEnBase = avantageRepository.findOne(nouvelAvantage.getId());
//			assertNotNull(avantageEnBase);
//			assertEquals(nouvelAvantage.getCode(), avantageEnBase.getCode());
//		
//	    // TODO modifier un avantage
//			String nouveauCode = "avt" + random.nextInt(1000);
//			avantageEnBase.setCode(nouveauCode);
//			avantageRepository.save(avantageEnBase);
//		
//		// TODO vérifier que les modifications sont bien prises en compte via la m éthode findOne
//	
//			Avantage avantageEnBase2 = avantageRepository.findOne(avantageEnBase.getId());
//			assertNotNull(avantageEnBase2);
//			assertEquals(nouveauCode, avantageEnBase2.getCode());
//			
//	}
//}
