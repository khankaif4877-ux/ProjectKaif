package practice;

public class ConstructorTesting 
{
	String name;
	int age;
	int a;
	int b;
	public ConstructorTesting(String name,int age,int a,int b)
	{
		this(age, a, b);
		this.name=name;
	}
	public ConstructorTesting(int age,int a,int b)
	{
		this.age=age;
		this.a=a;
		this.b=b;
	}
public static void main(String[] args) 
{
	ConstructorTesting c1=new ConstructorTesting("abc", 20, 10, 50);
	System.out.println(c1.a);
}
}
