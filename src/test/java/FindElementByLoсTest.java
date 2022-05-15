import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FindElementByLoсTest extends BaseUtils {

    WebDriver driverFireFox = BaseUtils.initializeFireFox();

    @Test
    public void elementNotFound() {
        driverFireFox.get("http://github.com");

        if (driverFireFox.findElements(By.xpath("//a[text()='Log in']")).size() > 0) {
            System.out.println("Such element is presented");
        } else {
            System.out.println("Cannot find such element");
        }
    }
}
