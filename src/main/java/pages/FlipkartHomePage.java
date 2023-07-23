package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FlipkartHomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;

    @FindBy(css = "a._1fQZEK")
    private WebElement flipkartLogo;

    @FindBy(css = "button[type='submit'] > span > svg")
    private WebElement searchButton;

    @FindBy(css = "a._1fQZEK")
    private WebElement searchItems;
    // Other page elements and methods go here

    @FindBy(css = "div._1AtVbE")
    private WebElement firstSearchItem;
    public FlipkartHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,  Duration.ofSeconds(60L));
    }

    public boolean isFlipkartLogoDisplayed() {
        return flipkartLogo.isDisplayed();
    }

    public void enterSearchQuery(String searchQuery) {
        searchBox.sendKeys(searchQuery);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickFirstSearchItem() {
        firstSearchItem.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public int getNumberOfItemsDisplayed() {
        List<WebElement> searchItems = driver.findElements(By.cssSelector("div._1AtVbE"));
        return searchItems.size();
    }

}

