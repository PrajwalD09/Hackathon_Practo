package stepDefinitionFiles;

import java.io.IOException;
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
import factory.BaseClass;
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
	public void navigate_to_practo() throws InterruptedException, IOException 
	{
		//Setting up the drivers
		driver = Hooks.getDriver();
		properties = Hooks.getProperties();
		logger = Hooks.getLogger();
		
		//Navigating to Practo 
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		BaseClass.screenShot("Navigated to Practo");
		homePOM = new HomePage(driver);
		sa = new SoftAssert();
		
		TimeUnit.SECONDS.sleep(3);
		Assert.assertTrue(homePOM.logo());
		
		logger.info("Navigated to PRACTO Homepage");
		
	}

	@Given("enter the search fields")
	public void enter_the_search_fields() throws InterruptedException, IOException {
		logger.info("Entering the search data");
		
		//Selecting City
		boolean flag1 = homePOM.selectCity();
		Assert.assertEquals(true, flag1);
		logger.info("Entered the City name");

		//Selcting Speciality
		boolean flag2 = homePOM.selectSpeciality();
		Assert.assertEquals(true, flag2);
		logger.info("Entered the Speciality name");
		
		logger.info("navigating to the doctors page");
	}

	@When("apply all the filters")
	public void apply_all_the_filters() throws InterruptedException, IOException 
	{
		//Applying filters
		logger.info("applying the filters");		
		doctorsPOM = new Doctors(driver);
		
		while(true) 
		{
			TimeUnit.SECONDS.sleep(2);
			doctorsPOM.patientStoriesFilter();
			logger.info("Applied Patient Stories");
			
			TimeUnit.SECONDS.sleep(1);
			doctorsPOM.expFilter();
			logger.info("Applied Experience filter");
			
			TimeUnit.SECONDS.sleep(1);
			doctorsPOM.allFilter();
			logger.info("Applied All Filters");
			
			TimeUnit.SECONDS.sleep(1);	
			int noOfDoc = doctorsPOM.noOfDoc();
			
			//Check if doctors are greater than 5
			if(noOfDoc >= 5) {
				logger.info("Doctors are greater than 5");
				break;
			}
			
			TimeUnit.SECONDS.sleep(1);
			logger.info("Clicked reset button");
			doctorsPOM.reset();
		}
		
		doctorsPOM.sort();
		BaseClass.screenShot("Filters Applied");
		logger.info("Sorted the doctors list");
		
		Assert.assertTrue(true);
	
	}

	@Then("get the details of first five doctors")
	public void get_the_details_of_first_five_doctors() throws InterruptedException 
	{
		logger.info("Getting the doctors details");
		
		if(doctorsPOM.doctorsNames() == null || doctorsPOM.doctorsField() == null || doctorsPOM.doctorsExp() == null || doctorsPOM.doctorsPracticeLoc() == null){
			logger.error("Failed getting the doctors details");
			Assert.fail();
		}
		
		//Storing the doctor details
		String[] names = doctorsPOM.doctorsNames();
		String[] fields = doctorsPOM.doctorsField();
		String[] experience = doctorsPOM.doctorsExp(); 
		String[] location = doctorsPOM.doctorsPracticeLoc();
				
		ExcelUtils.setData(names, fields, experience, location);
		
		System.out.println("--------------- Doctors --------------------");
		System.out.println("No. of Doctors are : " + doctorsPOM.noOfDoc());
		System.out.println("");
		
		for(int i=0; i<5; i++) 
		{
			System.out.println(i+1 + ". " + names[i] + "\n" + fields[i] + "\n" + experience[i] + "\n" + location[i]);
			System.out.println("");
		}
		
		System.out.println("-----------------------------------------------");
		logger.info("printing the details in the excel");
		Assert.assertTrue(true);
	}

}

