package com.jtcindia.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jtcindia.jdbcUtil.JdbcUtil;
public class Test7day8 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		int mycid=Integer.parseInt(args[0]);
		String mycname=args[1];

		String myemail=args[2];
		int myphone=Integer.parseInt(args[3]);
		String mycity=args[4];


		try {
			con=JdbcUtil.getMySQLConnection();
			String SQL="insert into mycustomers values(?,?,?,?,?)";
			ps=con.prepareStatement(SQL);
			ps.setInt(1, mycid);
			ps.setString(2, mycname);
			ps.setString(3, myemail);
			ps.setInt(4, myphone);
			ps.setString(5, mycity);

			int x=ps.executeUpdate();
			if(x==1) {
				System.out.println("Customer Record is Inserted Succesfully");
			}else {
				System.out.println("Sorry, Customer Record is not Inserted");
			}
		}catch(Exception ex) {
		ex.printStackTrace();
		}finally {
			JdbcUtil.cleanup(ps, con);
		}
	}

}
