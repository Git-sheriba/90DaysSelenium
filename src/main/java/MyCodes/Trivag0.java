package MyCodes;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Trivag0 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--Start-maximized");
    //    options.addArguments("--disable-popup-blocking");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		//cap.setCapability();
		options.merge(cap);

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_ver83.exe");
		ChromeDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// 1) Go to https://www.trivago.com/
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.trivago.com/");
		// 2) Type Agra in Destination and select Agra, Uttar Pradesh. 
		driver.findElementById("querytext").click();
		Thread.sleep(2000);
		driver.findElementById("querytext").sendKeys("Agra");
		Thread.sleep(2000);
		driver.findElementById("querytext").sendKeys(Keys.ENTER);
		
        //3) Choose May 15 as check in and June 30 as check out 
	    //	driver.findElementByXPath("//button[@id='onetrust-accept-btn-handler']").click();
	 	Thread.sleep(2000);
		WebElement checkIn = driver.findElementByXPath("//span[text()='Check in']");
		checkIn.click();
		Thread.sleep(5000);
		checkIn.click();
		WebElement startDate = driver.findElementByXPath("(//time[@datetime='2020-06-27'])");
		System.out.println("2");
		js.executeScript("arguments[0].click()", startDate);
		System.out.println("date Click ");
		WebElement endDate = driver.findElementByXPath("(//time[@datetime='2020-06-30'])");
		js.executeScript("arguments[0].click()", endDate);
		System.out.println("1");
		// 4) Select Room as Family Room 
	//	driver.findElementByXPath("//span[text()='Room']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//button[@class='roomtype-btn'])[3]").click();

		// 5) Choose Number of Adults 2, Childern 1 and set Child's Age as 4 
		WebElement adult = driver.findElementByXPath("(//select[@class='df-select'])[1]");
		Select  drp = new Select(adult);
		drp.selectByValue("2"); 
		
		WebElement children = driver.findElementByXPath("(//select[@class='df-select'])[2]");
		Select drp1 = new Select(children);
		drp1.selectByValue("1");
		Thread.sleep(2000);
		WebElement childAge = driver.findElementByXPath("//select[@class='df-select js-select-child-age']");
		Select drp2 = new Select(childAge);
		drp2.selectByValue("2");
		
/*		WebElement webAdult = driver.findElementById("adults-input");
		webAdult.clear();
		webAdult.sendKeys("2");
		
		WebElement webChildren = driver.findElementById("children-input");
		webChildren.click();
		webChildren.sendKeys("1");*/
		
		// 6) Click Confirm button and click Search 
		driver.findElementByXPath("//span[text()='Confirm']").click();
		driver.findElementByXPath("//button[@data-qa='search-button']").click();
		
		// 7) Select Accommodation type as Hotels only and choose 4 stars 
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//li[@data-qa='stars-filter']")).perform();
		driver.findElementByXPath("(//input[@type='radio'])[2]").click();
		driver.findElementByXPath("//button[@title='4-star hotels']").click();
		driver.findElementByXPath("//button[@id='filter-popover-done-button']").click();
		// 8) Select Guest rating as Very Good 
		builder.moveToElement(driver.findElementByXPath("//li[@data-qa='rating-filter']")).perform();
		driver.findElementByXPath("(//li[@class='range__item'])[2]/button").click();
		// 9) Set Hotel Location as Agra Fort and click Done 
		builder.moveToElement(driver.findElementByXPath("//li[@data-qa='location-filter']")).perform();
		WebElement location = driver.findElementByXPath("//select[@id='pois']");
		Select drp3 = new Select(location);
		drp3.selectByVisibleText("Agra Fort");
		driver.findElementById("filter-popover-done-button").click();
		// 10) In more Filters, select Air conditioning, Restaurant and WiFi and click Done 
		builder.moveToElement(driver.findElementByXPath("//li[@data-qa='more-filter']")).perform();
		WebElement airCondition = driver.findElementByXPath("(//li[@data-qa='filters-list-item'])[3]");
		airCondition.click();
		driver.findElementByXPath("(//li[@data-qa='filters-list-item'])[4]").click();  // WiFi
		driver.findElementByXPath("(//li[@data-qa='filters-list-item'])[9]").click();  // Restaurant
		driver.findElementById("filter-popover-done-button").click();
		//done
		
		// 11) Sort the result as Rating & Recommended 
		WebElement sort = driver.findElementByXPath("//select[@data-qa='sorting']");
		Select drp4 = new Select(sort);
		drp4.selectByVisibleText("Price & Recommended");
		
		// 12) Click the hotel 
		driver.findElementByXPath("(//button[@data-qa='champion-deal'])[1]").click();
		
		// 13) Print the Hotel name, Rating, Number of Reviews and Click View Deal 
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		System.out.println(winList.size());
		driver.switchTo().window(winList.get(1));
		
		// 14) Print the URL of the Page 
		System.out.println("URL :"+ driver.getCurrentUrl());
		// 15) Print the Price of the Room and click Choose Your Room 
		
		// 16) Click Reserve and I'll Reserve 
		
		// 17} Close the browser

	}

}
