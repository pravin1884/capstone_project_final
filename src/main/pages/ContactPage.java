public class ContactPage {
    private WebDriver driver;
    private By pageTitle = By.xpath("//h1[contains(text(),'Contact')]");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void fillContactForm(String name, String email, String comment) {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("comment")).sendKeys(comment);
    }

    public void submitForm() {
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(By.xpath("//div[contains(text(),'Message Sent')]")).getText();
    }
}

}
