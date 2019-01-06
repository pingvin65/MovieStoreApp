package com.moviestore.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.moviestore.systemsInterfaces.CustomerDAOI;
import com.moviestore.utility.OracleSQL;

public class CustomerDAO implements CustomerDAOI {

	/**
	 * @return String email
	 */
	@Override
	public String getCustomerByEmail(String email) {
		ResultSet rs = null;
		String email2 = null;
		rs = new OracleSQL().getData("SELECT email FROM view_customer WHERE email='" + email + "'");
		try {
			if (rs.next()) { //
				email2 = rs.getNString("email");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return email2;
	}

	/**
	 * @return  boolean  if CUSTOMER created
	 */
	@Override
	public boolean inserData(String sql) {
		boolean created = false;
		try {
			PreparedStatement ps = new OracleSQL().getConnection().prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			ps.close();
			created = true;
		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		}

		return created;

	}

}
