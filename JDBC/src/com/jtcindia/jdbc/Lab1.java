package com.jtcindia.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Lab1 {
		public static void main(String[] args) {
			Connection con=null;
			Statement st=null;
			try {
			//Step 1:Load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Step 2:Open the Connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbcdb","root","Mangesh@12");

			//Step 3:Prepare SQL Statement
			String SQL="insert into mycustomers values(101,'Mangesh','ds@man',12345,'Naini')";

			//Step 4:Create the JDBC Statement
			st=con.createStatement();

			//Step 5:Submit SQl to DB
			int x=st.executeUpdate(SQL);

			//Step 6:Process Results
			if(x==1) {
				System.out.println("Customer Record is Inserted Succesfully");
			}else {
				System.out.println("Sorry, Customer Record is Not Inserted");
			}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			finally {
				//Step 7: Close all the Resources.
				try {
					if(st!=null)
						st.close();
					if(con!=null)
						con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}