package com.globant.vet.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomDataSource {
	@Bean
	public DataSource getPostgressDataSource() {
		return DataSourceBuilder.create()
			.driverClassName(AppProperties.getProperty("custom.datasource.classname"))
			.url(AppProperties.getProperty("custom.datasource.url"))
			.username(AppProperties.getProperty("custom.datasource.user"))
			.password(AppProperties.getProperty("custom.datasource.password"))
			.build();
	}
}
