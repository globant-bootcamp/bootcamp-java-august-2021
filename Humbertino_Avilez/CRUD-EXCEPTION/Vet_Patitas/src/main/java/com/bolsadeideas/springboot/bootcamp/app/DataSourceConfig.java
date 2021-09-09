package com.bolsadeideas.springboot.bootcamp.app;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/vetpatitas?serverTimezone=UTC");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("Sombrero123");
		dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
		return dataSourceBuilder.build();
	}
}
