import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class GuruContextClickTest extends BaseUtils {

    WebDriver driverFireFox = BaseUtils.initializeFireFox();

    @Test
    public void contextClick() {
        driverFireFox.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions action = new Actions(driver);
        WebElement link = driver.findElement(By.cssSelector(".context-menu-one"));
        action.contextClick(link).perform();
        WebElement element = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
        element.click();
        driver.switchTo().alert().accept();
    }
}
