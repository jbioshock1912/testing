package books;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainBookStorePage {
    private WebDriver driver;

    public MainBookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    private By logInButton = By.xpath("//button[@id = 'login']");
    private By searchBox = By.xpath("//input[@id = 'searchBox']");
    private By logInMenu = By.xpath("//span[contains(text(), 'Login')]");
    private By profileMenu = By.xpath("//span[contains(text(), 'Profile')]");


    public LoginPage logInButtonClick() {
        driver.findElement(logInButton).click();
        return new LoginPage(driver); // не очень понятно с передачей драйвера
    }

    public LoginPage logInMenuClick() {
        driver.findElement(logInMenu).click();
        return new LoginPage(driver);
    }

    public ProfilePage profileMenuClick() {
        driver.findElement(profileMenu).click();
        return new ProfilePage(driver);
    }


}
