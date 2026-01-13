package jdbcExecution;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class GetDataFromTable_emp1 
{
public static void main(String[] args) throws SQLException 
{
	Connection con=null;
	String expectedCondition="allen2";
	try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery("select * from emp1;");
		while(result.next())
			{
			String actData=result.getString(2);
			if(expectedCondition.equals(actData))
				{
				System.out.println(expectedCondition+" is matched");
				}
			}
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	finally 
	{
	con.close();
	System.out.println("closed");
	}
}
}
