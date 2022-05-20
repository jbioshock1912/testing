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

    public LoginPage logInButtonClick() {
        driver.findElement(logInButton).click();
        return new LoginPage(driver); // не очень понятно с передачей драйвера
    }

    public MainBookStorePage searchBoxInputText(String text){
        driver.findElement(searchBox).sendKeys(text);
        return this;
    }
}
