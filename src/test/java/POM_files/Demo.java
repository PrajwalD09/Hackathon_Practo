package POM_files;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//public class Demo extends BasePage {
//	
//	//WithOut JS Executor	
//	public Demo(WebDriver driver) {
//		super(driver);
//	}
//	
//	@FindBy(xpath = "(//input)[1]") WebElement nameElement;
//	@FindBy(xpath = "(//input)[2]") WebElement orgElement;
//	@FindBy(xpath = "(//input)[3]") WebElement phnElement;
//	@FindBy(xpath = "(//input)[4]") WebElement mailElement;
//	
//	
//	public void name(String name) {
//			nameElement.sendKeys(name);
//	}
//	
//	public void org(String org) {
//		orgElement.sendKeys(org);
//	}
//	
//	public String phn(String phn) {
//		phnElement.clear();
//		phnElement.sendKeys(phn);
//		
//		return phnElement.getCssValue("color");
//	}
//	
//	public String mail(String mail) {
//		mailElement.clear();
//		mailElement.sendKeys(mail);
//		
//		return mailElement.getCssValue("color");
//	}
//	
//	@FindBy(xpath = "//header[1]/div[2]/div/form/div[5]/select") WebElement orgSizeElement;
//	
//	public void orgSizeSelect() throws InterruptedException {
//		Select select = new Select(orgSizeElement);
//		select.selectByVisibleText("10001+");
//		
//	}
//	
//	@FindBy(xpath = "//header[1]/div[2]/div/form/div[6]/select") WebElement interestedInElement;
//	
//	public void interestedInSelect() {
//		Select select = new Select(interestedInElement);
//		select.selectByVisibleText("Taking a demo");
//	}
//	
//	@FindBy(xpath = "//header[1]/div[2]/div/form/button") WebElement scheduleADemoElement;
//	
//	public boolean scheduleADemoVisibility() {
//		return scheduleADemoElement.isEnabled();
//	}
//	
//	
//	public void scheduleADemoClick() {
//		scheduleADemoElement.click();
//	}
//	
//	@FindBy(xpath = "(//div[@class='text-center']/div)[1]") WebElement thankYouElement;
//	
//	public String successMessage(WebDriverWait wait) throws InterruptedException {
//		wait.until(ExpectedConditions.visibilityOf(thankYouElement));
//		return thankYouElement.getText();
//	}
//	
//}


// -------------------------------- WITH JS EXECUTOR -------------------------------------
//
public class Demo extends BasePage {
	
	//With JS Executor
	JavascriptExecutor js;
	
