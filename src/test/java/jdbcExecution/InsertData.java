package jdbcExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertData 
{
public static void main(String[] args) throws SQLException 
{
	Connection con=null;
	try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement stat = con.createStatement();
		String query="insert into emp1 values('emp142','gayle',65434512), ('emp444','stark',765331234);";
		int result = stat.executeUpdate(query);
		System.out.println(result);
		System.out.println("executed");
	}
	catch (Exception e) {
		System.out.println("handled");
	}
	finally {
		con.close();
		System.out.println("connection closed");
	}
}
}