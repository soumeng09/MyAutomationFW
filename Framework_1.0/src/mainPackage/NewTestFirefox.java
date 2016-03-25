package mainPackage;

import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pageObjects.GooglePage;
import pageObjects.GoogleSrchPage;
import pageObjects.ParentPageObject;
import pageObjects.SeleniumHQPage;
import pageObjects.aetnaPage;

import java.util.*;

public class NewTestFirefox {
	
	WebDriver scriptDriver;
  @Test
  public void funA() throws Exception {
	  
	 //ParentPageObject pgLaunch = new GooglePage(scriptDriver);
	 // pgLaunch.fNavigateDirect("http://www.seleniumhq.org/");
		  
//	  ParentPageObject pgGoogle = new GooglePage(scriptDriver);
//	  pgGoogle.fWaitForLoad();
//	  if(pgGoogle.fSearch("Selenium")){
//		  System.out.println("Search results found");
//		  ParentPageObject pgGoogleSrch = new GoogleSrchPage(scriptDriver);
//		  pgGoogleSrch.fWaitForLoad();
//		  pgGoogleSrch.fSearchLinkAndClick("http://www.seleniumhq.org/");
//			  
//		  ParentPageObject pgSelenium = new SeleniumHQPage(scriptDriver);
//		  pgSelenium.fWaitForLoad();
//		  pgSelenium.fSearch("Webdriver");
//		 
//	  }
	  
	  ParentPageObject pgAetna = new aetnaPage(scriptDriver);
	  if(pgAetna.fWaitForLoad())
		  pgAetna.fIterateLinks();
  }
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browser) {
	  System.out.println("Initializing test - Launching browser");
	  try{
		  if(browser.equalsIgnoreCase("FF")){
			  scriptDriver = new FirefoxDriver();
		  }
		  else if(browser.equalsIgnoreCase("Chrome")){
			  System.setProperty("webdriver.chrome.driver", "F:/selenium/chromedriver.exe");
			  scriptDriver = new ChromeDriver();
		  }
		  
		  scriptDriver.manage().window().maximize();
		  scriptDriver.get("https://www.aetna.com/individuals-families.html"); 
		  
	  }catch(Exception e){
		  System.out.println("Encountered exception - ");
		  System.out.println(e.getMessage());
	  }
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Finalizing test - Quit Browser");
	  scriptDriver.close();
	  scriptDriver.quit();
  }

}
