package runnerFile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class)
@CucumberOptions( 
	tags = "", 
//	features = "C:\\Users\\2318520\\eclipse-workspace\\Hackathon_Practo\\features", 
	features = "C:\\Users\\2318520\\eclipse-workspace\\Hackathon_Practo\\features\\TakingDemo.feature",
//	features = "C:\\Users\\2318520\\eclipse-workspace\\Hackathon_Practo\\features\\FindingSurgeriesList.feature",
	glue = "stepDefinitionFiles",
	plugin = {"pretty","html:reports/CucumberReport.html", 
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	dryRun = false,
	monochrome = true,
	publish = true
	)

public class TestRunner extends AbstractTestNGCucumberTests {

}
