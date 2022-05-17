package books;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By logInLink = By.xpath("//a[@href = '/login']");
    private By registerLink = By.xpath("//a[@href = '/register']");
    private By logInMenu = By.xpath("//span[contains(text(), 'Login')]");
    private By bookStoreMenu = By.xpath("//span[contains(text(), 'Book Store')]");

    public LoginPage logInLinkClick() {
        driver.findElement(logInLink).click();
        return new LoginPage(driver);
    }

    public RegistrationNewUserPage registerLinkClick() {
        driver.findElement(registerLink).click();
        return new RegistrationNewUserPage(driver); // почему подчеркивает драйвер красным, если его нет в регистрационной странице?
    }

    public LoginPage loginMenuClick() {
        driver.findElement(logInMenu).click();
        return new LoginPage(driver);
    }

    public MainBookStorePage bookStoreMenuClick() {
        driver.findElement(bookStoreMenu).click();
        return new MainBookStorePage(driver);
    }
}
