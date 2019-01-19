package com.moviestore.utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 
 * @author pingvin
 *
 */
public class JDBCStatement {
	private Connection connection = null;
	
	/**
	 * 
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException, IOException, SQLException {

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
	
	
	/**
	 * 
	 */
	public void jDBCStatementClose() {
		try {
			if (connection!=null && !connection.isClosed()) {
				System.out.println("jDBCStatement");
				connection.close();
			}
			if (connection!=null && !connection.isClosed()) {
				System.out.println("jDBCStatement");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}






















































