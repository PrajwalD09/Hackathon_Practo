package stepDefinitionFiles;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POM_files.Doctors;
import POM_files.HomePage;
import POM_files.Surgeries;
import Utilities.ExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GettingSurgeriesList {
	WebDriver driver;
	Properties properties;
	Logger logger;
	HomePage homePOM;
	SoftAssert sa;
	Doctors doctorsPOM;
	Surgeries surgeriesPOM;
	JavascriptExecutor js;

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
	
	@When("surgeries is clicked")
	public void surgeries_is_clicked() {
	    // Write code here that turns the phrase above into concrete actions
		driver = Hooks.getDriver();
		logger = Hooks.getLogger();
		doctorsPOM = new Doctors(driver);
		logger.info("navigating to the surgeries page");
		
		boolean flag = doctorsPOM.surgeriesClick();
		Assert.assertTrue(flag);
	}

	@Then("the surgeries list should be shown and list has to be retrieved")
	public void the_surgeries_list_should_be_shown_and_list_has_to_be_retrieved() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		surgeriesPOM = new Surgeries(driver);
		logger.info("scrolling down to the surgeries");
		js = (JavascriptExecutor)driver;
		surgeriesPOM.scrollDown(js);
		
		String[] surgeriesList = surgeriesPOM.surgeriesList();
		
		if(surgeriesList == null) {
			Assert.fail();
		}
		else {
			Assert.assertTrue(true);;
		}
		
		
		ExcelUtils.writeIntoExcel(surgeriesPOM.surgeriesList());
		logger.info("printing the surgeries list in the excel");
		
		TimeUnit.SECONDS.sleep(3);
	}



}
