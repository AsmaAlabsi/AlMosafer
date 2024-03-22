package HotelSearchTest;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {
	
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.almosafer.com/en";
	Random rand = new Random();
	String [] ArabicCities = {"جدة","دبي"};
	String [] EnglichCities = {"dubai","jeddah","riyadh"};
int RandomArabicCity = rand.nextInt(ArabicCities.length);
int RandomEnglichCity = rand.nextInt(EnglichCities.length);
int visitorNumber = rand.nextInt(2);
Assertion myassert = new Assertion();


}
