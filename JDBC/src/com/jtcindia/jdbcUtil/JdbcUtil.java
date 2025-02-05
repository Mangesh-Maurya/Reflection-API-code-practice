package com.jtcindia.jdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {
	public static Connection getMySQLConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbcdb","root","Mangesh@12");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

	public static Connection getOracleConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","man12");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
	public static void cleanup(Statement st,Connection con) {
	try {
		if(st != null)
			st.close();
		if(con != null)
			con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	public static void cleanup(ResultSet rs,Statement st,Connection con) {
		try {
			if(rs != null)
				rs.close();
			if(st != null)
				st.close();
			if(con != null)
				con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
