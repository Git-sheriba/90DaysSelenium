package MyCodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day10_JustDial {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//1) https://www.justdial.com/
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_ver81.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);
		
		ChromeDriver driver = new ChromeDriver(options);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.get("https://www.justdial.com/");
		Thread.sleep(2000);
		
//2) Set the Location as Chennai
		driver.findElementById("city").click();
		driver.findElementById("Chennai").click();
		driver.findElementById("srchbx").click();
//3) Click Auto Care in the left menu
		driver.findElementByXPath("//span[text()='Auto care']").click();
//4) Click Car Repair
		driver.findElementByXPath("//div[@id='mnintrnlbnr']//a").click();
		Thread.sleep(5000);
//5) Click Car Brand as Hyundai
		driver.findElementByXPath("//span[text()='Hyundai']").click();
		Thread.sleep(5000);
//6) Click Make as Hyundai Xcent
		//driver.findElementByXPath("//span[text()='Hyundai Xcent']").click();
		driver.findElementByXPath("(//span[@title='Hyundai Xcent'])[1]").click();
		Thread.sleep(5000);
/*//7) Click on Location and Enter Porur
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("location")));
		driver.findElementById("location").click();
		Thread.sleep(2000);
//8) Select Porur from the dropdown list
		wait.until(ExpectedConditions.visibilityOf((driver.findElementByXPath("//input[@id='location']"))));
		WebElement sortByLocation = driver.findElementByXPath("//input[@id='location']");
		System.out.println("porur ");*/
//9) Select Distance starting from 1 km
//10) Identify all the Service Center having Ratings >=4.5 and Votes >=50
		
	/*	
		for (int i = 1; i <= 10; i++) {
			float[] ratingValue = new float[i];
			int[] votesValue =new int[i];
			String[] ServiceCenterName = new String[i];
			
			String webCenterName = driver.findElementByXPath("//span[@class='lng_cont_name']["+i+"]").getText();
			ServiceCenterName[i-1] = webCenterName;
			
			String webRatings = driver.findElementByXPath("//span[@class='green-box']["+i+"]").getText();
			ratingValue[i-1] = Float.parseFloat(webRatings);
			
			String webVotes = driver.findElementByXPath("(//span[@class='star_m']/following-sibling::span)[2]").getText();
			int VoteValue = Integer.parseInt(webVotes.replaceAll("\\D", ""));
			System.out.println("webVotes:" +VoteValue);
			
			if(ratingValue[i-1]>=4.5 && votesValue[i-1]>=50 ) {
				System.out.println("Service Center["+i+"]");
				System.out.println("Service Center Name : " + ServiceCenterName[i-1] );
				System.out.println("Rating :"+ratingValue[i-1] );
				System.out.println("Vote Value : "+votesValue[i-1]);
			}
			
		}*/
		
		List<WebElement> webRatings = driver.findElements(By.xpath("//span[@class='green-box']"));
		System.out.println(" Size :"+ webRatings.size());
		for (int i = 0; i < webRatings.size(); i++) {
			//Get the ratings
			String ratingNoString= webRatings.get(i).getText();
			float ratingValue = Float.parseFloat(ratingNoString);
			System.out.println("WebRatings["+i+"]:"+ratingValue);
			
//			// Get the Votes
//			String webVotes = driver.findElementByXPath("(//span[@class='star_m']/following-sibling::span)["+ (i*2)+2 +"]").getText();
//			int VoteValue = Integer.parseInt(webVotes.replaceAll("\\D", ""));
//			System.out.println("webVotes:" +VoteValue);
			
			String storeName = driver.findElement(By.xpath("(//span[@class='lng_cont_name'])["+ i+1 +"]")).getText();
			System.out.println("StoreName["+i+"]:"+storeName);
			
			/*// To get the store name only when rating is >=4.5 and votes>=50
			if(ratingValue >=4.5 && VoteValue>=50 ) {
			String storeName = driver.findElement(By.xpath("(//span[@class='lng_cont_name'])["+ i+1 +"]")).getText();
			System.out.println("StoreName["+i+"]:"+storeName);
			}*/
		}
		
		List<WebElement> webListofStoreName = driver.findElements(By.xpath("//span[@class='lng_cont_name']"));
		int noOfStores = webListofStoreName.size();
		for (int i = 0; i < noOfStores; i++) {
			String webCenterName = webListofStoreName.get(i).getText();
			System.out.println(" element["+i+"]:" +webCenterName);
		}
			
		String webVotes = driver.findElementByXPath("(//span[@class='star_m']/following-sibling::span)[2]").getText();
		int VoteValue = Integer.parseInt(webVotes.replaceAll("\\D", ""));
		System.out.println("webVotes:" +VoteValue);
		
		//span[text()= 4.2]/following-sibling::span[2]
		 
		/*WebElement storeName = 
				driver.findElementByXPath("//span[@class='lng_cont_name' and contains(text(),"+webCenterName+")]");
				//driver.findElementByXPath("//span[text()= 4.2]/parent::li/preceding::h2//span[@class='lng_cont_name']");
		System.out.println("storeName:"+ storeName.getText());
		
		//*[contains(@id,'Email')]
		
		//h2//span[@class='lng_cont_name' and contains(text(),"+")]
		*/
		
		try {
		driver.findElementByXPath("//section[@id='best_deal_div']//span[1]").click();
		Thread.sleep(2000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
//11) Save all the Service Center name and Phone number matching the above condition in excel 
	
		
//12) Close the browser;

	}

}
