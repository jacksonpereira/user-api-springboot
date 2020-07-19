package com.crud;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.crud.repositories")
public class CrudBasicoApplication {
	
	final static Logger logger = LogManager.getLogger(CrudBasicoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrudBasicoApplication.class, args);
		logger.info("Aplicação Iniciada!");
	}

}
