package factory;
 
import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class BaseClass {
 
	static WebDriver driver;
	static Properties properties;
	static Logger logger;
	
	public static void initilizeBrowser() throws IOException {
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
			System.out.println("executing remotely");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// browser
			switch (getProperties().getProperty("browser").toLowerCase()) {
				case "chrome":
					capabilities.setBrowserName("chrome");
					break;
				case "edge":
					capabilities.setBrowserName("MicrosoftEdge");
					break;
				default:
					capabilities.setBrowserName("firefox");
					break;
			}
			URL gridUrl = new URL("http://localhost:4444/wd/hub");
			driver = new RemoteWebDriver(gridUrl, capabilities);
			System.out.println("driver created");
			
 
		} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			logger = getLogger1();
			String browser = properties.getProperty("browser");
			
		    switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				System.out.println("running through chrome...");
				logger.info("running through chrome");
				break;
			case "edge":
				driver = new EdgeDriver();			
				System.out.println("running through edge...");
				logger.info("runnnig through edge");
			default:
				break;
			}
		}
		driver.manage().deleteAllCookies();
		logger.info("deleting all the cookies");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("applying the implicit wait");
		
	}
 
	public static WebDriver getDriver() {
		return driver;
	}
 
	public static Properties getProperties() throws IOException {
		String propertyFile = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		FileReader file = new FileReader(propertyFile);
		properties = new Properties();
		properties.load(file);
		return properties;
	}
	
	public static Logger getLogger1() {
		logger = LogManager.getLogger();
		return logger;
	}
	
	static int i=1;
	public static String screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\ScreenShots\\"+i+"ss.png";
	    File trgFile = new File(path);
	    i++;
	    FileUtils.copyFile(src, trgFile);
	    return path;
	}
	
	public static void openExtentReport() throws IOException {
      // Specify the path to your ExtentReports HTML file
      String extentReportFilePath = System.getProperty("user.dir")+ "//reports//myReport.html";

          File reportFile = new File(extentReportFilePath);
          // Check if the file exists
          if (reportFile.exists()) {
              // Open the file in the default web browser
              Desktop.getDesktop().browse(reportFile.toURI());
          } else {
              System.out.println("ExtentReports file not found at: " + extentReportFilePath);
          }
  }
 
}
