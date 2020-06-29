package MyCodes;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Bikewala {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--Start-maximized");
		System.setProperty("webdriver.chrome.driver" ,"./drivers/chromedriver_ver83.exe");
		ChromeDriver driver = new ChromeDriver(options);
		
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String,Integer> bikeMap = new LinkedHashMap<String,Integer>();
//	    1. Go to https://www.bikewale.com/
		driver.get("https://www.bikewale.com/");

//			2. Go to menu and click new bikes
		driver.findElementByXPath(" //span[@class='navbarBtn nav-icon']").click();
		driver.findElementByXPath("//span[text()='New Bikes']").click();
		
//			3.click compare bikes
		driver.findElementByLinkText("Compare Bikes").click();
//			4. Add first bike as Royal Enfield and model as Thunderbird 350"
		driver.findElementByXPath("(//span[@class='add-icon'])[1]").click();
		
		Actions builder = new Actions(driver);
		
		WebElement webBrand = driver.findElementByXPath("//select[@data-title='Select brand']/following-sibling::div");
		builder.moveToElement(webBrand).click(webBrand).sendKeys("Royal Enfield",Keys.ENTER).perform();
	
		WebElement webModel = driver.findElementByXPath("//select[@data-title='Select model']/following-sibling::div");
		builder.moveToElement(webModel).click(webModel).sendKeys("Thunderbird 350",Keys.ENTER).perform();
		
//			5. Add second bike Jawa, model as 42 and version Dual Channel ABS - BS VI
		driver.findElementByXPath("(//span[@class='add-icon'])[2]").click();
		
		WebElement webBrand2 = driver.findElementByXPath("(//select[@data-title='Select brand']/following-sibling::div)[2]");
		builder.moveToElement(webBrand2).click(webBrand2).sendKeys("Jawa",Keys.ENTER).perform();
		
		WebElement webModel2 = driver.findElementByXPath("(//select[@data-title='Select model']/following-sibling::div)[2]");
		builder.moveToElement(webModel2).click(webModel2).sendKeys("42",Keys.ENTER).perform();
	
		WebElement webVersion2 = driver.findElementByXPath("(//select[@data-title='Select version']/following-sibling::div)[2]");
		builder.moveToElement(webVersion2).click().sendKeys("Dual Channel ABS - BS VI",Keys.ENTER).perform();
		
		
		
//			6. Add bike brand Kawasaki model as Ninja 300
		driver.findElementByXPath("(//span[@class='add-icon'])[3]").click();
		
		WebElement webBrand3 = driver.findElementByXPath("(//select[@data-title='Select brand']/following-sibling::div)[3]");
		builder.moveToElement(webBrand3).click().sendKeys("Kawasaki",Keys.ENTER).perform();
		
		
		WebElement webModel3 = driver.findElementByXPath("(//select[@data-title='Select model']/following-sibling::div)[3]");
		builder.moveToElement(webModel3).click().sendKeys("Ninja 300",Keys.ENTER).perform();
	
//			7. click compare
		driver.findElementById("btnCompare").click();
//			8. Find and print the maximum overall rating of all the bikes and find the max
		driver.findElementByXPath("(//li[text()='Reviews'])[2]").click();
	    List<WebElement> ratingsList = driver.findElementsByXPath("//div[@class='rating-block']//span[contains(text(),'ratings')]");
	    for (int i = 0; i < ratingsList.size(); i++) {
	    	 String text = ratingsList.get(i).getText();
	    	 String onlyNumbers = text.replaceAll("\\D", "");
	    	 int rating = Integer.parseInt(onlyNumbers);
	    	 System.out.println(rating);
	    	 String bikeName = driver.findElementByXPath("//li[@class='list-item ' and @data-value='" +(i)+ "']//p").getText();
		     System.out.println("bikeName:" + bikeName);
		     bikeMap.put(bikeName,rating);
		}
	    System.out.println(bikeMap);
	    

	    
	   
	   
		
	} 
	
/*	public LinkedHashMap<String,Integer> sortMapByValue(LinkedHashMap<String,Integer> listToMap){
		
		//return 
	}
 */
}
