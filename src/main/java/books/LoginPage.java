package books;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@id = 'login']")
    private WebElement logInButton;
    @FindBy(xpath = "//button[@id = 'newUser']")
    private WebElement newUserButton;
    @FindBy(xpath = "//input[@id = 'userName']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@id = 'password']")
    private WebElement inputPassword;

    public RegistrationNewUserPage newUserButtonClick() {
        newUserButton.click();
        return new RegistrationNewUserPage(driver);
    }

    public LoginPage typeUserName(String userName) {
        inputUserName.sendKeys(userName); // возвращаем текущую страницу, заполняем юзера
        return this;
    }

    public LoginPage typePassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public ProfilePage logInButtonClick() {
        logInButton.click();
        return new ProfilePage(driver);
    }

    public ProfilePage logInDataType(String userName, String password) {
        this.typeUserName(userName);
        this.typePassword(password);
        this.logInButtonClick();
        return new ProfilePage(driver);
    }
}
