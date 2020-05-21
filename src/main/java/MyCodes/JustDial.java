package MyCodes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

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

public class JustDial {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		float ratingValue = 0;
		String webCenterName = null;
		int[] decodedPhoneDigit = new int[10];
		String subStringPhone;
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_ver81.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);
		
		driver = new ChromeDriver(options);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		driver.get("https://www.justdial.com/Chennai/Car-Repair-Services-Hyundai-Xcent/nct-11293522");
		Thread.sleep(5000);
		
		driver.findElementByXPath("//section[@id='best_deal_div']//span[1]").click();
		Thread.sleep(2000);
		
		List<WebElement> webRatings = driver.findElements(By.xpath("//span[@class='green-box']"));
		List<WebElement> webListofStoreName = driver.findElements(By.xpath("//span[@class='lng_cont_name']"));
	//	List<WebElement> webListVotes = driver.findElements(By.xpath(("//span[@class='green-box'])[1]/preceding::span[@class='rt_count lng_vote']"));
		Map<String,Float> mapStoreRating=new LinkedHashMap<String,Float>();
		Map<String,Integer> mapStoreVotes=new LinkedHashMap<String,Integer>();
		
		for (int i = 0; i < webRatings.size(); i++) {
			
		//Get the ratings
			String ratingNoString= webRatings.get(i).getText();
			ratingValue = Float.parseFloat(ratingNoString);
			
		//	System.out.println("WebRatings["+i+"]:"+ratingValue);
			webCenterName = webListofStoreName.get(i).getText();
			if(ratingValue>=4.5) {
			String webVotes =  driver.findElementByXPath("(//span[@class='green-box'])["+(i+1)+"]/following-sibling::span[contains(text(),'Votes')]").getText();
			//String webVotes = webListVotes.get(i).getText();
			String trimmedVotes = webVotes.trim();
			int VoteValue = Integer.parseInt(trimmedVotes.replaceAll("\\D", ""));
			
			System.out.println("webVotes:" +VoteValue);
			
		//	System.out.println(" element["+i+"]:" +webCenterName);
			mapStoreRating.put(webCenterName, ratingValue);
			mapStoreVotes.put(webCenterName, VoteValue);
			
		}
		System.out.println("*** Web Center--Rating List ***");
		System.out.println(mapStoreRating.entrySet());
		System.out.println(mapStoreVotes.entrySet());
		
	    JustDial obj = new JustDial();
	    obj.getEncodedPhoneNumber(webListofStoreName.size());
		}
	}		

	public Character decodePhoneNumber(String encodedPhoneString) {
		Character decodedPhoneDigit=null;
		Map<String,Character> mapPhone=new LinkedHashMap<String,Character>();	
		mapPhone.put("acb",'0');
		mapPhone.put("yz",'1');
		mapPhone.put("wx",'2');
		mapPhone.put("vu",'3');
		mapPhone.put("ts",'4');
		mapPhone.put("rq",'5');
		mapPhone.put("po",'6');
		mapPhone.put("nm",'7');
		mapPhone.put("lk",'8');
		mapPhone.put("ji",'9');
		mapPhone.put("dc",'+');
		mapPhone.put("fe",'(');
		mapPhone.put("hg",')');
		mapPhone.put("ba",'-');
		
		if(mapPhone.containsKey(encodedPhoneString)) {
			decodedPhoneDigit = mapPhone.get(encodedPhoneString);
		}
		return decodedPhoneDigit;
	}
	
public void getEncodedPhoneNumber(int noOfStores) {
		
		String encodedString = null;
		char[] concatenatedChar = new char[16];
		String decodedString = null;
		System.out.println("noOfStores: "+noOfStores);
		
		for (int j = 0; j < noOfStores; j++) {
			for (int i = 1; i <= 16; i++) {
				String[] attribute = new String[i];

		// Gives the full class attribute
					attribute[i-1] = driver.findElementByXPath("//*[@id='bcard"+j+"']/div[1]//p[2]/span/a//span["+i+"]").getAttribute("class");
		// get all the encoded values(last 2 characters) of all the 16  digits.
				String[] splitString = attribute[i - 1].split("-");
				encodedString = splitString[1];

				JustDial obj = new JustDial();
				char decodedPhoneDigit = obj.decodePhoneNumber(encodedString);
		// Store the digits in a char array
				concatenatedChar[i - 1] = decodedPhoneDigit;
			}
			String valueOfPhone = String.valueOf(concatenatedChar);
	        System.out.println("valueOfPhone: "+ valueOfPhone);
		}
	}
	
	
}
