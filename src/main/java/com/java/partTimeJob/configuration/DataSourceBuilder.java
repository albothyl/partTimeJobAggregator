package com.java.partTimeJob.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * Created by on 2015. 3. 21..
 */
public class DataSourceBuilder {
    public DataSource build(Environment environment) throws SQLException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new com.mysql.jdbc.Driver());
        dataSource.setUrl(environment.getProperty("partTimeJob.mysql.jdbc.url"));
        dataSource.setUsername(environment.getProperty("partTimeJob.mysql.jdbc.username"));
        dataSource.setPassword(environment.getProperty("partTimeJob.mysql.jdbc.password"));

        return dataSource;
    }
}
