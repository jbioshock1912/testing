import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseUtils;

import java.time.Duration;

public class ExplicitWaitTest extends BaseUtils {

    WebDriver driverFirefox = BaseUtils.initializeFireFox();

    @Test
    public void checkWaiting(){

        driverFirefox.get(ConstantsUtils.GOOGLE_SIGN_UP_URL);
        WebDriverWait wait = new WebDriverWait(driverFirefox, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ConstantsUtils.GOOGLE_CREATE_ACC_XPATH)));

        driverFirefox.get(ConstantsUtils.GOOGLE_XPATH);
        driverFirefox.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
        WebElement firstResult = new WebDriverWait(driverFirefox, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
        // Print the first result
        System.out.println(firstResult.getText());
    }
}
