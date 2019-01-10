package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginControl {

	WebDriver driver;

	public LoginControl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='nav-link-yourAccount']//span[@class='nav-icon nav-arrow']")
	WebElement signIcon;
	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement username;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;
	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement signInBtn;

	public WebElement getSignIcon() {
		return signIcon;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

}
