package MyCodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day12_CarWale {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//1) Go to https://www.carwale.com/
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_ver83.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);
		
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		Actions builder = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.get("https://www.carwale.com/");
//2) Click on Used 
		driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
		
//3) Select the City as Chennai 
		WebElement webUsedCar = driver.findElementById("usedCarsList");
		webUsedCar.click();
		webUsedCar.sendKeys("Chennai");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']")));
		driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
		//webUsedCar.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
//4) Select budget min (8L) and max(12L) and Click Search 
		WebElement webMin = driver.findElementByXPath("//ul[@id='minPriceList']/li[text()='8 Lakh']");
		js.executeScript("arguments[0].click()", webMin);
		Thread.sleep(2000);
		driver.findElementByXPath("//ul[@id='maxPriceList']/li[text()='12 Lakh']").click();
		Thread.sleep(2000);
		driver.findElementById("btnFindCar").click(); // search
		Thread.sleep(5000);
		
		/*wait.until(ExpectedConditions.visibilityOf(driver.findElementById("closeLocIcon")));
		driver.findElementById("closeLocIcon").click();
		Thread.sleep(2000);*/
		
		driver.findElementByLinkText("Don't show anymore tips").click();
//5) Select Cars with Photos under Only Show Cars With 
       WebElement webCarsWithPhotos = driver.findElementByXPath("//li[@name='CarsWithPhotos']");
       js.executeScript("arguments[0].click()", webCarsWithPhotos);
       Thread.sleep(2000);
		
//6) Select Manufacturer as "Hyundai" --> Creta 
      WebElement webHyundai = driver.findElementByXPath("//li[@data-manufacture-en='Hyundai']/span");
      js.executeScript("arguments[0].click()", webHyundai);
     // wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Creta']")));
      WebElement webCreta = driver.findElementByXPath("//span[text()='Creta']");
      js.executeScript("arguments[0].click()", webCreta);

//7) Select Fuel Type as Petrol 
      
      WebElement webFuel = driver.findElementByXPath("//div[@name='fuel']/h3");
   //  js.executeScript("arguments[0].scrollIntoView();", webFuel);
      js.executeScript("arguments[0].click()", webFuel);
      
      WebElement webPetrol = driver.findElementByXPath("(//span[text()='Petrol'])[1]");
      js.executeScript("arguments[0].click()",webPetrol);
      System.out.println("1");
	 
//8) Select Best Match as "KM: Low to High" 
      WebElement webSort = driver.findElementByXPath("//select[@id='sort']");
      Select drp = new Select(webSort);
      drp.selectByValue("2");
      
//9) Validate the Cars are listed with KMs Low to High 
      List<WebElement> webKM_List = driver.findElementsByXPath("//span[@class='slkms vehicle-data__item']");
      for (int i = 0; i < webKM_List.size(); i++) {
    	  String KmofCar = webKM_List.get(i).getText();
    	//  System.out.println("KmofCar"+KmofCar);
    	  
    	  String value=KmofCar.replaceAll("\\D","");
    	//  System.out.println(value);
    	  
    	  int KmofCar_int = Integer.parseInt(value);
    	  System.out.println("Km of the Cars:"+KmofCar_int);
	}
//10) Add the least KM ran car to Wishlist 
      driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])[1]").click();
      
//11) Go to Wishlist and Click on More Details 
      driver.findElementByXPath("//li[@data-action='ShortList&CompareWindow_Click']/span").click();
      driver.findElementByLinkText("More details »").click();
      
//12) Print all the details under Overview in the same way as displayed 
      Set<String> winSet = driver.getWindowHandles();
      List<String> winList = new ArrayList<String>(winSet);
      driver.switchTo().window(winList.get(1));
      System.out.println(winList.get(1));
      List<WebElement> overviewDetails = driver.findElementsByXPath("//div[@class='overview-list padding-bottom10']//div");
      for (WebElement webElement : overviewDetails) {
    	  System.out.print(webElement.getText()+ "\t");
    	  System.out.println("\n");
	  }
      
//13) Close the browser.
      driver.close();
	}
}
