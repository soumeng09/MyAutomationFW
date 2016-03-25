package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage extends ParentPageObject {

	public GooglePage(WebDriver wbDriver) {
		super(wbDriver);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean fSearch(String srchString){
		boolean bNavigated = false;
		String siteURL = fSiteURL();
		System.out.println(siteURL);
		//WebElement searchField = driver.findElement(By.cssSelector("input[id='gs_htif0'][class='gsfi']"));
		WebElement searchField = driver.findElement(By.name("q"));
		if(searchField.isEnabled()){
			System.out.println("Google search field found");
			searchField.sendKeys(srchString);
		}
		else{
			System.out.println("Google search field not enabled");
		}
		
//		WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit'][value='Search']"));
//		if(submitBtn.isEnabled()){
//			System.out.println("Google search button found");
//			submitBtn.click();
//			System.out.println("Google search button clicked");
//		}
//		else{
//			System.out.println("Google search button not enabled");}
		
		searchField.sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='resultStats']")));
		//driver.wait(5);
		String siteURL2 = fSiteURL();
		System.out.println(siteURL);
		System.out.println(siteURL2);
		bNavigated = (siteURL.equalsIgnoreCase(siteURL2));
		System.out.println("Navigated - " + bNavigated);
		return bNavigated;
	}
}
