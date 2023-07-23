package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlipkartProductPage {
    private final WebDriver driver;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;

    public FlipkartProductPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60L));
    }

    public String isProductPageDisplayed(){
        return driver.getTitle();
    }
}
