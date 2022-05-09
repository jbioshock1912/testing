/*
import net.bytebuddy.implementation.bind.annotation.Origin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;

import java.time.Duration;

public class ScrollSelenium extends BaseUtils {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://crossbrowsertesting.github.io/selenium_example_page.html");
            WebElement element = driver.findElement(By.id("closepopup"));

            Actions actions = new Actions(driver);
            actions.sc

            actions.scroll(0, 0, 0, 0, PointerInput.Origin.fromElement(element))
                    .perform();
        } finally {
            driver.quit();
        }
    }
}
*/
