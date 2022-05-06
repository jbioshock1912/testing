import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MainActions extends BaseUtils {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            // Navigate to Url
            driver.get("https://www.ebay.com/");

            // Store 'Gmail' anchor web element
            WebElement gmailLink = driver.findElement(By.linkText("Электроника"));
            Actions actionProvider = new Actions(driver);
            // Performs mouse move action onto the element
            actionProvider.moveToElement(gmailLink).build().perform();
        }
        finally {

        }
    }
}
