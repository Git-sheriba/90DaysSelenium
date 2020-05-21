package MyCodes;


	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.LinkedHashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.Map.Entry;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

		public class TrialCarWale {
		
		public static void main(String[] args) throws InterruptedException, IOException
		{
			//1) Go to https://www.carwale.com/
			//--------------------------------------------
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_ver81.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
			options.merge(cap);
			
			ChromeDriver driver = new ChromeDriver(options);
			
		
			driver.get("https://www.carwale.com/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			//2) Click on Used
			//---------------
			
			driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
			
			//3) Select the City as Chennai
			//------------------------------
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementById("usedCarsList")));
			
			driver.findElementById("usedCarsList").sendKeys("Chennai");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']")));
			
			driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
			
			//4) Select budget min (8L) and max(12L) and Click Search
			//---------------------------------------------------------
			
			Thread.sleep(2000);
			
			//driver.findElementById("budgetBtn").click();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementById("minInput")));
			
			driver.findElementById("minInput").sendKeys("8",Keys.TAB);
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementById("maxInput")));
			
			driver.findElementById("maxInput").sendKeys("12",Keys.TAB);
			
			driver.findElementById("btnFindCar").click();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//5) Select Cars with Photos under Only Show Cars With
			//-----------------------------------------------------
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//li[@name='CarsWithPhotos']")));
			
			Actions action = new Actions(driver);
			
			action.moveToElement(driver.findElementByXPath("//li[@name='CarsWithPhotos']")).click().build().perform();
			
			Thread.sleep(2000);		
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@id='selectedFilters']//span[contains(text(),'Cars with Photos')]")));
			
			action.moveToElement(driver.findElementByXPath("//div[@id='selectedFilters']//span[contains(text(),'Cars with Photos')]")).build();
			
			//6) Select Manufacturer as "Hyundai" --> Creta
			//----------------------------------------------
			Thread.sleep(2000);
					
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//ul[@id='makesList']//li[@data-manufacture-en='Hyundai']")));
			
			
			WebElement element = driver.findElementByXPath("//ul[@id='makesList']//li[@data-manufacture-en='Hyundai']");
			
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].scrollIntoView();", element);
			executor.executeScript("arguments[0].click();", element);
			
			Thread.sleep(1000);
			
			//driver.switchTo().alert().dismiss();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//ul[@class='rootUl']//span[text()='Creta']")));
			
			element = driver.findElementByXPath("//ul[@class='rootUl']//span[text()='Creta']");
			
			executor.executeScript("arguments[0].scrollIntoView();", element);
			executor.executeScript("arguments[0].click();", element);
					
			//driver.findElementByXPath("//ul[@class='rootUl']//span[text()='Creta']").click();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@id='selectedFilters']//span[contains(text(),'Creta')]")));
			
			action.moveToElement(driver.findElementByXPath("//div[@id='selectedFilters']//span[contains(text(),'Creta')]")).perform();
			
			//7) Select Fuel Type as Petrol
			//------------------------------
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//h3[@class='sub-values' and contains(text(),'Fuel Type')]/span")));
			
			String classAttribute_AngleDownFuelType = driver.findElementByXPath("//h3[@class='sub-values' and contains(text(),'Fuel Type')]/span").getAttribute("class");
			
			if(classAttribute_AngleDownFuelType.equals("fa fa-angle-down"))
			{
				element = driver.findElementByXPath("//h3[@class='sub-values' and contains(text(),'Fuel Type')]/span");
				executor.executeScript("arguments[0].scrollIntoView();", element);
				action.moveToElement(element).click().build().perform();
				
			}
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@name='fuel']//li[@name='Petrol']")));
			
			element = driver.findElementByXPath("//div[@name='fuel']//li[@name='Petrol']");
			executor.executeScript("arguments[0].scrollIntoView();", element);
			
			driver.findElementByXPath("//div[@name='fuel']//li[@name='Petrol']").click();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@id='selectedFilters']//span[contains(text(),'Petrol')]")));
			
			//8) Select Best Match as "KM: Low to High"
			//-----------------------------------------
			
			WebElement eleBestMatch = driver.findElementById("sort");
			
			Select slt_BestMatch = new Select(eleBestMatch);
			
			slt_BestMatch.selectByVisibleText("Price: Low to High");
			
			
			//9) Validate the Cars are listed with KMs Low to High
			//-----------------------------------------------------
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//span[@class='slkms vehicle-data__item'])[1]")));
			
			List<WebElement> lst_ele_KMS = driver.findElementsByXPath("//span[@class='slkms vehicle-data__item']");
			
			List<Integer> lst_intKMS = getNumberFromList_Of_WebElements(lst_ele_KMS);
			
			Collections.sort(lst_intKMS);
			
			System.out.println("Sorted - "+lst_intKMS);
			
			List<Integer> lst_intKMS_WithoutSort = getNumberFromList_Of_WebElements(lst_ele_KMS);
			
			System.out.println("Without Sorted - "+lst_intKMS_WithoutSort);
			
			if(lst_intKMS_WithoutSort.equals(lst_intKMS)==true)
			{
				System.out.println("Cars KMS are sorted in a order");
			}
			else
			{
				System.out.println("Cars KMS are not sorted in a order");
			}
			
			
			//10) Add the least KM ran car to Wishlist
			//-----------------------------------------
			for(int i=0;i<lst_intKMS_WithoutSort.size();i++)
			{
				if(lst_intKMS_WithoutSort.get(i).equals(lst_intKMS.get(0)))
				{
					element = driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])["+(i+1)+"]");
					action.moveToElement(element).perform();
					executor.executeScript("arguments[0].click();", element);
					//action.moveToElement(driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])["+(i+1)+"]")).click().build().perform();
					Thread.sleep(2000);
					//driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])["+(i+1)+"]").click();
					break;
				}
			}
			
			//11) Go to Wishlist and Click on More Details
			//------------------------------------------------
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//li[@data-action='ShortList&CompareWindow_Click']")));
			driver.findElementByXPath("//li[@data-action='ShortList&CompareWindow_Click']").click();
			
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[contains(text(),'More details')]")));
			
			Thread.sleep(2000);
			
			driver.findElementByXPath("//a[contains(text(),'More details')]").click();
			
			Set<String> windowHandles = driver.getWindowHandles();
			
			List<String> lst_windowHandles = new ArrayList(windowHandles);
			
			if(lst_windowHandles.size()==2)
			{
				
				driver.switchTo().window(lst_windowHandles.get(1));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			
			//12) Print all the details under Overview . 13) Close the browser.
			//---------------------------------------------------------------
			
			List<WebElement> lstDetailsLeft = driver.findElementsByXPath("//div[@id='overview']//div[@class='equal-width text-light-grey']");
			
			List<WebElement> lstDetailsRight = driver.findElementsByXPath("//div[@id='overview']//div[@class='equal-width dark-text']");
			
			Map<String,String> map = new LinkedHashMap();
			
			for(int i=0;i<lstDetailsLeft.size();i++)
			{
				String strLeft = lstDetailsLeft.get(i).getText();
				String strRight = lstDetailsRight.get(i).getText();
				map.put(strLeft, strRight);
			}
			
			
			for(Entry<String,String> eachEntry: map.entrySet())
			{
				System.out.print(eachEntry.getKey()+"-----------"+eachEntry.getValue());
				System.out.println();
			}
			
			driver.quit();
			
			
		}
		
		public static List<Integer> getNumberFromList_Of_WebElements(List<WebElement> lst)
		{
			
			List<Integer> lstInt = new ArrayList();
			for(int i=0;i<lst.size();i++)
			{
				String text = lst.get(i).getText();
				text = text.replaceAll("\\D", "");
				int intTxt = Integer.parseInt(text);
				
				
				lstInt.add(intTxt);
			}
			
			return lstInt;
			
			
		}
		

	}


