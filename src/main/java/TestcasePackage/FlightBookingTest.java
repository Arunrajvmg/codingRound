package TestcasePackage;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.concurrent.TimeUnit;
import CommonFunctions.Package.CommonFunctions;

public class FlightBookingTest {
    private WebDriver driver ;
    @Test
    public void testThatResultsAppearForAOneWayJourney() {
    	CommonFunctions CommonFunctionsObj = new CommonFunctions();
    	driver = CommonFunctionsObj.driver;
        driver.get("https://www.cleartrip.com/");
        // This exception is used to handle in regions where there are multiple languages
        if (CommonFunctionsObj.isElementPresent(driver, By.id("english_site_pref")) == true) {
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
        Assert.assertTrue(CommonFunctionsObj.isElementPresent(driver,By.className("searchSummary")));
        driver.quit(); //close the browser
    }
}