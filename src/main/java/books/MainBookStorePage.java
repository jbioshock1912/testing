package books;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainBookStorePage {
    private WebDriver driver;

    public MainBookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@id = 'login']")
    private WebElement logInButton;
    @FindBy(xpath = "//input[@id = 'searchBox']")
    private WebElement searchBox;

    public LoginPage logInButtonClick() {
        logInButton.click();
        return new LoginPage(driver); // не очень понятно с передачей драйвера
    }

    public MainBookStorePage searchBoxInputText(String text){
        searchBox.sendKeys(text);
        return this;
    }
}
