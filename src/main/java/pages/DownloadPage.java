package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DownloadPage {

    private WebDriver driver;
    private FluentWait wait;

    // Locators
    private By heading = By.tagName("h1");

    // Constructor
    public DownloadPage(WebDriver driver, FluentWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Get page heading text
    public String getHeadingText() {
        WebElement headingElement =
                (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(heading));
        return headingElement.getText();
    }
}
