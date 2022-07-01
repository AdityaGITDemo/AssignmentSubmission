package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resourses.BaseClass;

public class LoginPageObj extends BaseClass {
	
	public WebDriver driver;
	
	public LoginPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Elements for  normal login-
	
	@FindBy(xpath="//ul[contains(@id,'customer_menu_top')]//a") 
	WebElement loginOption;
	
	public WebElement loginOption(){
		return loginOption;
	}
	
	@FindBy(name="loginname") 
	WebElement loginName;
	
	@FindBy(id="loginFrm_password") 
	WebElement passWord;
	
	@FindBy(xpath="//button[@title='Login']") 
	WebElement loginButton;
	
	
	//Elements for registration process-
	
	@FindBy(css="button[title='Continue']") 
	WebElement continueOpt;
	
	public WebElement continueOpt(){
		return continueOpt;
	}
	
	@FindBy(css="input#AccountFrm_firstname") 
	WebElement firstName;
	
	public WebElement firstName(){
		return firstName;
	}
	
	@FindBy(css="input#AccountFrm_lastname") 
	WebElement lastName;
	
	public WebElement lastName(){
		return lastName;
	}
	
	@FindBy(css="input#AccountFrm_email") 
	WebElement eMail;
	
	public WebElement eMail(){
		return eMail;
	}
	
	@FindBy(css="input#AccountFrm_address_1") 
	WebElement address1;
	
	public WebElement address1(){
		return address1;
	}
	
	@FindBy(css="input#AccountFrm_city") 
	WebElement city;
	
	public WebElement city(){
		return city;
	}
	
	@FindBy(css="select#AccountFrm_zone_id") 
	WebElement stateDropDown;
	
	public WebElement stateDropDown(){
		return stateDropDown;
	}
	
	@FindBy(css="input#AccountFrm_postcode") 
	WebElement zipCode;
	
	public WebElement zipCode(){
		return zipCode;
	}
	
	@FindBy(css="select#AccountFrm_country_id") 
	WebElement countryDropDown;
	
	public WebElement countryDropDown(){
		return countryDropDown;
	}
	
	@FindBy(css="input#AccountFrm_loginname") 
	WebElement loginName2;
	
	public WebElement loginName2(){
		return loginName2;
	}
	
	@FindBy(css="input#AccountFrm_password") 
	WebElement passWord2;
	
	public WebElement passWord2(){
		return passWord2;
	}
	
	@FindBy(css="input#AccountFrm_confirm") 
	WebElement confirmPassword2;
	
	public WebElement confirmPassword2(){
		return confirmPassword2;
	}
	
	@FindBy(css="input#AccountFrm_newsletter0") 
	WebElement SubscribeNoOpt;
	
	public WebElement SubscribeNoOpt(){
		return SubscribeNoOpt;
	}
	 	
	@FindBy(css="input#AccountFrm_agree") 
	WebElement policyCheckBox;
	
	public WebElement policyCheckBox(){
		return policyCheckBox;
	}
	
	public String accStatus(){
		String expected="Account";
		return expected;
	}
	
	public String registSuccess(){
		String expected="Your Account Has Been Created!";
		return expected;
	}
	
	public String registFailure(){
		String expected="Create Account";
		return expected;
	}
	
	public void LoginToAcc(WebDriver driver, Properties prop) throws InterruptedException, IOException{
		System.out.println(driver.getTitle());
		String expected1="A place to practice your automation skills!";
		Assert.assertEquals(driver.getTitle(), expected1, "Main page not loaded. Please check the base url!"); //To verify whether we landed on the correct page
		driver.findElement(By.xpath("//ul[contains(@id,'customer_menu_top')]//a")).click();
		loginOption.click();
		loginName.sendKeys(prop.getProperty("loginname"));		
		passWord.sendKeys(prop.getProperty("password"));
		loginButton.click();
		System.out.println(driver.getTitle());
		String expected2="My Account";
		Assert.assertEquals(driver.getTitle(), expected2, "Could not login to the account!");
	}
	

}
