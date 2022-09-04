package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageObj {

public WebDriver driver;
	
	public HomePageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[contains(text(),'Fragrance')])[2]") 
	WebElement fragOption;
	
	public WebElement fragOption(){
		return fragOption;
	}
	
	@FindBy(xpath="//div[@id='maincontainer']//a[text()='Men']") 
	WebElement menFrag;
	
	public WebElement menFrag(){
		return menFrag;
	}
	
	@FindBy(css="a[title='Pour Homme Eau de Toilette']") 
	WebElement product;
	
	public WebElement product(){
		return product;
	}
	
	@FindBy(xpath="//a[contains(@onclick,'submit')]") 
	WebElement addToCart;
	
	public WebElement addToCart(){
		return addToCart;
	}
	
	@FindBy(css="a#cart_checkout2") 
	WebElement checkOutOpt;
	
	public WebElement checkOutOpt(){
		return checkOutOpt;
	}
	
	@FindBy(css="button#checkout_btn") 
	WebElement confirmOrder;
	
	public WebElement confirmOrder(){
		return confirmOrder;
	}
	
	@FindBy(xpath="//ul[@id='main_menu_top']//li[@data-id='menu_account']") 
	WebElement accOpt;
	
	public WebElement accOpt(){
		return accOpt;
	}
	
	@FindBy(xpath="//ul[@id='main_menu_top']//li[@data-id='menu_logout']//span") 
	WebElement logOut;
	
	public WebElement logOut(){
		return logOut;
	}
	
	public String orderConfirmation(){
		String expected="Your Order Has Been Processed!";
		return expected;
	}
	
}
