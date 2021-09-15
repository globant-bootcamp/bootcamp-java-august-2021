package com.globant.crudvetpet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 07/09/21
 */
@Configuration
public class DataBaseConnection {

    @Value("${database.data.driver-class-name}")
    private String driverClassname;

    @Value("${database.data.url}")
    private String url;

    @Value("${database.data.username}")
    private String userName;

    @Value("${database.data.password}")
    private String passWord;

    @Bean
    public DriverManagerDataSource connectToDB() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassname);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);
        return dataSource;
    }
}
