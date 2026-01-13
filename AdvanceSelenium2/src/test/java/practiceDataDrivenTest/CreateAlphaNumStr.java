package practiceDataDrivenTest;

public class CreateAlphaNumStr 
{
public static void main(String[] args) 
{
	int n=15;
	String alphaNumStr="ABCDE1234";
	StringBuilder sb=new StringBuilder(n);
	for(int i=0;i<n;i++)
	{
		int index = (int)(alphaNumStr.length()*Math.random());
		sb.append(alphaNumStr.charAt(index));
	}
	System.out.println(sb);
}
}
