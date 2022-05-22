import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseUtils;

import java.time.Duration;

public class DemoQaTest extends BaseUtils {
    WebDriver driverFireFox = initializeFireFox();

    @BeforeMethod
    public void startBaseUrl() {
        driverFireFox.get("https://demoqa.com/profile");
        driverFireFox.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testSimpleCheck(){
        driverFireFox.findElement(By.xpath("//a[@href = '/register']")).click();
    }
}
