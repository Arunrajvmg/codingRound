package CommonFunctions.Package;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.sun.javafx.PlatformUtil;


public class CommonFunctions {
	public WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public void Screenshot() throws IOException {
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File("Screenshots/error.png"));
        FileUtils.copyFile(src, new File("Screenshots/" + driver.getTitle().substring(4) + getRandomDoubleBetweenRange(1000,9999) +"error.png"));
	}

	public static double getRandomDoubleBetweenRange(double min, double max){
    double x = (Math.random()*((max-min)+1))+min;
    return x;		}
	
	public CommonFunctions() {
		setDriverPath();
		//Disabling notifications in chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--disable-notifications");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
    private void setDriverPath() {
    	// Identifying the OS in which scripts are executed to assign suitable driver
        if (PlatformUtil.isMac()) {
        	System.out.println("Mac");
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
        	System.out.println("Linux");
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
	
    public boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }	
}