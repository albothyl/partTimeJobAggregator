package com.java.partTimeJob.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by on 2015. 3. 17..
 */
@Configuration
@PropertySource("classpath:dataSource/develop.xml")
public class RepositoryConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() throws SQLException {
     return new DataSourceBuilder().build(environment);
    }
}
