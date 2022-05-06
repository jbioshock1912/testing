import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;

public class ScrollToElement extends BaseUtils {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://en.wikipedia.org/wiki/Britney_Spears");
        WebElement elementFirst = driver.findElement(By.xpath("//a[@title='Rob Sheffield']"));
        WebElement elementSecond = driver.findElement(By.xpath("//a[@title='Bhagavan Antle']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        /*jse.executeScript("window.scrollBy(0, 50000)", "");*/
        jse.executeScript("arguments[0].scrollIntoView();", elementSecond);
        /*driver.get("https://crossbrowsertesting.github.io/selenium_example_page.html");
        WebElement element = driver.findElement(By.id("closepopup"));

        Actions actions = new Actions(driver);
        actions.scroll(0,
                        0,
                        0,
                        0,
                        PointerInput.Origin.fromElement(element))
                .perform();*/

    }
}
