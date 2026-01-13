package jdbcExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDataBase 
{
public static void main(String[] args) throws SQLException 
{
	Connection con=null;
	try {
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
	Statement stat = con.createStatement();
	ResultSet result = stat.executeQuery("select * from emp1;");
	while(result.next())
	{
		System.out.println(result.getString(2));
	}
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	finally {
		con.close();
	}
}
}
