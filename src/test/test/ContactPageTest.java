public class ContactPageTest {
    private WebDriver driver;
    private ContactPage contactPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
        contactPage = new ContactPage(driver);
    }

    @Test
    public void testContactPage() {
        Assert.assertEquals(driver.getTitle(), "Want to Practice Test Automation? Try These Demo Sites!");

        driver.findElement(By.linkText("Contact")).click();
        Assert.assertEquals(contactPage.getPageTitle(), "Contact");

        contactPage.fillContactForm("John Doe", "johndoe@example.com", "This is a test comment");
        contactPage.submitForm();
        Assert.assertEquals(contactPage.getConfirmationMessage(), "Message Sent");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
