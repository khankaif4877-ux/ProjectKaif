package jdbcExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class GetDataFromMySqlWB 
{
public static void main(String[] args) throws SQLException 
{
	Connection con=null;
	try 
	{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
	Statement stat = con.createStatement();
	 ResultSet result = stat.executeQuery("select * from project;");
	 while(result.next())
	 {
		String data= result.getString(4);
		System.out.println(data);
		if(data.equals("insta1439"));
		{
			for(int i=1;i<=6;i++)
			{
				System.out.print(result.getString(i)+" ");
			}
			System.out.println();
		}
	 }
	}
	catch (Exception e) {
		System.out.println("handled");
	}
	finally {
		con.close();
		System.out.println("connection closed.");
	}
	System.out.println("done");
}
}
