package com.web.app.test.login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectRepository {
	static FileInputStream fn = null;
	public static Properties OBJREP = null;
	public static Properties ENVREP = null;

	static WebDriver driver;
	ObjectRepository(WebDriver driver) {
		this.driver = driver;
	}
	public static void loadPageObjects() throws IOException {
		try {

			OBJREP = new Properties();
			
			FileInputStream fn = new FileInputStream(ClassLoader.getSystemClassLoader().getResource("objrep.properties").getPath());
			OBJREP.load(fn);
		} catch (IOException ie) {
			System.out.println("Failed to load objrep.properties");
			throw ie;
		}finally {
			if(fn!=null) {
				fn.close();
			}
			
		}
	}
	public static WebElement getElement(String xpathKey) throws Exception {
		try {
			if (OBJREP == null)
				loadPageObjects();
			// System.out.println("Xpath Found");
			return driver.findElement(By.xpath(OBJREP.getProperty(xpathKey)));
		} catch (Exception e) {
			System.out.println("Failed in getElement.." + e);
			throw e;
		}
	}
	
	
	
	public static WebElement getElement(String xpathKey,Long timeout) throws Exception {
		try {
			if (OBJREP == null)
				loadPageObjects();
			// System.out.println("Xpath Found");
			Thread.sleep(timeout);
			WebElement element=driver.findElement(By.xpath(OBJREP.getProperty(xpathKey)));
			return element;
		} catch (Exception e) {
		//	System.out.println("Failed To getElement.."+ OBJREP.getProperty(xpathKey) + "##########################" + e);
			throw e;
		}
	}
	

	public static void drpdwn(String xpathKey, String selectValue) throws Exception {
		try {
			Select element = new Select(getElement(xpathKey));
			// element.selectByVisibleText(sState);
			element.selectByValue(selectValue);
		} catch (Exception e) {
			System.out.println("Failed in drpdwn.." + e);
			throw (e);
		}
	}
	public static void getFocusNew() throws Exception {
		try {
			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}

			System.out.println("Got foucus to new window.");
		} catch (Exception e) {
			System.out.println("Failed in getting foucus to new window.");
			throw (e);
		}
	}
	public static String getHandle() throws Exception {
		String winHandleBefore = null;
		try {
			// Store the current window handle
			winHandleBefore = driver.getWindowHandle();
			System.out.println("Got handle to main window.");
		} catch (Exception e) {
			System.out.println("Failed in getting handle to main window.");
			throw (e);
		}
		return winHandleBefore;
	}
	public static void getFocusBack(String winHandleBefore) throws Exception {
		try {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			System.out.println("Got foucus to main window.");
		} catch (Exception e) {
			System.out.println("Failed in getting foucus back to main window.");
			throw (e);
		}

	}
	public static void getFrame(String frameName) throws Exception {
		try {
			// Switch back to original browser (first window)
			driver.switchTo().frame(frameName);
			System.out.println("Got foucus to frame.");
		} catch (Exception e) {
			System.out.println("Failed in getting foucus to frame.");
			throw (e);
		}

	}

	public void dispose() throws InterruptedException {
		Thread.sleep(1000);
		// tso.close();
		Thread.sleep(1000);

	}
	
	
	
	public static void loadEnvObjects() throws IOException {
		try {

			ENVREP = new Properties();
			
			FileInputStream fn = new FileInputStream(ClassLoader.getSystemClassLoader().getResource("env.properties").getPath());
			ENVREP.load(fn);
			
		} catch (IOException ie) {
			System.out.println("Failed to load objrep.properties");
			throw ie;
		}finally {
			if(fn!=null) {
				fn.close();
			}
			
		}
	}
	
	public static void  getUrl() {
		
		try {
			if (ENVREP == null) {
				loadEnvObjects();
			}
			 System.out.println("URL Found"+ENVREP.getProperty("url"));
			 	driver.navigate().to(ENVREP.getProperty("url"));
		} catch (Exception e) {
			System.out.println("Failed in getElement.." + e);
		}
		
		
	}
	
	
	
	public static WebElement getElementClickable(String xpathKey, WebDriver driver,Long timeoutInSeconds) throws Exception {
	    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

		try {
			if (OBJREP == null)
				loadPageObjects();
			// System.out.println("Xpath Found");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(OBJREP.getProperty(xpathKey))))); 
			return element;
		} catch (Exception e) {
			System.out.println("Failed in getElement.." + e);
			throw e;
		}
	}
}