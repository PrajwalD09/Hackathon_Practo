package stepDefinitionFiles;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class hooks {
	
	static WebDriver driver;
	static Logger logger;
	static Properties properties;
    static int i = 1;
	
	@BeforeAll
	public static void beforeAll() throws IOException {
		BaseClass.initilizeBrowser();
		driver = BaseClass.getDriver();
		logger = BaseClass.getLogger1();
		properties = BaseClass.getProperties();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Properties getProperties() {
		return properties;
	}
	
	public static Logger getLogger() {
		return logger;
	}
	
	public static void openExtentReport() throws IOException {
        // Specify the path to your ExtentReports HTML file
        String extentReportFilePath = System.getProperty("user.dir")+ "//test-output//SparkReport//Spark.html";
 
            File reportFile = new File(extentReportFilePath);
            // Check if the file exists
            if (reportFile.exists()) {
                // Open the file in the default web browser
                Desktop.getDesktop().browse(reportFile.toURI());
            } else {
                System.out.println("ExtentReports file not found at: " + extentReportFilePath);
            }
    }
	
	@AfterStep
    public static void tearDown(Scenario scenario) throws IOException {
 
       if(!scenario.isFailed()) {
    	   TakesScreenshot ts = (TakesScreenshot)driver;
           byte[] fileContent = ts.getScreenshotAs(OutputType.BYTES);
           scenario.attach(fileContent, "image/png", scenario.getName());  
       }
         
    }
	
	@AfterAll
	public static void afterAll() throws IOException {
		driver.quit();
		openExtentReport();
	}
	
}
