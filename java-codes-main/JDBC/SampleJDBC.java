package com.work.jdbc.hcl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCIntro {

	public static void main(String[] args) throws ClassNotFoundException {
			String dbURL="jdbc:mysql://localhost:3306/world";
			String USER="root";
			String PASS="root";
			Connection con=null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(dbURL,USER,PASS);
				if(con!=null)
				{
					System.out.println("The connection to the database has been done successfully");
				}
			}
			catch(SQLException e){
				System.out.println("Could not connect to the database"+e.getMessage());
				e.printStackTrace();
			}	

	}

}
