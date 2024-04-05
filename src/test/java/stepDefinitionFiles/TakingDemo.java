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
import POM_files.demo;
import POM_files.surgeries;
import Utilities.ExcelUtils;
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
	surgeries surgeriesPOM;
	JavascriptExecutor js;
	demo demoPOM;
	
//	@Given("navigate to practo")
//	public void navigate_to_practo() {
//		driver = hooks.getDriver();
//		properties = hooks.getProperties();
//		logger = hooks.getLogger();
//		driver.get("https://www.practo.com/");
//		driver.manage().window().maximize();
//		homePOM = new HomePage(driver);
//		sa = new SoftAssert();
//		//Assert.assertTrue(practoPOM.logo());
//		
//	}

	@When("clicked on for Corporates")
	public void clicked_on_for_corporates() {
	    // Write code here that turns the phrase above into concrete actions
		driver = hooks.getDriver();
		js = (JavascriptExecutor)driver;
		surgeriesPOM = new surgeries(driver);
		demoPOM = new demo(driver);
		logger = hooks.getLogger();
		surgeriesPOM.scrollTop(js);
		surgeriesPOM.corporate();
		logger.info("navigating to the corporate");
		
	}
	 
	@Then("health and wellnes plans should be clicked")
	public void health_and_wellnes_plans_should_be_clicked() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("selecting heath and wellness");
		surgeriesPOM.healthNWellness(js);
	}
	 
	@When("filled in the invalid details in the form")
	public void filled_in_the_invalid_details_in_the_form() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("entering name and organisation in the demo form");
		demoPOM.name(ExcelUtils.getData(1,0));
		
		TimeUnit.SECONDS.sleep(5);
		demoPOM.org(ExcelUtils.getData(1, 1));
		logger.info("choosing the organization size and interested option");
		
		TimeUnit.SECONDS.sleep(5);
		demoPOM.orgSizeSelect();
		
		TimeUnit.SECONDS.sleep(5);
		demoPOM.interestedInSelect();
		logger.info("verifying the phone field by giving invalid input format");

		String invalidEntryColorRGB = "rgba(159, 58, 56, 1)";
        
		for(int i=1; i<=3; i++) {
			logger.info("verifying the email field with the invalid input no : " + i);
			Assert.assertEquals(demoPOM.phn(ExcelUtils.getData(i, 2)), invalidEntryColorRGB);
			TimeUnit.SECONDS.sleep(5);
		}
		
		
//		TimeUnit.SECONDS.sleep(5);
//		Assert.assertEquals(demoPOM.phn(ExcelUtils.getData(1, 2)), invalidEntryColorRGB);
//		logger.info("using boundary value ananlysis to verify the phone field with different input values");
//		
//		TimeUnit.SECONDS.sleep(5);
//		Assert.assertEquals(demoPOM.phn(ExcelUtils.getData(2, 2)), invalidEntryColorRGB);
//		TimeUnit.SECONDS.sleep(5);
//		Assert.assertEquals(demoPOM.phn(ExcelUtils.getData(3, 2)), invalidEntryColorRGB);
//		logger.info("verifying the email field with the invalid inputs");
		
		TimeUnit.SECONDS.sleep(5);
		
		for(int i=1; i<=4; i++) {
			Assert.assertEquals(demoPOM.mail(ExcelUtils.getData(i, 4)), invalidEntryColorRGB);
			TimeUnit.SECONDS.sleep(5);
		}
//		Assert.assertEquals(demoPOM.mail(ExcelUtils.getData(1, 4)), invalidEntryColorRGB);
//		TimeUnit.SECONDS.sleep(5);
//		Assert.assertEquals(demoPOM.mail(ExcelUtils.getData(2, 4)), invalidEntryColorRGB);
//		TimeUnit.SECONDS.sleep(5);
//		Assert.assertEquals(demoPOM.mail(ExcelUtils.getData(3, 4)), invalidEntryColorRGB);
//		TimeUnit.SECONDS.sleep(5);
//		Assert.assertEquals(demoPOM.mail(ExcelUtils.getData(4, 4)), invalidEntryColorRGB);
//		TimeUnit.SECONDS.sleep(5);
		
	}
	 
	@Then("validate if schedule a demo button is not disabled")
	public void validate_if_schedule_a_demo_button_is_not_disabled() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("verifying the visibility of schedule a demo visibilty");
		Assert.assertFalse(demoPOM.scheduleADemoVisibility());
	}
	 
	@When("filled in the valid details in the form")
	public void filled_in_the_valid_details_in_the_form() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("verifying with the valid inputs");
		
		demoPOM.name(ExcelUtils.getData(1,0));
		
		TimeUnit.SECONDS.sleep(5);
		demoPOM.org(ExcelUtils.getData(1, 1));
		logger.info("choosing the organization size and interested option");
		
		TimeUnit.SECONDS.sleep(5);
		demoPOM.orgSizeSelect();
		
		TimeUnit.SECONDS.sleep(5);
		demoPOM.interestedInSelect();
		logger.info("verifying the phone field by giving invalid input format");
		
		String invalidEntryColorRGB = "rgba(159, 58, 56, 1)";
		
		for(int i=1; i<=4; i++) {
			logger.info("verifying the mail field with the valid input : " + i);
			Assert.assertNotEquals(demoPOM.phn(ExcelUtils.getData(i, 3)), invalidEntryColorRGB);
			TimeUnit.SECONDS.sleep(5);
		}
		
//		TimeUnit.SECONDS.sleep(5);
//		Assert.assertNotEquals(demoPOM.phn(ExcelUtils.getData(1, 3)), "rgba(159, 58, 56, 1)");
//		TimeUnit.SECONDS.sleep(5);
//		Assert.assertNotEquals(demoPOM.phn(ExcelUtils.getData(2, 3)), "rgba(159, 58, 56, 1)");
//		TimeUnit.SECONDS.sleep(5);
//		Assert.assertNotEquals(demoPOM.phn(ExcelUtils.getData(3, 3)), "rgba(159, 58, 56, 1)");
//		TimeUnit.SECONDS.sleep(5);
//		Assert.assertNotEquals(demoPOM.phn(ExcelUtils.getData(4, 3)), "rgba(159, 58, 56, 1)");
//		logger.info("verifying the mail field with the valid inputs");
//		TimeUnit.SECONDS.sleep(5);
		
		Assert.assertNotEquals(demoPOM.mail(ExcelUtils.getData(1, 5)), "rgba(159, 58, 56, 1)");
		TimeUnit.SECONDS.sleep(5);
	
	}
	
	@Then("validate if Schedule a demo button is disabled")
	public void validate_if_schedule_a_demo_button_is_disabled() throws InterruptedException {
		logger.info("verifying the visibility of schedule a demo visibilty");
		Assert.assertTrue(demoPOM.scheduleADemoVisibility());
		demoPOM.scheduleADemoClick();
		Thread.sleep(20000);
		logger.info("getting the success message");
	}
	
	@Then("verify the Thankyou msg")
	public void verify_the_thankyou_msg() throws InterruptedException {
		logger.info("verifying the success message");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String msg = demoPOM.successMessage(wait);
		Assert.assertTrue(msg.equalsIgnoreCase("thank you"));
		sa = new SoftAssert();
		sa.assertAll();
	}
	 
}
