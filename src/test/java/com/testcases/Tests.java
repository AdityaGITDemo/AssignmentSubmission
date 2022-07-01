package com.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.HomePageObj;
import pageObjects.LoginPageObj;
import resourses.BaseClass;
import resourses.ExcelUtils;

public class Tests extends BaseClass {
	public WebDriver driver;
	public Properties prop;
	LoginPageObj lpo;
	HomePageObj hpo;
	ExcelUtils d;
	WebDriverWait wait;
	
	@BeforeMethod
	public void objCreate() throws IOException{
		try {
			prop=propFiles();
			driver=initializeDriver(prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		lpo=new LoginPageObj(driver);
		hpo=new HomePageObj(driver);
		d=new ExcelUtils();
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(){
		driver.close();
	}
	
	@Test(enabled=true)
	public void endToEndTest() throws InterruptedException, IOException {	
		lpo.LoginToAcc(driver,prop);
		hpo.fragOption().click();
		hpo.menFrag().click();
		hpo.product().click();
		hpo.addToCart().click();
		hpo.checkOutOpt().click();
		hpo.confirmOrder().click();
		wait.until(ExpectedConditions.titleContains(hpo.orderConfirmation()));
		Assert.assertEquals(driver.getTitle(), hpo.orderConfirmation(), "Order not placed successfully!");
		System.out.println(driver.getTitle());	
		
	}
	
	@Test(enabled=false)
	public void registrationProcess() throws Exception {
		ArrayList data=d.getData(String.valueOf(prop.getProperty("serialNo")));
		//System.out.println(data.get(1));
		String a= String.valueOf(data.get(6));
		lpo.loginOption().click();
		lpo.continueOpt().click();
		lpo.firstName().sendKeys(String.valueOf(data.get(1)));	
		lpo.lastName().sendKeys(String.valueOf(data.get(2)));
		lpo.eMail().sendKeys(String.valueOf(data.get(3)));
		lpo.address1().sendKeys(String.valueOf(data.get(4)));
		lpo.city().sendKeys(String.valueOf(data.get(5)));
		Select dropDown1=new Select(lpo.stateDropDown());
		dropDown1.selectByVisibleText(String.valueOf(data.get(6)));
		lpo.zipCode().sendKeys(String.valueOf(data.get(7)));
		Select dropDown2=new Select(lpo.countryDropDown());
		dropDown2.selectByVisibleText(String.valueOf(data.get(8)));
		lpo.loginName2().sendKeys(String.valueOf(data.get(9)));
		lpo.passWord2().sendKeys(String.valueOf(data.get(10)));
		lpo.confirmPassword2().sendKeys(String.valueOf(data.get(10)));
		lpo.SubscribeNoOpt().click();
		lpo.policyCheckBox().click();
		lpo.continueOpt().click();
		//System.out.println(driver.getTitle());
		//System.out.println(driver.switchTo().alert().getText());
		wait.until(ExpectedConditions.titleContains(lpo.accStatus()));
		if((driver.getTitle().equals(lpo.registSuccess())))
			System.out.println("User registered successfully!");
		else
			System.out.println("User Account already exists! Check user info..");
			//throw new Exception("User Account already exists! Check user info..");
		    
	}
	
//	@Test(priority=1)
//	public void test1(){
//		System.out.println("Test 1");
//	}
//	
//	@Test(priority=2)
//	public void test2(){
//		System.out.println("Test 2");
//	}

}
