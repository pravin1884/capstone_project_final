import configaratin.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlipkartHomePage;
import pages.FlipkartProductPage;

public class FlipkartTest extends BaseClass {

    private WebDriver driver;
    private static final String BASE_URL = "https://www.flipkart.com/";

    @Test
    public void searchIphone14AndVerify() {
        driver.get(BASE_URL);

        // Initialize the FlipkartHomePage with a timeout of 60 seconds for element visibility
        FlipkartHomePage homePage = PageFactory.initElements(driver, FlipkartHomePage.class);

        // Search for "iphone 14"
        homePage.enterSearchQuery("iphone 14");

        // Get the number of items displayed
        int numberOfItems = homePage.getNumberOfItemsDisplayed();

        // Click on the first displayed search item
        homePage.clickFirstSearchItem();

        // Initialize the FlipkartProductPage with a timeout of 60 seconds for element visibility
        FlipkartProductPage productPage = PageFactory.initElements(driver, FlipkartProductPage.class);

        // Verify the title of the page
        Assert.assertTrue(productPage.isProductPageDisplayed().contains("iPhone 14"), "Page title does not contain 'iPhone 14'");
    }
}
