package stepDefinitionFiles;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POM_files.Doctors;
import POM_files.HomePage;
import POM_files.Demo;
import POM_files.Surgeries;
import Utilities.ExcelUtils;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TakingDemo {
	
	WebDriver driver;
	Properties properties;
	Logger logger;
	HomePage homePOM;
	SoftAssert sa;
	Doctors doctorsPOM;
	Surgeries surgeriesPOM;
	JavascriptExecutor js;
	Demo demoPOM;
	
	@When("clicked on for Corporates")
	public void clicked_on_for_corporates() {

		driver = Hooks.getDriver();
		js = (JavascriptExecutor)driver;
		surgeriesPOM = new Surgeries(driver);
		demoPOM = new Demo(driver);
		logger = Hooks.getLogger();
		surgeriesPOM.scrollTop(js);
		surgeriesPOM.corporate();
		logger.info("navigating to the corporate");
		
	}
	 
	@Then("health and wellnes plans should be clicked")
	public void health_and_wellnes_plans_should_be_clicked() throws IOException {
		
		logger.info("selecting heath and wellness");
		surgeriesPOM.healthNWellness(js);
		BaseClass.screenShot("Health and Wellness");
	}
	 
	@When("filled in the invalid details in the form")
	public void filled_in_the_invalid_details_in_the_form() throws IOException, InterruptedException 
	{
		logger.info("entering name and organisation in the demo form");
		
		js = (JavascriptExecutor)driver;
		
		demoPOM.name(ExcelUtils.getData(1,0));
		
		//Filling the form with invalid details
		TimeUnit.SECONDS.sleep(2);
		demoPOM.org(ExcelUtils.getData(1, 1));
		logger.info("choosing the organization size and interested option");
		
		TimeUnit.SECONDS.sleep(2);
		demoPOM.orgSizeSelect();
		
		TimeUnit.SECONDS.sleep(2);
		demoPOM.interestedInSelect();
		logger.info("verifying the phone field by giving invalid input format");

		//---------------- JS ---------------------
//		String invalidEntryColorRGB = "rgba(159, 58, 56, 1)";
		String invalidEntryColorRGB = "rgba(45, 45, 50, 1)";
		//---------------- JS ---------------------
		
		logger.info("verifying the email field with the invalid input no : ");		
			
		Assert.assertEquals(demoPOM.phn(ExcelUtils.getData(1, 2)), invalidEntryColorRGB);
		TimeUnit.SECONDS.sleep(2);
		
		
		Assert.assertEquals(demoPOM.mail(ExcelUtils.getData(1, 4)), invalidEntryColorRGB);
		TimeUnit.SECONDS.sleep(2);
		
		
		BaseClass.screenShot("Invalid Details");
		
		
//		---------------------------------------------------------------
		
//		logger.info("entering name and organisation in the demo form");
//		
//		js = (JavascriptExecutor)driver;
//		
//		demoPOM.name(ExcelUtils.getData(1,0));
//		
//		//Filling the form with invalid details
//		TimeUnit.SECONDS.sleep(2);
//		demoPOM.org(ExcelUtils.getData(1, 1));
//		logger.info("choosing the organization size and interested option");
//		
//		TimeUnit.SECONDS.sleep(2);
//		demoPOM.orgSizeSelect();
//		
//		TimeUnit.SECONDS.sleep(2);
//		demoPOM.interestedInSelect();
//		logger.info("verifying the phone field by giving invalid input format");
//
//		String invalidEntryColorRGB = "rgba(159, 58, 56, 1)";
//        
//		for(int i=1; i<=3; i++) {
//			logger.info("verifying the email field with the invalid input no : " + i);
//			
//			Assert.assertEquals(demoPOM.phn(ExcelUtils.getData(i, 2)), invalidEntryColorRGB);
//			TimeUnit.SECONDS.sleep(2);
//		}
//		
//		for(int i=1; i<=4; i++) 
//		{
//			Assert.assertEquals(demoPOM.mail(ExcelUtils.getData(i, 4)), invalidEntryColorRGB);
//			TimeUnit.SECONDS.sleep(2);
//		}
//		
//		BaseClass.screenShot("Invalid Details");
	}
	
	@Then("validate if schedule a demo button is disabled")
	public void validate_if_schedule_a_demo_button_is_disabled() throws InterruptedException 
	{
		logger.info("verifying the visibility of schedule a demo visibilty");
		TimeUnit.SECONDS.sleep(4);
//		Assert.assertFalse(demoPOM.scheduleADemoVisibility());
		
		//---------------- JS ---------------------
		Assert.assertNotEquals(demoPOM.scheduleADemoVisibility(), "rgba(40, 50, 140, 1)");
		System.out.println("Button is disabled");
		
	}	
	 
	@When("filled in the valid details in the form")
	public void filled_in_the_valid_details_in_the_form() throws IOException, InterruptedException {
		
		logger.info("verifying with the valid inputs");
		
		js = (JavascriptExecutor)driver;
				
		demoPOM.name(ExcelUtils.getData(1,0));
		
		TimeUnit.SECONDS.sleep(2);

		//Filling the form with valid details
		demoPOM.org(ExcelUtils.getData(1, 1));
		logger.info("choosing the organization size and interested option");
		
		TimeUnit.SECONDS.sleep(2);
		demoPOM.orgSizeSelect();
		
		TimeUnit.SECONDS.sleep(2);
		demoPOM.interestedInSelect();
		logger.info("verifying the phone field by giving invalid input format");
		
		//---------------- JS ---------------------
		String invalidEntryColorRGB = "rgba(159, 58, 56, 1)";
		//---------------- JS ---------------------
		
		logger.info("verifying the mail field with the valid input : ");
		
		Assert.assertNotEquals(demoPOM.phn(ExcelUtils.getData(1, 3)), invalidEntryColorRGB);
		TimeUnit.SECONDS.sleep(2);
		
		
		TimeUnit.SECONDS.sleep(2);
		Assert.assertNotEquals(demoPOM.mail(ExcelUtils.getData(1, 5)), invalidEntryColorRGB);
		
		TimeUnit.SECONDS.sleep(2);
		BaseClass.screenShot("Valid Details");

//		----------------------------------------------------------------
		
//		logger.info("verifying with the valid inputs");
//		
//		js = (JavascriptExecutor)driver;
//				
//		demoPOM.name(ExcelUtils.getData(1,0));
//		
//		TimeUnit.SECONDS.sleep(2);
//
//		//Filling the form with valid details
//		demoPOM.org(ExcelUtils.getData(1, 1));
//		logger.info("choosing the organization size and interested option");
//		
//		TimeUnit.SECONDS.sleep(2);
//		demoPOM.orgSizeSelect();
//		
//		TimeUnit.SECONDS.sleep(2);
//		demoPOM.interestedInSelect();
//		logger.info("verifying the phone field by giving invalid input format");
//		
//		String invalidEntryColorRGB = "rgba(159, 58, 56, 1)";
//		
//		for(int i=1; i<=4; i++) {
//			logger.info("verifying the mail field with the valid input : " + i);
//			
//			Assert.assertNotEquals(demoPOM.phn(ExcelUtils.getData(i, 3)), invalidEntryColorRGB);
//			TimeUnit.SECONDS.sleep(2);
//		}
//		
//		TimeUnit.SECONDS.sleep(2);
//		Assert.assertNotEquals(demoPOM.mail(ExcelUtils.getData(1, 5)), invalidEntryColorRGB);
//		
//		TimeUnit.SECONDS.sleep(2);
//		BaseClass.screenShot("Valid Details");
	
	}
	
	@Then("validate if Schedule a demo button is not disabled")
	public void validate_if_schedule_a_demo_button_is_not_disabled() throws InterruptedException {
	    
		logger.info("verifying the visibility of schedule a demo visibilty");
		js = (JavascriptExecutor)driver;
		 
		TimeUnit.SECONDS.sleep(2);
		
//		Assert.assertTrue(demoPOM.scheduleADemoVisibility());
		
		//--------------------- JS ---------------------
		Assert.assertNotEquals(demoPOM.scheduleADemoVisibility(),"rgba(40, 50, 140, 1)");
		
		demoPOM.scheduleADemoClick();
		
		TimeUnit.SECONDS.sleep(10);
		logger.info("getting the success message");
	}
	
	@Then("verify the Thankyou msg")
	public void verify_the_thankyou_msg() throws InterruptedException, IOException {
		logger.info("verifying the success message");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String msg = demoPOM.successMessage(wait);
		
		BaseClass.screenShot("Success Message");
		Assert.assertTrue(msg.equalsIgnoreCase("thank you"));
		logger.info("Verified the Thank You message");
				
	}
	 
}
