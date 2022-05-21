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
    private By logOutButton = By.xpath("//button[@id='submit']");

    public LoginPage logInLinkClick() {
        driver.findElement(logInLink).click();
        return new LoginPage(driver);
    }

    public RegistrationNewUserPage registerLinkClick() {
        driver.findElement(registerLink).click();
        return new RegistrationNewUserPage(driver); // почему подчеркивает драйвер красным, если его нет в регистрационной странице?
    }
}