	public Demo(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor)driver;
	}
	
	@FindBy(xpath = "(//input)[1]") WebElement nameElement;
	@FindBy(xpath = "(//input)[2]") WebElement orgElement;
	@FindBy(xpath = "(//input)[3]") WebElement phnElement;
	@FindBy(xpath = "(//input)[4]") WebElement mailElement;
	

	public void name(String name) throws InterruptedException 
	{
		Thread.sleep(5000);
//		js.executeScript("arguments[0].setAttribute('value', '" + name +"')", nameElement);
		js.executeScript("arguments[0].value = arguments[1];", nameElement, name);
		
	}
	
	public void org(String org) throws InterruptedException 
	{
		Thread.sleep(5000);
//		js.executeScript("arguments[0].setAttribute('value', '" + org +"')", orgElement);
		js.executeScript("arguments[0].value = arguments[1];", orgElement, org);
	}
	
	public String phn(String phn) throws InterruptedException {

		//---------------- JS ---------------------
		Thread.sleep(5000);
		js.executeScript("arguments[0].setAttribute('value', '" + phn +"')", phnElement);
//		js.executeScript("arguments[0].value = arguments[1];", phnElement, phn);
		
		Thread.sleep(5000);
//		js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', { key: 'Enter' }));", phnElement);
		
		return phnElement.getCssValue("color");
		//---------------- JS ---------------------
		
////		js.executeScript("arguments[0].value = '';", phnElement);
//		TimeUnit.SECONDS.sleep(3);
//		phnElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//		TimeUnit.SECONDS.sleep(3);
//		js.executeScript("arguments[0].setAttribute('value', '" + phn +"')", phnElement);
////		js.executeScript("arguments[0].value = arguments[1];", phnElement, phn);
//		
//		TimeUnit.SECONDS.sleep(3);
//		js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', { key: 'Enter' }));", phnElement);
//		
//		return phnElement.getCssValue("color");
	}
		
	public String mail(String mail) throws InterruptedException {
		
		//---------------- JS ---------------------
		Thread.sleep(5000);
		js.executeScript("arguments[0].setAttribute('value', '" + mail +"')", mailElement);
//		js.executeScript("arguments[0].value = arguments[1];", mailElement, mail);
		Thread.sleep(5000);
//		js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', { key: 'Enter' }));", mailElement);

		return mailElement.getCssValue("color");
		//---------------- JS ---------------------
		
//		--------------------------------------------------------------------------
		
//		js.executeScript("arguments[0].value = '';", mailElement);
//		TimeUnit.SECONDS.sleep(3);
////		js.executeScript("arguments[0].setAttribute('value', '" + mail +"')", mailElement);
//		js.executeScript("arguments[0].value = arguments[1];", mailElement, mail);
//		TimeUnit.SECONDS.sleep(3);
//		js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', { key: 'Enter' }));", mailElement);
//
//		return mailElement.getCssValue("color");
	}
	
	@FindBy(xpath = "//header[1]/div[2]/div/form/div[5]/select") WebElement orgSizeElement;
	
	public void orgSizeSelect() throws InterruptedException {

		Thread.sleep(5000);
		int index = 1; // Index of the option you want to select
		js.executeScript("arguments[0].selectedIndex = " + index + ";", orgSizeElement);
		
	}
	
	@FindBy(xpath = "//header[1]/div[2]/div/form/div[6]/select") WebElement interestedInElement;
	
	public void interestedInSelect() throws InterruptedException {
		
		Thread.sleep(5000);
		int index = 1;
		js.executeScript("arguments[0].selectedIndex = " + index + ";", interestedInElement);
	}
	
	@FindBy(xpath = "//header[1]/div[2]/div/form/button") WebElement scheduleADemoElement;
	
//	public boolean scheduleADemoVisibility() throws InterruptedException {
//		Thread.sleep(5000);
//		//return scheduleADemoElement.isEnabled();
//		
//		//---------------- JS ---------------------
//		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		myWait.until(ExpectedConditions.visibilityOf(scheduleADemoElement));
//		
//		return scheduleADemoElement.isEnabled();
////		return (boolean) js.executeScript("return arguments[0].isEnabled();", scheduleADemoElement);
//		//---------------- JS ---------------------
//	}
	
	//--------------------- JS ------------------------
	public String scheduleADemoVisibility() throws InterruptedException {
		Thread.sleep(5000);
		
		//---------------- JS ---------------------
//		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		myWait.until(ExpectedConditions.visibilityOf(scheduleADemoElement));
		
		return scheduleADemoElement.getCssValue("background-color");
//		return (boolean) js.executeScript("return arguments[0].isEnabled();", scheduleADemoElement);
	}
	//--------------------- JS ---------------------
	
	
	public void scheduleADemoClick() throws InterruptedException {
		Thread.sleep(5000);
		js.executeScript("arguments[0].click()", scheduleADemoElement);
	}
	
	@FindBy(xpath = "(//div[@class='text-center']/div)[1]") WebElement thankYouElement;
	
//	public String successMessage(WebDriverWait wait) throws InterruptedException {
	public String successMessage() throws InterruptedException {
		Thread.sleep(5000);
//		wait.until(ExpectedConditions.visibilityOf(thankYouElement));
		
		//---------------- JS -------------
		return (String) js.executeScript("return document.getElementByClassname('text-center').innerText;");
//		return thankYouElement.getText();
	}
	

}
	
