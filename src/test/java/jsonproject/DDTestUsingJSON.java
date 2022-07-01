package jsonproject;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
import javax.json.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDTestUsingJSON {

		
		WebDriver driver;

	@BeforeClass

	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MICROSECONDS);
	}
	
	@AfterClass
	void teardown()
	{
		driver.close();
	}
	@Test(dataProvider="dp")

	void login() 
		{
			
		}
		
		
		@DataProvider(name="dp")
		public String[] readJson() throws IOExceptions,ParseException
		{
			JSONParser jsonParser = new JSONParser();
			FileReader reader=new FileReader(".\\jsonfiles\\RCB.json");
			
			Object obj=jsonParser.parse(reader);
			JSONObject userloginJsonobj=(JSONObject) obj;
			JSONArray playerloginArray=(JSONArray) userloginJsonobj.get("player");
			
			String arr[]=new String[playerloginArray.size()];
			
			for(int i=0;i<playerloginArray.size();i++)
			{
			
			   JsonObject users=(JsonObject) playerloginArray.get(i);
			   
			   String Name=(String) users.get("name");
			   String Country=(String) users.get("country");
			   String Role=(String) users.get("role");
			   String Price-in-crores=(String) users.get("price-in-crores");
			   
			   arr[i]=Name+","+Country+","+Role+","+Price-in-crores;
			
			  
			}
			return arr;
		
	}
	
}



	
	
	
	




