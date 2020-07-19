package com.crud.configs;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
//@PropertySource(value="classpath:application.properties")
@EnableTransactionManagement
public class H2TestProfileJPAConfig {

//	@Bean
//    @Profile("test")
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jjdbc:mysql://localhost:3010/CrudBasicoTest?useSSL=false");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        return (DataSource) dataSource;
//    }
}
