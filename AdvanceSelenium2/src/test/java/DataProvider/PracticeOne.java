package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeOne 
{
@Test(dataProvider = "getData")
public void m1Test(String data,String b)
{
	System.out.println(data);
	System.out.println(b);
}
@DataProvider
public Object[][] getData()
{
	Object[][] str= new Object[4][2];
	for(int i=0;i<4;i++)
	{
		str[i][0]="hello"+i;
		str[i][1]="byee"+i;
	}

	System.out.println("=================");
	return str;
}
}
