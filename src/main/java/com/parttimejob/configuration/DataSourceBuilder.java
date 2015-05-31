package com.parttimejob.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * Created by on 2015. 3. 21..
 */
public class DataSourceBuilder {

	private static final String URL = "partTimeJob.mysql.jdbc.url";
	private static final String USER_NAME = "partTimeJob.mysql.jdbc.username";
	private static final String USER_PASSWORD = "partTimeJob.mysql.jdbc.password";

	public DataSource build(Environment environment) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl(environment.getProperty(URL));
		dataSource.setUsername(environment.getProperty(USER_NAME));
		dataSource.setPassword(environment.getProperty(USER_PASSWORD));

		return dataSource;
	}
}
