package com.jtcindia.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jtcindia.jdbcUtil.JdbcUtil;

public class Test3day5 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
		con=JdbcUtil.getMySQLConnection();
		st=con.createStatement();
		String s1="Select * from mycustomers";
		String s2="insert into mycustomers values(110,'Manbhai','Man@man',211008,'prayagraj')";
		String s3="delete from mycustomers where cid=";
		/*boolean bn=st.execute(s1);
		if(bn) {
			System.out.println("Record Inserted...");
		}else {
			System.out.println("try Again...");
		}*/

		//rs=st.getResultSet();
		int i=st.executeUpdate(s2);  //day6 jdbc
		System.out.println(i);

		/*
		while(rs.next()) {
			int cid=rs.getInt(1);
			String cname=rs.getString(2);
			String email=rs.getString(3);
			long ph=rs.getLong(4);
			String city=rs.getString(5);
			System.out.println("Cid\t"+cid+" name\t"+cname+"email\t"+email+"ph\t"+ph+"City\t"+city);
		}*/
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
