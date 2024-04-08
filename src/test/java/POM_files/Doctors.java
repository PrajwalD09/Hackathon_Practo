package POM_files;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Doctors extends BasePage {
		
	public Doctors(WebDriver driver) {
		super(driver);
	}
	
	//-------------------------------------------------------------------------------------------
	
	@FindBy(xpath="//*[@data-qa-id = 'doctor_review_count_section']") WebElement pstories;
	@FindBy(xpath="//*[@class=\"c-dropdown__list__item\" and @tabindex=\"0\"]") List<WebElement> dropdown;
	@FindBy(xpath="//*[text()=\"Experience\"]") WebElement Experience;
	
	public int getRandomIndex(int limit) throws InterruptedException 
	{
		
		if(noOfDoc() <= 100) {
			limit = 1;
		}
		
		Random r = new Random();
		int randomIndex = r.nextInt(limit);
		return randomIndex;

	}

	public void patientStoriesFilter() throws InterruptedException 
	{
		TimeUnit.SECONDS.sleep(2);

		if(pstories.isDisplayed()) 
		{
			pstories.click();	
			TimeUnit.SECONDS.sleep(2);

		}

		int limit = dropdown.size();
		int randomStoryIndex = getRandomIndex(limit);
		
		if(noOfDoc() <= 20) {
			randomStoryIndex = 0;
		}
		WebElement stories = dropdown.get(randomStoryIndex);

		stories.click();

	}
 
	public void expFilter() throws InterruptedException 
	{
		TimeUnit.SECONDS.sleep(2);
		
		Experience.click();
		
		TimeUnit.SECONDS.sleep(2);

		int limit = dropdown.size();
		int randomExpIndex = getRandomIndex(limit);
		
		if(noOfDoc() <= 20) {
			randomExpIndex = 1;
		}

		WebElement exp = dropdown.get(randomExpIndex);

		exp.click();

	}

	@FindBy(xpath="//*[text()=\"All Filters\"]") WebElement allfilters;
	@FindBy(xpath="//*[@class=\"c-filter__select--radio u-d-inlineblock u-valign--middle u-pos-rel\"]") List<WebElement> filtersList;

	public void allFilter() throws InterruptedException 
	{
		TimeUnit.SECONDS.sleep(2);
		
		allfilters.click();
		
		TimeUnit.SECONDS.sleep(2);

		int randomFeeIndex = getRandomIndex(3);
		
		if(noOfDoc() <= 50) {
			randomFeeIndex = 1;
		}
	    WebElement fees = filtersList.get(randomFeeIndex);
	    fees.click();

	    TimeUnit.SECONDS.sleep(2);

	    allfilters.click();

	    int randomIndexavailabilty = getRandomIndex(3)+4; 
	    
	    if(noOfDoc() <= 50) {
	    	randomIndexavailabilty = 7;
		}
	    WebElement avail = filtersList.get(randomIndexavailabilty);
	    
	    TimeUnit.SECONDS.sleep(2);
	    avail.click();

	}
	
	@FindBy(xpath = "//button[@data-qa-id='Reset_Filters']") WebElement resetButton;
	public void reset() {

		if(resetButton.isDisplayed()) {
			resetButton.click();
		}

	}
	
	
	@FindBy(xpath="//*[text()=\"Relevance\"]") WebElement sort;
	
	public void sort() throws InterruptedException {

		sort.click();
		int limit = dropdown.size();
		
		int sortIndex = getRandomIndex(limit);
		WebElement sort = dropdown.get(sortIndex);
		sort.click();

	}

	@FindBy(xpath="//*[@class=\"u-xx-large-font u-bold\"]") WebElement docNums;

	public int noOfDoc() throws InterruptedException {

		TimeUnit.SECONDS.sleep(5);
		String doctorNumbersStr = docNums.getText();
		System.out.println(doctorNumbersStr);

		int doctors = Integer.parseInt(doctorNumbersStr.substring(0,doctorNumbersStr.indexOf(' ')));
		System.out.println(doctors);

		return doctors;

	}
	
	@FindBy(xpath="//*[@class=\"doctor-name\"]") List<WebElement> doctorsNameList;

	public String[] doctorsNames() throws InterruptedException {
		
		String[] doctorNamesArr = new String[5];

		for(int i=0; i<doctorNamesArr.length; i++) 
		{
			String doctorName = doctorsNameList.get(i).getText();
			System.out.println(doctorName);
			doctorNamesArr[i] = doctorName;
		}	
		
		return doctorNamesArr;
		
	}
	
	@FindBy(xpath = "//*[@data-qa-id='doctor_experience']/parent::div/div/span") List<WebElement> doctorsFieldList;
	
	public String[] doctorsField() 
	{
		String[] fields = new String[5];
		for(int i=0;i<5;i++) {
			fields[i] = doctorsFieldList.get(i).getText();
		}
		return fields;
	}
	
	@FindBy(xpath = "//*[@data-qa-id='doctor_experience']") List<WebElement> doctorsExpList;
	
	public String[] doctorsExp() 
	{
		String[] exp = new String[5];
		for(int i=0;i<5;i++) {
			exp[i] = doctorsExpList.get(i).getText();
		}
		return exp;
	}
	
	@FindBy(xpath = "//*[@data-qa-id='practice_locality']/parent::a") List<WebElement> doctorsPracticeLocalityList;
	
	public String[] doctorsPracticeLoc() 
	{
		String[] loc = new String[5];
		for(int i=0;i<5;i++) {
			loc[i] = doctorsPracticeLocalityList.get(i).getText();
		}
		return loc;
	}
	
	
//	@FindBy(xpath = "//*[text()='Surgeries']") WebElement surgeriesElement;
	@FindBy(xpath = "//*[@id='root']/div/div/div[1]/div[1]/div[2]/div/div[2]/div[5]/a/div[1]") WebElement surgeriesElement;
	
	public void surgeriesClick( JavascriptExecutor js) throws InterruptedException {
//		if(surgeriesElement.isDisplayed()) {
//			surgeriesElement.click();
//			return true;
//		}
//		return false;
		
		TimeUnit.SECONDS.sleep(4);
//		surgeriesElement.click();
		js.executeScript("arguments[0].click()", surgeriesElement);
		
	}
	//------------------------------------------------------------------------------
	
//	@FindBy(xpath = "//span[text()='All Filters']") WebElement allFiltersDD;
//	@FindBy(xpath = "//span[text()='Above ₹500']") WebElement priceElement;
//	@FindBy(xpath = "(//span[text()='Available Today'])[1]") WebElement availabilityElement;
//	
//	public void allFilter() throws InterruptedException {
//		allFiltersDD.click();
//		priceElement.click();
//		Thread.sleep(1000);
//		allFiltersDD.click();
//		availabilityElement.click();
//	}
	
//	@FindBy(xpath = "//span[text()='Patient Stories']") WebElement patientStoriesDD;
//	@FindBy(xpath = "//span[contains(text(),'10+ Patient')]") WebElement patientStoriesElement;
//	
//	public void patientStoriesFilter() {
//		patientStoriesDD.click();
//		patientStoriesElement.click();
//	}
//	
//	@FindBy(xpath = "//span[text()='Experience']") WebElement expDD;
//	@FindBy(xpath = "//span[contains(text(),'5+ Years')]") WebElement expElement;
//	
//	public void expFilter() {
//		expDD.click();
//		expElement.click();
//	}
//	
//	@FindBy(xpath = "//span[text()='Relevance']") WebElement sortDD;
//	@FindBy(xpath = "//span[text()='Experience - High to Low']") WebElement sortElement;
//	
//	public void sorting() {
//		sortDD.click();
//		sortElement.click();
//	}
//	
//	@FindBy(className = "doctor-name") List<WebElement> doctorsNamesList;
//	
//	public String[] doctorsNames() {
//		String[] names = new String[6];
//		for(int i=0;i<6;i++) {
//			names[i] = doctorsNamesList.get(i).getText();
//		}
//		return names;
//	}
//	
		
	
	
	
	
}
