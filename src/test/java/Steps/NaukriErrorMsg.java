package Steps;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NaukriErrorMsg {
	public static ChromeDriver driver;
	@Given("user opens the chrome browser")
	public void userOpensTheChromeBrowser() {
		ChromeOptions options = new ChromeOptions();
	//	options.addArguments("--disable-notifications");
		options.addArguments("--Start-maximized");
	//	options.addArguments("--disable-popup-blocking");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_ver83.exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("user loads https:\\/\\/www.naukri.com\\/")
	public void userLoadsHttpsWwwNaukriCom() {
		driver.get("https://www.naukri.com/");
	}

	@Given("Cancel the notification")
	public void cancelTheNotification() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElementByXPath("//span[text()='Later']")));
		driver.findElementByXPath("//span[text()='Later']").click();
	}

	@Given("Get the name of the windows and close")
	public void getTheNameOfTheWindowsAndClose() {
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		
		for (int i = 1; i < winList.size(); i++) {
			driver.switchTo().window(winList.get(i));
			String imgName = driver.findElementByXPath("//img").getAttribute("alt");
			System.out.println(i + "st company namme: " + imgName);
			driver.close();
		}
		driver.switchTo().window(winList.get(0));
	}

	@When("Picture file uploaded")
	public void pictureFileUploaded() {
		WebElement upload = driver.findElement(By.xpath("//input[@id='file_upload']"));
		upload.sendKeys("C:\\sheriba\\photos\\children.jpg");
	}

	@Then("Error message displayed")
	public void errorMessageDisplayed() {
		String errorMsg = driver.findElementByXPath("//div[@class='error-header-desc error']").getText();
		System.out.println("The error message: "+ errorMsg);
	}

}
