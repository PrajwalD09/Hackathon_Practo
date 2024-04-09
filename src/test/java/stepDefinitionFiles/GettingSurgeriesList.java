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
import factory.BaseClass;
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
	
	@When("surgeries is clicked")
	public void surgeries_is_clicked() throws InterruptedException 
	{
		driver = Hooks.getDriver();
		logger = Hooks.getLogger();
		doctorsPOM = new Doctors(driver);
		logger.info("Navigating to the surgeries page");
		
		boolean flag = doctorsPOM.surgeriesClick();
		logger.info("Clicked on Surgeries");
		Assert.assertTrue(flag);
		
//		js = (JavascriptExecutor)driver;
//		doctorsPOM.surgeriesClick(js);
//		Assert.assertTrue(true);
	}

	@Then("the surgeries list should be shown and list has to be retrieved")
	public void the_surgeries_list_should_be_shown_and_list_has_to_be_retrieved() throws IOException, InterruptedException {

		//Getting the Surgeries List
		surgeriesPOM = new Surgeries(driver);
		logger.info("scrolling down to the surgeries");
		js = (JavascriptExecutor)driver;
		surgeriesPOM.scrollDown(js);
		
		TimeUnit.SECONDS.sleep(3);
		
		BaseClass.screenShot("Surgeries List");
		String[] surgeriesList = surgeriesPOM.surgeriesList();
		
		if(surgeriesList == null) {
			Assert.fail();
		}
		else {
			Assert.assertTrue(true);;
		}
		
		System.out.println("----------------- Surgeries List ----------------------");
		for(int i=0; i<surgeriesList.length; i++) {
			System.out.println(i+1 + ". " + surgeriesList[i]);
		}
		System.out.println("-------------------------------------------------------");
		
		ExcelUtils.writeIntoExcel(surgeriesPOM.surgeriesList());
		logger.info("printing the surgeries list in the excel");
		
		TimeUnit.SECONDS.sleep(3);
	}



}
