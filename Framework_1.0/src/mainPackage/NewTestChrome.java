package mainPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import pageObjects.ParentPageObject;
import pageObjects.aetnaPage;

public class NewTestChrome {
	
	WebDriver scriptDriver;
	
  @Test
  public void funB() {  
	  ParentPageObject pgAetna = new aetnaPage(scriptDriver);
	  if(pgAetna.fWaitForLoad())
		  pgAetna.fIterateLinks();  
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Initializing test - Launching browser");
	  try{
		  System.setProperty("webdriver.chrome.driver", "F:/selenium/chromedriver.exe");
		  scriptDriver = new ChromeDriver();
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
