package TestcasePackage;
import CommonFunctions.Package.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

public class HotelBookingTest extends CommonFunctions {
 
    @FindBy(xpath = "//*[@id='Home']/div/aside[1]/nav/ul[1]/li[2]/a[1]")
    private WebElement hotelLink;

    @FindBy(id = "english_site_pref")
    private WebElement EnglishLanguage;    

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    @FindBy(xpath = "//*[@id='ui-id-1']/li[2]")
    private  WebElement FromLocation;

    @FindBy(xpath = "//*[@id='SearchForm']/section[2]/div[1]/dl/dt/label")
    private  WebElement DateLabel;
    
    @Test
    public void shouldBeAbleToSearchForHotels() {
    	try {
	        driver.get("https://www.cleartrip.com/");
	        PageFactory.initElements(driver, this);
	        // This exception is used to handle in regions where there are multiple languages
	        if (isElementPresent(driver, By.id("english_site_pref")) == true) {
	        	EnglishLanguage.click();        }
	        hotelLink.click();
	        localityTextBox.sendKeys("Indiranagar, Bangalore");
	        FromLocation.click();
	        DateLabel.click();
	        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
	        searchButton.click();
	        Assert.assertTrue(isElementPresent(driver,By.linkText("Check availability")));
	        driver.quit(); }
		 catch (Exception e) {
			 Assert.assertTrue(false);
			 driver.quit();
		 }
    }
}
