package configaratin;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseClass {
    private WebDriver driver;
    //private ContactPage contactPage;
    //public RemoteWebDriver driver = null;
    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pravin\\Drivers\\chromedriver.exe"); // Set the path to your ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60L));
        PageFactory.initElements((SearchContext) wait,this);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
