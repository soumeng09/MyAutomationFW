package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHQPage extends ParentPageObject {

	public SeleniumHQPage(WebDriver wbDriver) {
		super(wbDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean fSearch(String srchString) {
		// TODO Auto-generated method stub
		boolean bNavigated = false;
		String siteURL = fSiteURL();
		System.out.println(siteURL);
		WebElement searchField = driver.findElement(By.cssSelector("input[id='q'][name='q']"));
		if(searchField.isEnabled()){
			System.out.println("Search field found");
			searchField.sendKeys(srchString);
		}
		else{
			System.out.println("Search field not enabled");
		}
		/*WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit'][value='Go']"));
		//WebElement srchResult= driver.findElement(By.cssSelector("div[id='resultStats']"));
		
		submitBtn.click();
		*/
		
		searchField.sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='resInfo-0']")));
		//driver.wait(5);
		System.out.println("Search found");
		String siteURL2 = fSiteURL();
		bNavigated = (siteURL.equalsIgnoreCase(siteURL2));
		System.out.println(bNavigated);
		return bNavigated;
	}
	
	public void fEchoPage(){
		System.out.println("On selenium HQ Page");
		System.out.println("Comment added from remote Branch1");
	}

}
