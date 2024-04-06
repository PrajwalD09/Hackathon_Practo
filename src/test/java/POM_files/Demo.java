package POM_files;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo extends BasePage {
	
	JavascriptExecutor js;
	
	public Demo(WebDriver driver) {
		super(driver);
//		js = (JavascriptExecutor)driver;
	}
	
	@FindBy(xpath = "(//input)[1]") WebElement nameElement;
	@FindBy(xpath = "(//input)[2]") WebElement orgElement;
	@FindBy(xpath = "(//input)[3]") WebElement phnElement;
	@FindBy(xpath = "(//input)[4]") WebElement mailElement;
	
	public void name(String name,  JavascriptExecutor js) {
//		nameElement.sendKeys(name);
		js.executeScript("arguments[0].setAttribute('value', '" + name +"')", nameElement);
	}
	
	public void org(String org, JavascriptExecutor js) {
//		orgElement.sendKeys(org);
		js.executeScript("arguments[0].setAttribute('value', '" + org +"')", orgElement);
	}
	
	public String phn(String phn, JavascriptExecutor js) {
		phnElement.clear();
//		phnElement.sendKeys(phn);
		js.executeScript("arguments[0].setAttribute('value', '" + phn +"')", phnElement);
		
		return phnElement.getCssValue("color");
	}
	
	public String mail(String mail, JavascriptExecutor js) {
		mailElement.clear();
//		mailElement.sendKeys(mail);
		js.executeScript("arguments[0].setAttribute('value', '" + mail +"')", mailElement);
		
		return mailElement.getCssValue("color");
	}
	
	@FindBy(xpath = "//header[1]/div[2]/div/form/div[5]/select") WebElement orgSizeElement;
	
	public void orgSizeSelect() {
		Select select = new Select(orgSizeElement);
		select.selectByVisibleText("10001+");
	}
	
	@FindBy(xpath = "//header[1]/div[2]/div/form/div[6]/select") WebElement interestedInElement;
	
	public void interestedInSelect() {
		Select select = new Select(interestedInElement);
		select.selectByVisibleText("Taking a demo");
	}
	
	@FindBy(xpath = "//header[1]/div[2]/div/form/button") WebElement scheduleADemoElement;
	
	public boolean scheduleADemoVisibility() {
		return scheduleADemoElement.isEnabled();
	}
	
	
	public void scheduleADemoClick(JavascriptExecutor js) {
//		scheduleADemoElement.click();
		js.executeScript("arguments[0].click()", scheduleADemoElement);
	}
	
	@FindBy(xpath = "(//div[@class='text-center']/div)[1]") WebElement thankYouElement;
	
	public String successMessage(WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(thankYouElement));
		return thankYouElement.getText();
	}
	
	
	
}
