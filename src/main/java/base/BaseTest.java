package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static WebDriver getDriver() {
    	driver.manage().window().maximize();
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
