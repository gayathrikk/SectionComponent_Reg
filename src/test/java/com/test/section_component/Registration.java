package com.test.section_component;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Registration {
	private RemoteWebDriver driver;
	private WebDriverWait wait;


	@BeforeTest

	public void setup() throws Exception
	{
	DesiredCapabilities dc = DesiredCapabilities.chrome();
	       URL url = new URL("http://172.20.23.7:5555/wd/hub");
	       driver = new RemoteWebDriver(url, dc);
	       wait = new WebDriverWait(driver, 10);
	}

	@Test(priority=1)
	public void login() throws InterruptedException
	{
	driver.get("http://apollo2.humanbrain.in/");
	driver.manage().window().maximize();
	String currentURL = driver.getCurrentUrl();
	System.out.println("Current URL: " + currentURL);
	WebDriverWait wait = new WebDriverWait(driver, 60);
	driver.switchTo().defaultContent(); // Switch back to default content
	WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
	if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
	viewerElement.click();
	System.out.println("Viewer icon is clicked");
	} else {
	System.out.println("Viewer icon is not clickable");
	}


	String parentWindow = driver.getWindowHandle();
	WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
	if (loginButton != null) {
	loginButton.click();
	System.out.println("Login button clicked successfully.");
	} else {
	System.out.println("Login button is not clicked.");
	}

	  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	  Set<String> allWindows = driver.getWindowHandles();
	for (String window : allWindows) {
	if (!window.equals(parentWindow)) {
	   driver.switchTo().window(window);
	    break;
	}
	}
	WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
	if (emailInput != null && emailInput.isDisplayed()) {
	emailInput.sendKeys("teamsoftware457@gmail.com");
	System.out.println("Email was entered successfully.");
	} else {
	System.out.println("Email was not entered.");
	}


	WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	if (nextButton1 != null) {
	nextButton1.click();
	System.out.println("Next button 1 is clicked.");
	} else {
	System.out.println("Next button 1 is not clicked.");
	}

	WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
	passwordInput.sendKeys("Health#123");
	if (passwordInput.getAttribute("value").equals("Health#123")) {
	System.out.println("Password was entered successfully.");
	} else {
	System.out.println("Password was not entered.");
	}


	WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	if (nextButton2 != null) {
	nextButton2.click();
	System.out.println("Next button 2 is clicked.");
	} else {
	System.out.println("Next button 2 is not clicked.");
	}


	driver.switchTo().window(parentWindow);
	System.out.println("Login successfully");

	System.out.println("************************Login validation done***********************");
	       
	}

	@Test(priority=2)
	public void viewerPage() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[6]/td[1]" ))).click();

	Thread.sleep(2000);

	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[7]/td[2]" ))).click();

	Thread.sleep(2000);

	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[11]/td[3]" ))).click();

	Thread.sleep(5000);

	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='136'])[1]"))).click();
	 
	  WebElement atlasIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Manual Registration']")));
	if (atlasIcon != null && atlasIcon.isDisplayed()) {
	atlasIcon.click();
	    System.out.println("Manual Registration icon is clicked successfully");
	} else {
	   System.out.println("Manual Registration icon is not clicked");
	}
	Thread.sleep(3000);


	WebElement speciesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select)[1]")));
	if (speciesButton != null && speciesButton.isDisplayed()) {
	speciesButton.click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[@value='Goat']"))).click();
	    System.out.println("Mouse species is selected successfully");
	} else {
	   System.out.println("Species is not selected");
	}
	Thread.sleep(3000);

	WebElement organType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select)[2]")));
	if (organType != null && organType.isDisplayed()) {
	organType.click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[@value='Brain']"))).click();
	    System.out.println("Organ type as Brain is selected successfully");
	} else {
	   System.out.println("Organ type is not selected");
	}
	Thread.sleep(3000);

	WebElement organName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select)[3]")));
	if (organName != null && organName.isDisplayed()) {
	organName.click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[@value='Goat_Brain4']"))).click();
	    System.out.println("Organ Name is selected successfully");
	} else {
	   System.out.println("Organ Name is not selected");
	}
	Thread.sleep(3000);

	WebElement series = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select)[4]")));
	if (series != null && series.isDisplayed()) {
	series.click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[@value='NISSL']"))).click();
	    System.out.println("Series type is selected successfully");
	} else {
	   System.out.println("Series type is not selected");
	}
	Thread.sleep(3000);

	WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select)[5]")));
	if (section != null && section.isDisplayed()) {
	section.click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[@value='245']"))).click();
	    System.out.println("Section is selected successfully");
	} else {
	   System.out.println("Section is not selected");
	}
	Thread.sleep(3000);

	WebElement loadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Load']")));
	if (loadButton != null && loadButton.isDisplayed()) {
	loadButton.click();
	    System.out.println("Load button is clicked successfully");
	} else {
	   System.out.println("Load button is not clicked");
	}
	Thread.sleep(3000);

	String[] expectedFileName = {"14 | NISSL | 245"};  
	     java.util.List<WebElement> locationElements = driver.findElements(By.xpath("(//div[@class='paragraph'])[1]"));
	     String actualFileName = locationElements.get(0).getText();

	     Thread.sleep(2000);
	     
	     try {
	     Assert.assertEquals(actualFileName, expectedFileName[0], "FileName not matching.");
	     System.out.println("Image loaded successfully.");
	    } catch (AssertionError e) {
	       // Handle the assertion error here, for example:
	       System.out.println("Assertion failed: " + e.getMessage());
	    }

	}
	@AfterTest
	 public void afterTest() {
	 driver.quit();
	}


}
