import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class PrepStatement {

	public static void main(String[] args) throws ClassNotFoundException{
		String dbURL="jdbc:mysql://localhost:3306/vinay";
		String USER="root";
		String PASS="root";
		Connection con=null;
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbURL,USER,PASS);
			con.setAutoCommit(false);
			String query1="insert into student values(?,?,?,?);";
			String query2="Select * from student;";
			PreparedStatement pt=con.prepareStatement(query1);
		    pt.setInt(1, 7892);
		    pt.setString(2,"Hello World");
		    pt.setInt(3,89);
		    pt.setString(4,"Mangalore");
		    pt.executeUpdate();
		    pt.execute(query2);
		    ResultSet rs=pt.executeQuery(query2);
		    
		      while(rs.next())
		    {
		    	System.out.println(rs.getInt("usn")+" "+rs.getString(2));	
		    	
		    }
		      
		    Savepoint spt1 = con.setSavepoint();
		    pt.setInt(1, 782);
		    pt.setString(2,"Marsh World");
		    pt.setInt(3,8);
		    pt.setString(4,"Cangalore");
		    pt.executeUpdate();
		    rs=pt.executeQuery(query2);
		    
		      while(rs.next())
		    {
		    	System.out.println(rs.getInt("usn")+" "+rs.getString(2));	
		    	
		    }
		    con.rollback(spt1);
		      con.commit();
		     
		      
		      
		}
		catch(SQLException e){
			System.out.println("Could not connect to the database"+e.getMessage());
			e.printStackTrace();
		}	


	}

}
