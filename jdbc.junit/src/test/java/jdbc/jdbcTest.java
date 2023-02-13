package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;		

class jdbcTest {

	@BeforeClass
	public void TestConnnection() throws ClassNotFoundException, SQLException {
		String dbURL="jdbc:mysql://localhost:3306/phase2javafullstack";
		String USER="root";
		String PASS="Vinay@123";
		Connection con=null;
		
			con=DriverManager.getConnection(dbURL,USER,PASS);
			if(con!=null)
			{
				System.out.println("The connection to the database has been done successfully this is test");
			}
		
			else{
			System.out.println("Could not connect to the database");
		}	
		
	}
	

}
