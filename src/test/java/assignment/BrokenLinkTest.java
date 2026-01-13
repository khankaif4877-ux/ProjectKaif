package assignment;


public class BrokenLinkTest 
{
public static void main(String[] args) 
{
	String s="abcdccbba";
	for(int i=0;i<s.length();i++)
	{
		if((i==0 && s.charAt(i+1)!=s.charAt(i)) || (i==s.length()-1 && s.charAt(i-1)!=s.charAt(i)))
		{
			System.out.print(s.charAt(i));
		}
		else if(s.charAt(i)!=s.charAt(i+1) && s.charAt(i)!=s.charAt(i-1))
		{
			System.out.print(s.charAt(i));
		}
	}
}
}
