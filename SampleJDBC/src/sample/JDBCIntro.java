package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCIntro {

	public static void main(String[] args)throws ClassNotFoundException  {
		String dbURL="jdbc:mysql://localhost:3306/loginout";
		String USER="root";
		String PASS="Vinay@123";
		Connection con=null;
		try{
			String username="jdlias";
			String password="Hello";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbURL,USER,PASS);
			String query1="insert into login values(?,?);";
			PreparedStatement pt=con.prepareStatement(query1);
		    pt.setString(1,username);
		    pt.setString(2,password);
		    pt.execute();
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
