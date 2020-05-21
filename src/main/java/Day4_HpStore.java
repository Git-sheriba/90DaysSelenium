import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class Day4_HpStore {

	public static void main(String[] args) throws InterruptedException {
	ChromeOptions options = new ChromeOptions();
	System.setProperty("webdriver.chrome.silentOutput", "true");
	
	options.addArguments("--disable-notifications");
    System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_ver81.exe");	
    
    DesiredCapabilities dc = new DesiredCapabilities();
    dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
    
    options.merge(dc);
    
    ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    
	//1) Go to https://store.hp.com/in-en/
    driver.get("https://store.hp.com/in-en/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    // close the cookies message that apperas at the bottom of the screen.
        driver.findElementByXPath("//div[@class='optanon-alert-box-corner-close']/button").click();
    
	// check if sign up window occurs andclose it.
				//    if(driver.findElementByXPath("//span[@class='optly-modal-close close-icon']").isDisplayed()) {
				//	//webPopup.click();
				//	 System.out.println("Sign Up appeared");
				//	 driver.findElementByXPath("//span[@class='optly-modal-close close-icon']").click();
				//	}
				    
    //try catch block for sign-up window
		/*    try {
		    	Thread.sleep(500);
		    	 wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[@class='optly-modal-close close-icon']")));
		    	 driver.findElementByXPath("//span[@class='optly-modal-close close-icon']").click();
		    	 System.out.println("Sign Up appeared");
		    	 	//2) Mouse over on Laptops menu and click on Pavilion
		         WebElement webLaptop = driver.findElementByXPath("//span[text()='Laptops']");  
		         Actions builder = new Actions(driver);
		         builder.moveToElement(webLaptop).perform();
		    }
		    catch (NoSuchElementException e) {
		    	e.printStackTrace();
		    	System.out.println("Handled when Sign up window is not found");
		     		//2) Mouse over on Laptops menu and click on Pavilion
		    	Thread.sleep(500);
		        WebElement webLaptop = driver.findElementByXPath("//span[text()='Laptops']");  
		        Actions builder = new Actions(driver);
		        builder.moveToElement(webLaptop).perform();
        
    }*/
         
    
  //2) Mouse over on Laptops menu and click on Pavilion
//	Thread.sleep(500);
    WebElement webLaptop = driver.findElementByXPath("//span[text()='Laptops']");  
    Actions builder = new Actions(driver);
    builder.moveToElement(webLaptop).perform();
    
	//3) Under SHOPPING OPTIONS -->Processor -->Select Intel Core i7
     driver.findElementByXPath("//span[text()='Pavilion']").click();
     WebElement webProcessor = 
    		 driver.findElementByXPath("(//span[text()='Processor'])[2]");
     wait.until(ExpectedConditions.elementToBeClickable(webProcessor));
     webProcessor.click();
     System.out.println("Processor clicked");
     
   //  driver.findElement(By.xpath("//body")).click();
  //   System.out.println("simple click()");
     
     WebElement webIntel = driver.findElementByXPath("//span[text()='Intel Core i7']");
     wait.until(ExpectedConditions.elementToBeClickable(webProcessor));
     webIntel.click();
     System.out.println("Intel Core i7 clicked");
     
	//4) Hard Drive Capacity -->More than 1TB
    driver.findElementByXPath("//span[text()='More than 1 TB']").click();
	//5) Select Sort By: Price: Low to High
    WebElement webSortByPrice = driver.findElementByXPath("//select[@id='sorter']");
    Select sort = new Select(webSortByPrice);
    sort.deselectByVisibleText("Price : Low to High");
    
	//6) Print the First resulting Product Name and Price
    String productName = driver.findElementByLinkText("HP Pavilion - 15-cs3008tx").getText();
    String price = driver.findElementByXPath("(//div[@class='price-box price-final_price'])[1]").getText();
    System.out.println("price : " + price);
    
	//7) Click on Add to Cart
    driver.findElementByXPath("(//button[@title='Add To Cart'])[1]").click();
    
	//8) Click on Shopping Cart icon --> Click on View and Edit Cart
    driver.findElementByLinkText("My Cart").click();
  //  driver.findElementByXPath("//a[@title='Shopping Cart']").click();
    driver.findElementByXPath("//span[text()='View and edit cart']").click();
 //   driver.findElementByXPath("//a[@class='action primary viewcart']").click();
    
	//9) Check the Shipping Option --> Check availability at Pincode
        driver.findElementByXPath("//input[@name='pincode']").sendKeys("600091",Keys.ENTER);
        
	//10) Verify the order Total against the product price
    String totalPrice = driver.findElementByXPath("(//td[@class='amount'])[3]//span").getText();
    int priceValue = Integer.parseInt(price);
    int totalPriceValue = Integer.parseInt(totalPrice);
    System.out.println("priceValue"+priceValue);
    System.out.println("totalPriceValue"+totalPriceValue);
    
    if(priceValue==totalPriceValue)
    	System.out.println("PriceValue is same as Total Price value");
    
	//11) Proceed to Checkout if Order Total and Product Price matches
     
    
	//12) Click on Place Order
    
    
	//13) Capture the Error message and Print
    
    
	//14) Close Browser

       
    }

}
