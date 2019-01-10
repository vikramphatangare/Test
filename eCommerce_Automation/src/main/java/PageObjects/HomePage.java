package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='searchDropdownBox']")
	WebElement searchDropdownBox;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;

	@FindBy(xpath = "//input[@value='Go']")
	WebElement goBtn;

	@FindBy(xpath = "//h2[contains(text(),'Kingston DataTraveler 50 USB 3.0 Metal Body Pendri')]")
	WebElement lableLink;

	@FindBy(xpath = "//select[@id='quantity']")
	WebElement addQuantity;
	
		
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addCartBtn;
	
	@FindBy(xpath="//h1[@class='a-size-medium a-text-bold']") WebElement addMsg;

	public WebElement getSearchDropdownBox() {
		return searchDropdownBox;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getGoBtn() {
		return goBtn;
	}

	public WebElement getLableLink() {
		return lableLink;
	}
	
	public WebElement getAddQuantity() {
		return addQuantity;
	}
	

	public WebElement getAddCartBtn() {
		return addCartBtn;
	}
	
	public WebElement getAddMsg()
	{
		return addMsg;
	}

}
