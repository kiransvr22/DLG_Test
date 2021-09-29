package com.web.app.test.login;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;




public class StepDefinition {

  //  WebDriver driver = null;
	WebDriver driver = browserInst();

    @Given("launch the application")
    public void launch_the_application() throws InterruptedException {
    	browserInst();
    	OpenURl(driver);
    	 System.out.print("Application");
    }


    @And("^Enter the Username and Password$")
    public void enter_the_username_and_password() throws Throwable {
    	Loigin(driver);
    	System.out.print("User name and password");
    }
    
    @Then("^Verify the Condition$")
    public void verify_the_condition() throws Throwable {
    	 System.out.print("Verify Condition");
    }

    @And("^close browser$")
    public void close_browser() throws Throwable {
    	 System.out.print("Close Browser");
    }
    
    
    
    

   

	public static WebDriver  browserInst() {
		System.setProperty("webdriver.chrome.driver", "servers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver=new ChromeDriver(capabilities);
		return driver;
	}
    
    public static void OpenURl(WebDriver driver) throws InterruptedException {
		driver.navigate().to("https://login.dev.qa-experience.com/login");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		Thread.sleep(4000);
    }
    
    public static void Loigin(WebDriver driver) throws InterruptedException {
    
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"okta-signin-username\"]")).sendKeys("implementation.empuser@scholastic.com");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"okta-signin-password\"]")).sendKeys("IECloud2021");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		Thread.sleep(4000);

		Thread.sleep(4000);
		driver.navigate().to("https://eejx-dev10.fa.us2.oraclecloud.com/fscmUI/faces/AtkHomePageWelcome");
		
		Thread.sleep(4000);
	
    }
   
}