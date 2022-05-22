package books;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class RegistrationNewUserPage {
    WebDriver driver;

    public WebElement getInputFirstName() {
        return inputFirstName;
    }

    public WebElement getInputLastName() {
        return inputLastName;
    }

    public WebElement getInputUserName() {
        return inputUserName;
    }

    public RegistrationNewUserPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement inputLastName;
    @FindBy(xpath = "//input[@id='userName']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//iframe[@title = 'reCAPTCHA']")
    private WebElement reCaptcha;
    @FindBy(xpath = "//button[@id='register']")
    private WebElement registerButton;
    @FindBy(xpath = "//button[@id='gotologin']")
    private WebElement backToLogInButton;

    public LoginPage backToLogInClick() {
        backToLogInButton.click();
        return new LoginPage(driver);
    }

    public RegistrationNewUserPage typeFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }

    public RegistrationNewUserPage typeLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    public RegistrationNewUserPage typeUserName(String userName) {
        inputUserName.sendKeys(userName);
        return this;
    }

    public RegistrationNewUserPage typePassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public RegistrationNewUserPage reCaptchaSelect() {
        reCaptcha.click();
        return this;
    }

    public RegistrationNewUserPage registerButtonClick() {
        registerButton.click();
        return this;
    }

    public RegistrationNewUserPage acceptAlert() {//если регистрация прошла спешно, то будет всплывающий алерт
        driver.switchTo().alert().accept();
        return this;
    }

    // при успешной регистрации высплывает алерт, но перехода на страницу нет. срабатывает капча при роботе
    public RegistrationNewUserPage registrationWithValidData(String firstName, String lastName, String userName, String password) {
        this.typeFirstName(firstName);
        this.typeLastName(lastName);
        this.typeUserName(userName);
        this.typePassword(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.reCaptchaSelect();
        this.registerButtonClick();
        this.acceptAlert();
        return this;
    }
}
