package books;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href = '/login']")
    private WebElement logInLink;
    @FindBy(xpath = "//a[@href = '/register']")
    private WebElement registerLink;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement logOutButton;

    public LoginPage logInLinkClick() {
        logInLink.click();
        return new LoginPage(driver);
    }

    public LoginPage logOutLinkClick() {
        logOutButton.click();
        return new LoginPage(driver);
    }

    public RegistrationNewUserPage registerLinkClick() {
        registerLink.click();
        return new RegistrationNewUserPage(driver); // почему подчеркивает драйвер красным, если его нет в регистрационной странице?
    }
}
