package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfigJDBC {
	public static void main(String[] args) throws ClassNotFoundException {
		
		try {
			
			Statement st = con.createStatement();

			String query2 = "insert into student values(10,'Mahesh',11,'Goa')";
			st.execute(query2);

			String query1 = "Select * from student;";
			ResultSet rs = st.executeQuery(query1);
			while (rs.next()) {
				System.out.println(rs.getInt("usn") + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("Could not connect to the database" + e.getMessage());
			e.printStackTrace();
		}

	}
}
