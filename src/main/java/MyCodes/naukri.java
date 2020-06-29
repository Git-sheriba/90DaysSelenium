package MyCodes;

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

public class naukri {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--Start-maximized");
		options.addArguments("--disable-popup-blocking");
		System.setProperty("webdriver.chrome.driver" ,"./drivers/chromedriver_ver83.exe");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://www.naukri.com/");
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElementByXPath("//span[text()='Later']")));
		driver.findElementByXPath("//span[text()='Later']").click();
		
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		
		for (int i = 1; i < winList.size(); i++) {
			driver.switchTo().window(winList.get(i));
			String imgName = driver.findElementByXPath("//img").getAttribute("alt");
			System.out.println(i + "st company namme: " + imgName);
			driver.close();
		}
		
		driver.switchTo().window(winList.get(0));
		 driver.findElementById("blobNotificationURL").click();
		 System.out.println("1");
		
		/*WebElement upload = driver.findElement(By.xpath("//input[@id='file_upload']"));
		upload.sendKeys("C:\\sheriba\\photos\\children.jpg");
		
		String errorMsg = driver.findElementByXPath("//div[@class='error-header-desc error']").getText();
		System.out.println("The error message: "+ errorMsg);*/
		
		
	
	}

}
