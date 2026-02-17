package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.List;
import java.time.Duration;

public class PhotoDirectoryPage {

    WebDriver driver;
    WebDriverWait wait;

    By searchInput = By.xpath("//input[@placeholder='Search photos']");
    By searchButton = By.xpath("(//button[@aria-label='Search'])[2]");
    By photoList = By.xpath("//ul[contains(@class,'wp-block-post-template')]//li//a");
    By altTextParagraph = By.xpath("//p[span[text()='Alternative Text:']]");

    public PhotoDirectoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void searchPhotos(String keyword) {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        searchBar.clear();
        searchBar.sendKeys(keyword);

        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();

        // Wait until at least one photo is displayed
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(photoList, 0));
        System.out.println("Search completed, photos displayed.");
    }

    public void clickFirstPhoto() {
        List<WebElement> photos = driver.findElements(photoList);
        if (photos.isEmpty()) {
            throw new NoSuchElementException("No photos found to click.");
        }
        photos.get(0).click();
        System.out.println("Clicked first photo.");
    }

    public String getAltText() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);"); // Scroll down if necessary
        WebElement altTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(altTextParagraph));
        String altText = altTextElement.getText();
        System.out.println("Alternative Text: " + altText);
        return altText;
    }

    public boolean arePhotosDisplayed() {
        return !driver.findElements(photoList).isEmpty();
    }
}
