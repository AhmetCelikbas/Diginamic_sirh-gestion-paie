package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@Import({
	ServicesConfig.class, 
	JpaConfig.class, 
	JpaTransactionManagerConfig.class, 
	DataSourceMySQLConfig.class 
})
@EnableWebMvc
@ImportResource({
	"classpath:cotisations-imposables.xml",
	"classpath:cotisations-non-imposables.xml",
	"classpath:entreprises.xml",
	"classpath:grades.xml",
	"classpath:profils-remuneration.xml"
})

public class WebAppConfig {
	
	@Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
}
