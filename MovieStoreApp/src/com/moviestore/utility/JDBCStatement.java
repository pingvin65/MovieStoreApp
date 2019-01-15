package com.moviestore.utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCStatement {

	public Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		final Properties prop = new Properties();
	
		final InputStream inputStream = OracleSQL.class.getClassLoader()
				.getResourceAsStream("com/moviestore/resources/db.properties");
		prop.load(inputStream);
		try {
		Class.forName(prop.getProperty("driver"));
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {

		connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
		return connection;
		} catch  (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
}






















































