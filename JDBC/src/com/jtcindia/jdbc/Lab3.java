package com.jtcindia.jdbc;
import java.sql.Connection;
import java.sql.Statement;

import com.jtcindia.jdbcUtil.JdbcUtil;
public class Lab3 {
	public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	try {
		con=JdbcUtil.getMySQLConnection();
		//Step 3: Prepare SQL Statement
		String SQL="insert into mycustomers values(107,'hello','hello@jtc',12345,'Noida')";
		//Step 4: Create the JDBC Statement
		st=con.createStatement();
		//Step 5: Submit SQL to DB
		int x=st.executeUpdate(SQL);
		//Step 6: Process Results
		if(x==1) {
			System.out.println("Customer Record is Inserted Succesfully");
		}else {
			System.out.println("Sorry, Customer Record is Not Inserted");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JdbcUtil.cleanup(st, con);
	}
	}

}
