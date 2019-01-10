package Testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.LoginControl;
import resources.BaseUtil;

public class Suite1Test extends BaseUtil {

	@BeforeMethod(description = "Initiate the Browser")
	public void startup() {
		driver = initBroswer();

	}

	@Test(priority = 1, description = "Verify Login functionality")
	public void loginToApp() {
		LoginControl lc = new LoginControl(driver);
		lc.getSignIcon().click();
		implicitWait();
		lc.getUsername().sendKeys(prop.getProperty("Username"));
		lc.getContinueBtn().click();
		lc.getPassword().sendKeys(prop.getProperty("Password"));
		lc.getSignInBtn().click();
		tearDown();
	}

	@Test(priority = 2, description = "Verify Product Search functionality")
	public void SearchProduct() {
		HomePage hm = new HomePage(driver);
		selectDropDownValue(hm.getSearchDropdownBox(), prop.getProperty("SelectProductCategory"));
		hm.getSearchBox().sendKeys(prop.getProperty("ProductSearch"));
		hm.getGoBtn().click();
		tearDown();

	}

	@Test(priority = 3, description = "Verify Product Search and Add to Cart functionality")
	public void addToCart() {
		HomePage hm = new HomePage(driver);
		selectDropDownValue(hm.getSearchDropdownBox(), prop.getProperty("SelectProductCategory"));
		hm.getSearchBox().sendKeys(prop.getProperty("ProductSearch"));
		hm.getGoBtn().click();
		implicitWait();
		hm.getLableLink().click();
		winddowHandle();
		selectDropDownValue(hm.getAddQuantity(), prop.getProperty("SelectQuantity"));
		hm.getAddCartBtn().click();
		String ActualMsg = hm.getAddMsg().getText();
		try {
			org.testng.Assert.assertEquals(prop.getProperty("CartSuccessMsg"), ActualMsg);

		} catch (Exception e) {
			System.out.println("Expected and Actual result not matches : " + e);
		}
		tearDown();

	}

}
