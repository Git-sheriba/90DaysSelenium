package MyCodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day7_Honda {

	public static void main(String[] args) {
//1) Go to https://www.honda2wheelersindia.com/
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_ver81.exe");
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.get("https://www.honda2wheelersindia.com/");
//2) Click on scooters and click dio
		
		
//3) Click on Specifications and mouseover on ENGINE
//4) Get Displacement value
//5) Go to Scooters and click Activa 125
//6) Click on Specifications and mouseover on ENGINE
//7) Get Displacement value
//8) Compare Displacement of Dio and Activa 125 and print the Scooter name having better Displacement.
//9) Click FAQ from Menu 
//10) Click Activa 125 BS-VI under Browse By Product
//11) Click  Vehicle Price 
//12) Make sure Activa 125 BS-VI selected and click submit
//13) click the price link
//14)  Go to the new Window and select the state as Tamil Nadu and  city as Chennai
//15) Click Search
//16) Print all the 3 models and their prices
//17) Close the Browser

	}

}
