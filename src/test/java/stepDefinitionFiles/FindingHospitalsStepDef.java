package stepDefinitionFiles;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POM_files.Demo;
import POM_files.Doctors;
import POM_files.HomePage;
import POM_files.Surgeries;
import Utilities.ExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindingHospitalsStepDef {
	
	WebDriver driver;
	Properties properties;
	Logger logger;
	HomePage homePOM;
	Doctors doctorsPOM;
	Surgeries surgeriesPOM;
	Demo demoPOM;
	SoftAssert sa;
	JavascriptExecutor js;
	
	@Given("navigate to practo")
	public void navigate_to_practo() throws InterruptedException {
		driver = Hooks.getDriver();
		properties = Hooks.getProperties();
		logger = Hooks.getLogger();
		
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		homePOM = new HomePage(driver);
		sa = new SoftAssert();
		
		TimeUnit.SECONDS.sleep(3);
		Assert.assertTrue(homePOM.logo());
		
		logger.info("Navigated to PARCTO Homepage");
		
	}

	@Given("enter the search fields")
	public void enter_the_search_fields() throws InterruptedException {
		logger.info("Entering the search data");
//		sa = new SoftAssert();
		
		boolean flag1 = homePOM.selectCity();
//		sa.assertEquals(true, flag1);
		Assert.assertEquals(true, flag1);

		boolean flag2 = homePOM.selectSpeciality();
//		sa.assertEquals(true, flag2);
		Assert.assertEquals(true, flag2);
		
		logger.info("navigating to the doctors page");
		//Assert.assertTrue(driver.getTitle().contains("Cardiologists"));
	}

	@When("apply all the filters")
	public void apply_all_the_filters() throws InterruptedException 
	{
		logger.info("applying the filters");
//		homePOM.typeSelect();
		
		doctorsPOM = new Doctors(driver);
		
		while(true) 
		{
//			TimeUnit.SECONDS.sleep(1);
			doctorsPOM.patientStoriesFilter();
//			TimeUnit.SECONDS.sleep(2);
			doctorsPOM.expFilter();
//			TimeUnit.SECONDS.sleep(3);
			doctorsPOM.allFilter();
			TimeUnit.SECONDS.sleep(3);
			
			int noOfDoc = doctorsPOM.noOfDoc();
			
			if(noOfDoc >= 5) {
				break;
			}
			
			TimeUnit.SECONDS.sleep(1);
			doctorsPOM.reset();
		}
		
		Assert.assertTrue(true);
		
		doctorsPOM.sort();
		logger.info("applied all the filters");
		
	}

	@Then("get the details of first five doctors")
	public void get_the_details_of_first_five_doctors() throws InterruptedException 
	{
		logger.info("getting the doctors details");
		
		if(doctorsPOM.doctorsNames() == null || doctorsPOM.doctorsField() == null || doctorsPOM.doctorsExp() == null || doctorsPOM.doctorsPracticeLoc() == null){
			logger.info("failed getting the doctors details");
			Assert.fail();
		}
		
		ExcelUtils.setData(doctorsPOM.doctorsNames(), doctorsPOM.doctorsField(), doctorsPOM.doctorsExp(), doctorsPOM.doctorsPracticeLoc());
		Assert.assertTrue(true);
		logger.info("printing the details in the excel");
	}

}

