package org.sample;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (value="org.sample")
public class MyConfig {
	
	
	@Bean
	public EntityManagerFactory getEntityManagerFactory() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		return emf;
		
	}
}
