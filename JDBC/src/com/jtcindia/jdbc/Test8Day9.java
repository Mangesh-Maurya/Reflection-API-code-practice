package com.jtcindia.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;

import com.jtcindia.jdbcUtil.JdbcUtil;
public class Test8Day9 {
	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cs=null;
		try {
			int sid=Integer.parseInt(args[0]);
			String name=args[1];
			String email=args[2];
			int ph=Integer.parseInt(args[3]);
			int fee=Integer.parseInt(args[4]);

			con=JdbcUtil.getOracleConnection();
			System.out.println("testing data ");
			String SQL="{call insertstudentinfo(?,?,?,?,?)}";
			cs=con.prepareCall(SQL);
			cs.setInt(1, sid);
			cs.setString(2, name);
			cs.setString(3, email);
			cs.setInt(4, ph);
			cs.setInt(5, fee);
			System.out.println("testing 2");

			cs.execute();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.cleanup(cs, con);
		}
	}

}
