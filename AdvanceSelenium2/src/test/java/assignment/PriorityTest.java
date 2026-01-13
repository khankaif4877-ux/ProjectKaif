package assignment;

import org.testng.annotations.Test;

public class PriorityTest 
{
@Test(priority = 1)
public void tes1()
{
	System.out.println("1");
}
@Test(priority = 0)
public void tes2()
{
	System.out.println("2");
}
@Test(priority = 2)
public void tes3()
{
	System.out.println("3");
}
@Test(priority = 3)
public void tes4()
{
	System.out.println("4");
}
}
