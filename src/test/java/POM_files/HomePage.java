package POM_files;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);		
	}
	
//	@FindBy(linkText = "https://www.practo.com/") WebElement logoElement;
	@FindBy(xpath = "//*[@class = 'practo-logo']") WebElement practoLogo;
	
	//Loactors
	@FindBy(xpath = "//input[@data-qa-id = 'omni-searchbox-locality' and @placeholder = 'Search location']") WebElement locationBox;
	@FindBy(xpath = "//input[@data-qa-id = 'omni-searchbox-keyword']") WebElement searchBox;
//	@FindBy(xpath = "//*[@class=\"c-omni-suggestion-item\"]") WebElement firstelement;
	
	public boolean logo() {
		return practoLogo.isDisplayed();
	}

	String city[] = {"Mum", "Del",	"Bang", "Hyd", "Che", "Kolk", "Luck",  "Pun"};
		
	public int getRandomIndex(int limit) 
	{
		Random r = new Random();
		int randomIndex = r.nextInt(limit);
		return randomIndex;

	}
	
//	@FindBy(xpath = "//*[@class=\"c-omni-suggestion-item\"]") WebElement firstelement;
	@FindBy(xpath = "//*[@class='c-omni-suggestion-group']/div[1]") WebElement firstelement;
	 
	
	public boolean selectCity() throws InterruptedException 
	{
		locationBox.click();
		locationBox.clear();

		int limit = city.length;
		int randomCityIndex = getRandomIndex(limit);
		String cityName = city[randomCityIndex];
		locationBox.sendKeys(cityName);
		TimeUnit.SECONDS.sleep(3);
		
		System.out.println(cityName);
		System.out.println(firstelement.getText());
		
		
		if(!firstelement.getText().contains(cityName)) {
			return false;
		}
		
		TimeUnit.SECONDS.sleep(3);
		
		firstelement.click();

		TimeUnit.SECONDS.sleep(3);
		
		return true;


	}
	
	@FindBy(xpath = "//div[@class = 'c-omni-suggestion-item__content__title']") List<WebElement> specialities;

	public boolean selectSpeciality() throws InterruptedException 
	{
		searchBox.click();
		searchBox.clear();

		int limit = specialities.size();
		int randomSpecialityIndex = getRandomIndex(limit);
		String speciality = specialities.get(randomSpecialityIndex).getText();

		searchBox.sendKeys(speciality);
		TimeUnit.SECONDS.sleep(3);
		
		System.out.println(speciality);
		System.out.println(firstelement.getText());
		

		if(!firstelement.getText().contains(speciality)) {
			return false;
		}

		TimeUnit.SECONDS.sleep(3);
		firstelement.click();
		
		TimeUnit.SECONDS.sleep(3);
		
		return true;

	}
	
	
 
}

