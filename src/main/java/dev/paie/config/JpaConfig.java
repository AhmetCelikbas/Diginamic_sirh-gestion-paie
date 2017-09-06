package dev.paie.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories("dev.paie.repository")
public class JpaConfig {

	@Bean
	// Cette configuration nécessite une source de données configurée.
	// Elle s'utilise donc en association avec un autre fichier de configuration d éfinissant un bean DataSource.
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);
	    // activer les logs SQL
	    vendorAdapter.setShowSql(true);
	    
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    // alternative au persistence.xml
	    factory.setPackagesToScan("dev.paie.entite");
	    factory.setDataSource(dataSource);
	    factory.afterPropertiesSet();
	    return factory.getObject();
	}
}
