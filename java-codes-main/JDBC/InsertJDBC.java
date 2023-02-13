import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.ResultSet;
public class DemoRollbackCommit {

	public static void main(String[] args) throws ClassNotFoundException {
		String dbURL="jdbc:mysql://localhost:3306/vinay";
		String USER="root";
		String PASS="root";
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbURL,USER,PASS);
			Statement st=con.createStatement();

		    String query2="insert into student values(10,'Mahesh',11,'Goa')";
		    st.execute(query2);

		    String query1="Select * from student;";
		    ResultSet rs=st.executeQuery(query1);
		      while(rs.next())
		    {
		    	System.out.println(rs.getInt("usn")+" "+rs.getString(2));	
		    }
		}
		catch(SQLException e){
			System.out.println("Could not connect to the database"+e.getMessage());
			e.printStackTrace();
		}	

}


}
