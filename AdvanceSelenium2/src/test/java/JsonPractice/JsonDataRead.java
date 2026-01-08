package JsonPractice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonDataRead 
{
@Test
public void getDataFromJson() throws FileNotFoundException, IOException, ParseException
{
	JSONParser p=new JSONParser();
	Object object = p.parse(new FileReader("C:\\Users\\afzau\\OneDrive\\Desktop\\Important\\jsonData.json"));
	JSONObject map=(JSONObject)object;
	System.out.println(map.get("browser"));
	System.out.println("one line added");
}
}
