package com.example.vetpatitas;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfiguration {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/vetPatitas?serverTimezone=UTC");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("y4P0RF4V0R");
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        return dataSourceBuilder.build();
    }
}