package books;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logInButton = By.xpath("//button[@id = 'login']");
    private By newUserButton = By.xpath("//button[@id = 'newUser']");
    private By inputUserName = By.xpath("//input[@id = 'userName']");
    private By inputPassword = By.xpath("//input[@id = 'password']");
    private By bookStoreMenu = By.xpath("//span[contains(text(), 'Book Store')]");
    private By profileMenu = By.xpath("//span[contains(text(), 'Profile')]");

    public MainBookStorePage bookStoreMenuClick() {
        driver.findElement(bookStoreMenu).click();
        return new MainBookStorePage(driver);
    }

    public ProfilePage profileMenuClick() {
        driver.findElement(profileMenu).click();
        return new ProfilePage(driver);
    }

    public RegistrationNewUserPage newUserButtonClick() {
        driver.findElement(newUserButton).click();
        return new RegistrationNewUserPage(driver);
    }

    public LoginPage typeUserName(String userName) {
        driver.findElement(inputUserName).sendKeys(userName); // возвращаем текущую страницу, заполняем юзера
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
        return this;
    }

    public ProfilePage logInButtonClick() {
        driver.findElement(logInButton).click();
        return new ProfilePage(driver);
    }

    public ProfilePage logInDataType(String userName, String password) {
        this.typeUserName(userName);
        this.typePassword(password);
        this.logInButtonClick();
        return new ProfilePage(driver);
    }
}
