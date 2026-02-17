package stepdefinition;
 
import base.BaseTest;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.DownloadPage;
import pages.PhotoDirectoryPage;
 
public class WordPressSteps extends BaseTest {
 
    HomePage home;
    DownloadPage download;
    PhotoDirectoryPage photo;
 
    @Given("the user launches the browser")
    public void launchBrowser() {
        // Initialize page objects
        home = new HomePage(driver, wait);
        download = new DownloadPage(driver, wait);
        photo = new PhotoDirectoryPage(driver); // PhotoDirectoryPage only needs driver
    }
 
    @And("the user navigates to the WordPress site")
    public void navigateToSite() {
        driver.get("https://wordpress.org/");
        Assert.assertTrue(driver.getTitle().contains("WordPress"),
                "Title does not contain 'WordPress'");
    }
 
    @When("the user opens the responsive menu if visible")
    public void openResponsiveMenu() {
        home.openResponsiveMenuIfVisible();
    }
 
    @And("the user extends the submenu")
    public void extendSubMenu() {
        home.extendSubMenu();
    }
 
    @Then("the page title should contain {string}")
    public void verifyTitle(String title) {
        Assert.assertTrue(driver.getTitle().contains(title),
                "Page title does not contain expected text");
    }
 
    @When("the user clicks Get WordPress")
    public void clickGetWordPress() {
        home.clickGetWordPress();
    }
 
    @Then("the page heading should be {string}")
    public void verifyHeading(String heading) {
        Assert.assertEquals(download.getHeadingText(), heading,
                "Page heading is not as expected");
    }
 
    @When("the user navigates to Photo Directory")
    public void navigateToPhotoDirectory() {
        home.navigateToPhotoDirectory();
    }
 
    @Then("photos should be displayed")
    public void verifyPhotosDisplayed() {
        Assert.assertTrue(photo.arePhotosDisplayed(),
                "No photos are displayed in the directory");
    }
 
    @When("the user searches photos with keyword {string}")
    public void searchPhotos(String keyword) {
        photo.searchPhotos(keyword);
    }
 
    @And("the user clicks the first photo")
    public void clickFirstPhoto() {
        photo.clickFirstPhoto();
    }
 
    @Then("the alternative text should contain {string}")
    public void verifyAltText(String text) {
        String altText = photo.getAltText();
        Assert.assertTrue(altText.toLowerCase().contains(text.toLowerCase()),
                "Search text NOT found in alternative text");
    }
}