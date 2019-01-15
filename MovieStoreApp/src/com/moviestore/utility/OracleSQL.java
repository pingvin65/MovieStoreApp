package com.moviestore.utility;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.moviestore.utility.DBConnection;



/**
 * 
 * @author pingvin
 * 
 */
public class OracleSQL extends DBConnection {

	private  Statement stmt = null;
	private  ResultSet rs = null;
	private  PreparedStatement ps;

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return ResultSet is public interface ResultSet
	 */
	public ResultSet getData(String query) {
		rs = null;
		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(query);

			//stmt.close();
			//getConnection().close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// closeStmt();
		// closeConection();

		return rs;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return int generated Key
	 */
	public int insertData2(String query) {
		rs = null;
		int generatedKey = 0;
		try {
			ps = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.execute();
			ps = getConnection().prepareStatement("SELECT teaching_id from (\r\n"
					+ "    SELECT * FROM teaching ORDER BY TEACHING_ID DESC\r\n" + ") WHERE ROWNUM = 1");
			// PreparedStatement ps = getConnection().prepareStatement("SELECT
			// TEACHING_SEQ.nextval FROM dual");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				generatedKey = (int) rs.getLong(1);
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		return generatedKey;
	}

	
}
