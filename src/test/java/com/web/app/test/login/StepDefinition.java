package com.web.app.test.login;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class StepDefinition {
	 HomePageDefinit data = new HomePageDefinit(browserInst());
	@Given("launch the application")
    public void launch_the_application() throws InterruptedException {
    	//data.homepage.OpenURl(data.driver);
		data.OpenURl(data.driver);
    	 System.out.print("Application");
    }


    @And("^Enter the Username and Password$")
    public void enter_the_username_and_password() throws Throwable {
    	//data.homepage.Loigin(data.driver);
    	data.Loigin(data.driver);
    	System.out.print("User name and password");
    }
    
    @Then("^Verify the Condition$")
    public void verify_the_condition() throws Throwable {
    	//data.homepage.Verify(data.driver);
    	data.Verify(data.driver);
    	System.out.print("Verify Condition");
    }

    @And("^close browser$")
    public void close_browser() throws Throwable {
    	//data.homepage.closeBrowser(data.driver);
    	data.closeBrowser(data.driver);
    	System.out.print("Close Browser");
    }
    
    
    public static WebDriver  browserInst() {
		  System.setProperty("webdriver.chrome.driver", "servers/chromedriver.exe");
		  WebDriver driver = new ChromeDriver(); 
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); 
		return driver;
	}
    

   

	

}




   

