package Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrintWishList {
	public static ChromeDriver driver;
	public static Actions builder;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;

	@Given("User opens the Browser")
	public void userOpensTheChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_ver83.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);

		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 30);

		builder = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}

	@Given("user loads https:\\/\\/www.carwale.com\\/")
	public void userLoadsHttpsWwwCarwaleCom() {
		driver.get("https://www.carwale.com/");
	}

	@Given("User maximises the browser")
	public void userMaximisesTheBrowser() {
		driver.manage().window().maximize();
	}

	@Given("User set the default implicit timeout")
	public void userSetTheDefaultImplicitTimeout() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("user clicks on Used button")
	public void userClicksOnUsedButton() {
		driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
	}

	@Given("user selects the City as Chennai")
	public void userSelectsTheCityAsChennai() throws InterruptedException {
		WebElement webUsedCar = driver.findElementById("usedCarsList");
		webUsedCar.click();
		webUsedCar.sendKeys("Chennai");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']")));
		driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
	}

	@Given("user selects budget min \\({int}L) and max\\({int}L)")
	public void userSelectsBudgetMinLAndMaxL(Integer int1, Integer int2) throws InterruptedException {
		WebElement webMin = driver.findElementByXPath("//ul[@id='minPriceList']/li[text()='8 Lakh']");
		js.executeScript("arguments[0].click()", webMin);
		Thread.sleep(2000);
		driver.findElementByXPath("//ul[@id='maxPriceList']/li[text()='12 Lakh']").click();
		Thread.sleep(2000);
	}

	@Given("user clicks Search")
	public void userClicksSearch() throws InterruptedException {
		driver.findElementById("btnFindCar").click(); // search
		Thread.sleep(5000);
		driver.findElementByLinkText("Don't show anymore tips").click();
	}

	@Given("user select Cars with Photos under Only Show Cars With photos")
	public void userSelectCarsWithPhotosUnderOnlyShowCarsWithPhotos() throws InterruptedException {
		WebElement webCarsWithPhotos = driver.findElementByXPath("//li[@name='CarsWithPhotos']");
		js.executeScript("arguments[0].click()", webCarsWithPhotos);
		Thread.sleep(2000);
	}

	@Given("user select Manufacturer as Hyundai and Creta")
	public void userSelectManufacturerAsHyundaiAndCreta() {
		WebElement webHyundai = driver.findElementByXPath("//li[@data-manufacture-en='Hyundai']/span");
		js.executeScript("arguments[0].click()", webHyundai);
		WebElement webCreta = driver.findElementByXPath("//span[text()='Creta']");
		js.executeScript("arguments[0].click()", webCreta);
	}

	@Given("user select Fuel Type as Petrol")
	public void userSelectFuelTypeAsPetrol() {
		WebElement webFuel = driver.findElementByXPath("//div[@name='fuel']/h3");
		js.executeScript("arguments[0].click()", webFuel);
		WebElement webPetrol = driver.findElementByXPath("(//span[text()='Petrol'])[1]");
		js.executeScript("arguments[0].click()", webPetrol);
	}

	@Given("user select Best Match as KM: Low to High")
	public void userSelectBestMatchAsKMLowToHigh() {
	      WebElement webSort = driver.findElementByXPath("//select[@id='sort']");
	      Select drp = new Select(webSort);
	      drp.selectByValue("2");
	}

	@Given("user validate the Cars are listed with KMs Low to High")
	public void userValidateTheCarsAreListedWithKMsLowToHigh() {
	    List<WebElement> webKM_List = driver.findElementsByXPath("//span[@class='slkms vehicle-data__item']");
	      for (int i = 0; i < webKM_List.size(); i++) {
	    	  String KmofCar = webKM_List.get(i).getText();
	    	  
	    	  String value=KmofCar.replaceAll("\\D","");
	    	  
	    	  int KmofCar_int = Integer.parseInt(value);
	    	  System.out.println("Km of the Cars:"+KmofCar_int);
		}
	}

	@Given("Add the least KM ran car to Wishlist")
	public void addTheLeastKMRanCarToWishlist() {
		driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])[1]").click();
	}

	@Given("Go to Wishlist")
	public void goToWishlist() {
		driver.findElementByXPath("//li[@data-action='ShortList&CompareWindow_Click']/span").click();
	}

	@When("Click on More Details")
	public void clickOnMoreDetails() {
		driver.findElementByLinkText("More details »").click();
	}

	@Then("user should be able to see the overview page")
	public void userShouldBeAbleToSeeTheOverviewPage() {
	     Set<String> winSet = driver.getWindowHandles();
	      List<String> winList = new ArrayList<String>(winSet);
	      driver.switchTo().window(winList.get(1));
	    if(!winList.isEmpty())  
	    	System.out.println("Overview page");
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the user print all the details under Overview")
	public void theUserPrintAllTheDetailsUnderOverview() {
	      List<WebElement> overviewDetails = driver.findElementsByXPath("//div[@class='overview-list padding-bottom10']//div");
	      for (WebElement webElement : overviewDetails) {
	    	  System.out.print(webElement.getText()+ "\t");
		  }
	}

	@Then("user should close the browser")
	public void userShouldCloseTheBrowser() {
		driver.close();
	}
}