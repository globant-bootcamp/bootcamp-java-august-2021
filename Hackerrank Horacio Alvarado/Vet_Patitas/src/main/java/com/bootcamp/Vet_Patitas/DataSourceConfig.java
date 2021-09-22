package com.bootcamp.Vet_Patitas;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource(){

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/vet_patitas");
        dataSourceBuilder.username("admin");
        dataSourceBuilder.password("1234");
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        return dataSourceBuilder.build();

    }
}
