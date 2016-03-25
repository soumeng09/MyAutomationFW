package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSrchPage extends ParentPageObject {

	public GoogleSrchPage(WebDriver wbDriver) {
		super(wbDriver);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean fSearch(String srchString){
		boolean bNavigated = false;
		String siteURL = fSiteURL();
		WebElement searchField = driver.findElement(By.cssSelector("input[id='gs_htif0'][class='gsfi']"));
		WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit'][value='Search']"));
		//WebElement srchResult= driver.findElement(By.cssSelector("div[id='resultStats']"));
		
		searchField.sendKeys(srchString);
		submitBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='resultStats']")));
		//driver.wait(5);
		String siteURL2 = fSiteURL();
		bNavigated = (siteURL.equalsIgnoreCase(siteURL2));
		return bNavigated;
	}
}
