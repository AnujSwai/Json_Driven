package jsonproject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.json.JsonObject;
import javax.json.JsonValue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.Json;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDTestUsingJSON {

		

	@Test(dataProvider="dp")

	void Operation(String data) 
		{
		System.out.print(data);
		String player[]=data.split(",");
			
			
			
			
		}
		
		
		@DataProvider(name="dp")
		public String[] readJson() throws IOException, ParseException
		{
			JSONParser jsonParser = new JSONParser();
			FileReader reader=new FileReader("./jsonfiles//RCB.json");    
		    Object obj=jsonParser.parse(reader);
		    
		    
			JSONObject PlayerObject=(JSONObject) obj;
			  System.out.print("PlayerObject");
			JSONArray playerloginArray=(JSONArray).get("player");
			
			String arr[]=new String[playerloginArray.size()];
			
			for(int i=0;i<playerloginArray.size();i++)
			{
			
			   JsonObject users=(JsonObject) playerloginArray.get(i);
			   
			   JsonValue Name=users.get("name");
			   JsonValue Country=users.get("country");
			   JsonValue Role=users.get("role");
			   JsonValue Price=users.get("price-in-crores");
			   
			   arr[i]=Name+","+Country+","+Role+","+Price;
			    System.out.print("NAME");
			  
			  
			}
			return arr;
		
	}
	
}



	
	
	
	




