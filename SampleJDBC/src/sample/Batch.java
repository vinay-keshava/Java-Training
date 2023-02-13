package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch {

	public static void main(String[] args)throws ClassNotFoundException  {
		String dbURL="jdbc:mysql://localhost:3306/loginout";
		String USER="root";
		String PASS="Vinay@123";
		Connection con=null;
		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbURL,USER,PASS);
			con.setAutoCommit(false);
			Statement st=con.createStatement();
			String SQL="insert into login values('vinaykeshava','vinaykeshava')";
			st.addBatch(SQL);
			String SQL1="insert into login values('mahesh','mahesh')";
			st.addBatch(SQL1);
			int count[]=st.executeBatch();
			System.out.println(count);
			con.commit();
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

