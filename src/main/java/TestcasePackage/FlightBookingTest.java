package TestcasePackage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import CommonFunctions.Package.CommonFunctions;

public class FlightBookingTest extends CommonFunctions {
    @Test
    public void testThatResultsAppearForAOneWayJourney() {
    	try {
	        driver.get("https://www.cleartrip.com/");
	        // This exception is used to handle in regions where there are multiple languages
	        if (isElementPresent(driver, By.id("english_site_pref")) == true) {
	        driver.findElement(By.id("english_site_pref")).click();        }
	        driver.findElement(By.id("OneWay")).click();
	        driver.findElement(By.id("FromTag")).clear();
	        driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
	        driver.findElement(By.xpath("//*[@id='ui-id-1']/li[1]")).click();
	        driver.findElement(By.id("ToTag")).clear();
	        driver.findElement(By.id("ToTag")).sendKeys("Delhi");
	        driver.findElement(By.xpath("//*[@id='ui-id-2']/li[1]")).click();
	        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();
	        driver.findElement(By.id("SearchBtn")).click();
	        Assert.assertTrue(isElementPresent(driver,By.className("searchSummary")));
	        //driver.findElement(By.className("searchSummary")).click();
	        Screenshot();
	        driver.quit();
    	}
   	 	catch (Exception e) {
			Assert.assertTrue(false);
			driver.quit();
	 }
    }
}