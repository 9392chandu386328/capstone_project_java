package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePage {

    private WebDriver driver;
    private FluentWait wait;

    // ===== Locators =====
    private By openMenuBtn =
            By.cssSelector("button.wp-block-navigation__responsive-container-open");

    private By parentMenuItem =
            By.cssSelector("li.wp-block-navigation-item.has-child");

    private By extendSubmenuBtn =
            By.cssSelector("button[aria-label='Extend submenu']");

    private By getWordPressLink =
            By.cssSelector("a.global-header__desktop-get-wordpress");

    private By downloadWordPressLink =
            By.xpath("//a[contains(text(),'Download WordPress')]");

    private By communityMenu =
            By.xpath("//span[text()='Community']");

    private By photoDirectoryMenu =
            By.xpath("//span[text()='Photo Directory']");

    // ===== Constructor =====
    public HomePage(WebDriver driver, FluentWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // ===== Actions =====

    public void openResponsiveMenuIfVisible() {
        try {
            WebElement menuBtn = driver.findElement(openMenuBtn);
            if (menuBtn.isDisplayed()) {
                menuBtn.click();
            }
        } catch (NoSuchElementException e) {
            // menu not visible (desktop view)
        }
    }

    public void extendSubMenu() {
        WebElement parent =
                (WebElement) wait.until(
                        ExpectedConditions.visibilityOfElementLocated(parentMenuItem));

        WebElement extendBtn = parent.findElement(extendSubmenuBtn);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", extendBtn);

        extendBtn.click();
    }

    public void clickGetWordPress() {
        WebElement link =
                (WebElement) wait.until(
                        ExpectedConditions.elementToBeClickable(getWordPressLink));
        link.click();
    }

    public void hoverOnDownloadWordPress() {
        WebElement download =
                (WebElement) wait.until(
                        ExpectedConditions.visibilityOfElementLocated(downloadWordPressLink));

        Actions actions = new Actions(driver);
        actions.moveToElement(download).perform();
    }

    public void navigateToPhotoDirectory() {
        WebElement community =
                (WebElement) wait.until(
                        ExpectedConditions.elementToBeClickable(communityMenu));
        community.click();

        WebElement photoDirectory =
                (WebElement) wait.until(
                        ExpectedConditions.elementToBeClickable(photoDirectoryMenu));
        photoDirectory.click();
    }
}
