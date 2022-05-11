import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollTest extends BaseUtils{
    WebDriver driverChrome = BaseUtils.initializeChromeDriver();
    JavascriptExecutor jse = (JavascriptExecutor)driver;

    @Test
    public void scrollToElement(){
        driverChrome.get("https://en.wikipedia.org/wiki/Britney_Spears");
        WebElement elementSecond = driverChrome.findElement(By.xpath("//a[@title='Bhagavan Antle']"));
        jse.executeScript("arguments[0].scrollIntoView();", elementSecond);
    }

    @Test
    public void scrollDown(){
        driverChrome.get("https://en.wikipedia.org/wiki/Britney_Spears");
        jse.executeScript("window.scrollBy(0, 50000)", "");
    }

    @Test
    public void scrollDownAndUp(){
        driverChrome.get("https://en.wikipedia.org/wiki/Britney_Spears");
        jse.executeScript("window.scrollBy(0, 50000)", "");
        jse.executeScript("window.scrollBy(0, -50000)", "");
    }

    @Test
    public void alertMessage(){
        jse.executeScript("alert('HELLO!');");
    }
}
