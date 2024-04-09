package POM_files;

import java.util.List;
import java.util.NoSuchElementException;
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
		
		if(pstories.isDisplayed()) 
		{
			pstories.click();	
			TimeUnit.SECONDS.sleep(1);

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
//		TimeUnit.SECONDS.sleep(2);
		
		Experience.click();
		
		TimeUnit.SECONDS.sleep(1);

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
//		TimeUnit.SECONDS.sleep(2);
		
		allfilters.click();
		
		TimeUnit.SECONDS.sleep(1);

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
	    
	    TimeUnit.SECONDS.sleep(1);
	    avail.click();

	}
	
	@FindBy(xpath = "//button[@data-qa-id='Reset_Filters']") WebElement resetButton;
	public void reset() {

		if(resetButton.isDisplayed()) {
			resetButton.click();
		}

	}
	
	
	@FindBy(xpath="//*[text()=\"Relevance\"]") WebElement sort;
	@FindBy(xpath = "//span[text()='Experience - High to Low']") WebElement sortElement;
	
	public void sort() throws InterruptedException {

		sort.click();
		
		TimeUnit.SECONDS.sleep(2);
//		int limit = dropdown.size();
//		
//		int sortIndex = getRandomIndex(limit);
//		WebElement sort = dropdown.get(sortIndex);
//		sort.click();
		sortElement.click();

		TimeUnit.SECONDS.sleep(1);
	}

	@FindBy(xpath="//*[@class=\"u-xx-large-font u-bold\"]") WebElement docNums;

	public int noOfDoc() throws InterruptedException {

		TimeUnit.SECONDS.sleep(2);
		try {
			String doctorNumbersStr = docNums.getText();

			int doctors = Integer.parseInt(doctorNumbersStr.substring(0,doctorNumbersStr.indexOf(' ')));

			return doctors;
		}
		catch(NoSuchElementException e) {
			System.out.println("There are no doctors");
		}
		return 0;

	}
	
	@FindBy(xpath="//*[@class=\"doctor-name\"]") List<WebElement> doctorsNameList;

	public String[] doctorsNames() throws InterruptedException {
		
		String[] doctorNamesArr = new String[5];
		
		for(int i=0; i<doctorNamesArr.length; i++) 
		{
			String doctorName = doctorsNameList.get(i).getText();
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
	
	public boolean surgeriesClick( ) throws InterruptedException {
		if(surgeriesElement.isDisplayed()) {
			surgeriesElement.click();
			return true;
		}
		return false;
		
//		TimeUnit.SECONDS.sleep(4);
////		surgeriesElement.click();
//		js.executeScript("arguments[0].click()", surgeriesElement);
		
	}
}