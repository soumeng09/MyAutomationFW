package pageObjects;

import java.util.List;

import org.openqa.jetty.html.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class ParentPageObject {
	
	WebDriver driver;
	
	public ParentPageObject(WebDriver wbDriver) {
		this.driver = wbDriver;
		//this.driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public String fPageTitle(){
		//WebElement element = null;
		String strTitle = driver.getTitle();
		return strTitle;
		
	}
	
	public String fPageURL(){
		String strURL = driver.getCurrentUrl();
		return strURL;
	}
	
	public String fSiteURL(){
		String strURL = fPageURL();
		String siteURL = strURL;
		String[] arrURL = strURL.split("/");
		if (strURL.startsWith("http")){
			siteURL = arrURL[0] + "//" + arrURL[2];
		}
		else{
			siteURL = arrURL[0];
		}
		
		return siteURL;
		
	}
	
	public boolean fSearch(String srchString){
		return false;
	}
	
	public void fIterateLinks(){
		
	}
	
	public void fNavigateDirect(String navString) throws Exception{
		boolean bNavigated = false;
		driver.get(navString);
		
	}
	
	public void fSearchLinkAndClick(String linkText){
		//boolean bNavigated = false;
		String linkURL = "";
		System.out.println("Searching URLs");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total URLs found - " + links.size());
		for (WebElement link : links){
			linkURL = link.getAttribute("href");
			if (linkText.equalsIgnoreCase(linkURL)){
				System.out.println("Searched URL found - " + linkText);
				link.click();	
				break;
			}			
		}
		
	}
	
	public boolean fWaitForLoad() {
	    ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	            }
	        };
	    WebDriverWait wait = new WebDriverWait(driver, 60);
	    try{
	    	wait.until(pageLoadCondition);
		    Reporter.log("Page Loaded");
		    return true;
	    }catch(TimeoutException e){
	    	Reporter.log("Timed out after 60 seconds - Page not loaded.");
	    	return false;
	    }
	    
	}

}
