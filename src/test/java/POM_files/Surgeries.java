package POM_files;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Surgeries extends BasePage {

	public Surgeries(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath = "//*[text()='Surgeries']") WebElement surgeriesElement;
	
//	public boolean surgeriesClick() {
//		
//		if(surgeriesElement.isDisplayed()) {
//			surgeriesElement.click();
//			return true;
//		}
//		return false;
//	}
	
	@FindBy(xpath = "//*[text()='Popular Surgeries']") WebElement scrollElement;
	
	public void scrollDown(JavascriptExecutor js) {
		js.executeScript("arguments[0].scrollIntoView();", scrollElement);
	}
	
	@FindBy(xpath = "//p[@data-qa-id='surgical-solution-ailment-name']") List<WebElement> surgeriesListElement;
	
	public String[] surgeriesList() {
		String[] surList = new String[surgeriesListElement.size()];
		for(int i=0;i<surList.length;i++) {
			surList[i] = surgeriesListElement.get(i).getText();
		}
		return surList;
	}
	
	@FindBy(xpath = "//img[@alt='PCS Logo']") WebElement scrollTopElement;
	
	public void scrollTop(JavascriptExecutor js) {
		//js.executeScript("arguments[0].scrollIntoView();", scrollTopElement);
		js.executeScript("window.scrollTo(0,0)");
		//action.moveToElement(scrollTopElement).perform();
	}
	
	@FindBy(xpath = "//span[text()='For Corporates']") WebElement corporateElement;
	
	public void corporate() {
		corporateElement.click();
	}
	
	@FindBy(xpath = "//a[text()='Health & Wellness Plans']") WebElement healthWellnessElement;
		
	public void healthNWellness(JavascriptExecutor js) {
		healthWellnessElement.click();
		js.executeScript("window.scrollTo(0,200)");
	}
	
	@FindBy(xpath = "(//input)[1]") WebElement nameElement;
	@FindBy(xpath = "(//input)[2]") WebElement orgElement;
	@FindBy(xpath = "(//input)[3]") WebElement phnElement;
	@FindBy(xpath = "(//input)[4]") WebElement mailElement;
	
	public void name(String name) {
		nameElement.sendKeys(name);
	}
	
	public void org(String org) {
		orgElement.sendKeys(org);
	}
	
	public void phn(String phn) {
		phnElement.clear();
		phnElement.sendKeys(phn);
	}
	
	public void mail(String mail) {
		mailElement.clear();
		mailElement.sendKeys(mail);
	}
	
}
