package CommonFunctions.Package;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	
	
    public void setDriverPath() {
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