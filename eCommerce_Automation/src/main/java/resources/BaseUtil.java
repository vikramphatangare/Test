package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseUtil {

	public WebDriver driver = null;
	public Properties prop;
	String propertyFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config-data.Properties";

	public WebDriver initBroswer() {
		// Set up Properties
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(propertyFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Error: File Not Found :" + e);
		} catch (IOException e) {
			System.out.println("Error: IO Error :" + e);
		}
		// Setup Chrome path
		System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromePropertyPath"));
		// System.setProperty("webdriver.chrome.driver", chromeExePath);
		// Select Browser for execution
		// System.out.println(prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");

		if (browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			driver = new InternetExplorerDriver();

		}
		// Open URL
		// System.out.println(prop.getProperty("HomePageURL"));
		driver.get(prop.getProperty("HomePageURL"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void implicitWait() {

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void selectDropDownValue(WebElement mySelectedElement, String visibileText) {
		Select select = new Select(mySelectedElement);
		select.selectByVisibleText(visibileText);
	}
	
	// Clear the text box and Send a Value
		public void setText(By elementLoc, String stringVal) {

			driver.findElement(elementLoc).clear();
			driver.findElement(elementLoc).sendKeys(stringVal);
		}
		

	/*
	 * public void explicitWait() {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 10); WebElement element =
	 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy("")); }
	 */

	public void winddowHandle() {
		Set<String> handle = driver.getWindowHandles();
		java.util.Iterator<String> itr = handle.iterator();
		String parentId = itr.next();
		String childId = itr.next();
		driver.switchTo().window(childId);
		driver.getTitle();
	}
	
	
	

}