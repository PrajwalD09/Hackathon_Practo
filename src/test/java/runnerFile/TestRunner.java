package runnerFile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class)
@CucumberOptions( 
//	features = "C:\\Users\\2318520\\eclipse-workspace\\Hackathon_Practo\\features", 
//	features = {"C:\\Users\\2318520\\eclipse-workspace\\Hackathon_Practo\\features\\FindingHospitals.feature"},
	
	features = {"C:\\Users\\2318520\\eclipse-workspace\\Hackathon_Practo\\features\\FindingHospitals.feature",
	"C:\\Users\\2318520\\eclipse-workspace\\Hackathon_Practo\\features\\FindingSurgeriesList.feature",
	"C:\\Users\\2318520\\eclipse-workspace\\Hackathon_Practo\\features\\TakingDemo.feature"},
			
//	features = "C:\\Users\\2318520\\eclipse-workspace\\Hackathon_Practo\\features\\TakingDemo.feature",
//	features= {"@target/rerun.txt"},
//	features = "C:\\Users\\2318520\\eclipse-workspace\\Hackathon_Practo\\features\\FindingSurgeriesList.feature",
	glue = "stepDefinitionFiles",
	plugin = {"pretty","html:reports/CucumberReport.html", 
//			"rerun:target/rerun.txt",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	dryRun = false,
	monochrome = true,
	publish = true
//	tags = ""
//	tags = "@smoke and @regression"
	)

public class TestRunner {

}
