package Utilities;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import factory.BaseClass;


public class testListener implements ITestListener {
	
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	int  i = 1;
	
	public void onStart(ITestContext context) {
		try {
			properties = BaseClass.getProperties();
		} catch (IOException e) {
		}
		logger = BaseClass.getLogger1();
	 }
	
	public void onTestStart(ITestResult result) {
		logger.info("*********** "+result.getName()+ " Test started **********");
	}

	public void onTestSuccess(ITestResult result) {
	    logger.info(result.getName()+ " Test got passed");
	}

	public void onTestFailure(ITestResult result) {
		logger.info(result.getName()+ " Test got failed");
	}

	public void onTestSkipped(ITestResult result) {
		logger.info( result.getName()+ " Test got skipped");
	}

	public void onFinish(ITestContext context) {
		logger.info("closing the browser");
	}

}
