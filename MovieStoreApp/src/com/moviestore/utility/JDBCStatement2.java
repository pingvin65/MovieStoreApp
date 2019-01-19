package com.moviestore.utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class JDBCStatement2 {

	public Connection getConnection() throws ClassNotFoundException, IOException, SQLException {

		Connection connection = null;
		DataSource datasource = new DataSource();
		PoolProperties p = null;
		final Properties prop = new Properties();

		final InputStream inputStream = OracleSQL.class.getClassLoader()
				.getResourceAsStream("com/moviestore/resources/db.properties");
		prop.load(inputStream);
		try {
			Class.forName(prop.getProperty("driver"));
			p = new PoolProperties();
			p.setDriverClassName(prop.getProperty("driver"));
			p.setUrl(prop.getProperty("url"));
			p.setUsername(prop.getProperty("user"));
			p.setPassword(prop.getProperty("password"));
//			p.setJmxEnabled(true);
//			p.setTestWhileIdle(false);
//			p.setTestOnBorrow(true);
//			p.setValidationQuery("SELECT 1");
//			p.setTestOnReturn(false);
//			p.setValidationInterval(30000);
//			p.setTimeBetweenEvictionRunsMillis(30000);
//			p.setMaxIdle(30);
//			p.setMaxActive(50);
//			p.setInitialSize(10);
//			p.setMaxWait(10000);
//			p.setRemoveAbandonedTimeout(60);
//			p.setMinEvictableIdleTimeMillis(30000);
//			p.setMinIdle(10);
//			p.setLogAbandoned(true);
//			p.setRemoveAbandoned(true);
//			p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
//					+ "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
//			p.setMaxActive(30);
//			p.setInitialSize(10);
//			p.setMinIdle(10);
			System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddd");
			datasource.setPoolProperties(p);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			connection =  datasource.getConnection();
//			connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
//					prop.getProperty("password"));

			return connection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			inputStream.close();
		}
		return connection;
	}

}








