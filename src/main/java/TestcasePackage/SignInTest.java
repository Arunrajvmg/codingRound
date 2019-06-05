package TestcasePackage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import CommonFunctions.Package.CommonFunctions;

public class SignInTest extends CommonFunctions {
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	try {
	        driver.get("https://www.cleartrip.com/");
	        driver.findElement(By.id("english_site_pref")).click();
	        driver.findElement(By.linkText("Your trips")).click();
	        driver.findElement(By.id("SignIn")).click();
	        driver.switchTo().frame("modal_window");
	        driver.findElement(By.id("signInButton")).click();        
	        String errors1 = driver.findElement(By.id("errors1")).getText();
	        Assert.assertTrue(errors1.contains("There were errors in your submission"));
	        driver.quit(); }
    	 catch (Exception e) {
    		 Assert.assertTrue(false);
    		 driver.quit();
    	 }
    }
}
