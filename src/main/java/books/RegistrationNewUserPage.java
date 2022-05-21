package books;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class RegistrationNewUserPage {
    WebDriver driver;

    public RegistrationNewUserPage(WebDriver driver) {
        this.driver = driver;
    }

    private By inputFirstName = By.xpath("//input[@id='firstname']");
    private By inputLastName = By.xpath("//input[@id='lastname']");
    private By inputUserName = By.xpath("//input[@id='userName']");
    private By inputPassword = By.xpath("//input[@id='password']");

    private By reCaptcha = By.xpath("//iframe[@title = 'reCAPTCHA']");
    private By registerButton = By.xpath("//button[@id='register']");
    private By backToLogInButton = By.xpath("//button[@id='gotologin']");

    public LoginPage backToLogInClick() {
        driver.findElement(backToLogInButton).click();
        return new LoginPage(driver);
    }

    public RegistrationNewUserPage typeFirstName(String firstName) {
        driver.findElement(inputFirstName).sendKeys(firstName);
        return this;
    }

    public RegistrationNewUserPage typeLastName(String lastName) {
        driver.findElement(inputLastName).sendKeys(lastName);
        return this;
    }

    public RegistrationNewUserPage typeUserName(String userName) {
        driver.findElement(inputUserName).sendKeys(userName);
        return this;
    }

    public RegistrationNewUserPage typePassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
        return this;
    }

    public RegistrationNewUserPage reCaptchaSelect() {
        driver.findElement(reCaptcha).click();
        return this;
    }

    public RegistrationNewUserPage registerButtonClick() {
        driver.findElement(registerButton).click();
        return this;
    }

    public RegistrationNewUserPage acceptAlert(){//если регистрация прошла спешно, то будет всплывающий алерт
        driver.switchTo().alert().accept();
        return this;
    }

    // при успешной регистрации высплывает алерт, но перехода на страницу нет. при
    public RegistrationNewUserPage registrationWithValidData(String firstName, String lastName, String userName, String password){
        this.typeFirstName(firstName);
        this.typeLastName(lastName);
        this.typeUserName(userName);
        this.typePassword(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.reCaptchaSelect();
        this.registerButtonClick();
        this.acceptAlert();
        return this; // или сделать ретерн new RegistrationNewUserPage?
    }
}
