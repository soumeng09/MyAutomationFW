package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class aetnaPage extends ParentPageObject{

	public aetnaPage(WebDriver wbDriver) {
		super(wbDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void fIterateLinks(){
		WebElement eIndFamily;
		List<WebElement> eLinks;
		Properties prop = new Properties();
		InputStream input = null;
		try{
			//input = new FileInputStream("/Framework_1.0/src/conf/aetnaPage.properties");
			input = getClass().getClassLoader().getResourceAsStream("conf/aetnaPage.properties");
			prop.load(input);
			
			eIndFamily = driver.findElement(By.xpath(prop.getProperty("field1"))); 
			String strLinksPath = prop.getProperty("childDiv") + prop.getProperty("searchLists") + prop.getProperty("searchAnchors");
			
			if(eIndFamily.isDisplayed()){
				Reporter.log("Element located");
				Actions actions = new Actions(driver);
				actions.moveToElement(eIndFamily).build().perform();
				
				if (driver.findElement(By.xpath(prop.getProperty("parentDiv"))).isDisplayed()){
					eLinks = driver.findElements(By.xpath(strLinksPath));
					for(WebElement e:eLinks){
						Reporter.log(e.getText());
					}
				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				input.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}

	}
}
