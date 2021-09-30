package com.web.app.test.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageDefinit {
	public WebDriver driver;

	public HomePageDefinit(WebDriver driver) {
		this.driver = driver;
	}
	
	
  
  public static void OpenURl(WebDriver driver) throws InterruptedException {
		
	  new ObjectRepository(driver);
	  
	  	ObjectRepository.getUrl();
	//  driver.navigate().to("https://login.dev.qa-experience.com");
		driver.manage().window().maximize();
	//	driver.navigate().refresh();
		Thread.sleep(4000);
  }
  
  public static void Loigin(WebDriver driver) throws Exception {
  
  	  new ObjectRepository(driver);
  	  ObjectRepository.getElement("UserName",3000L).sendKeys("test@qa-experience.com");
  	  ObjectRepository.getElement("Password",3000L).sendKeys("Password1");
  	  ObjectRepository.getElement("SignIn",2000L).click(); }
	
  
  
  public void Verify(WebDriver driver) throws Exception {
	    
		new ObjectRepository(driver);
		String Successfully = ObjectRepository.getElement("Verify",4000L).getText();
		System.out.println("Page Logged in ---" + Successfully);
	}


	public void closeBrowser(WebDriver driver) throws InterruptedException {
		driver.close();
		driver.quit();

	} 
}