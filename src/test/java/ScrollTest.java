import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollTest extends BaseUtils{
    WebDriver driverChrome = initializeChromeDriver();
    JavascriptExecutor jse = (JavascriptExecutor)driver;

    @Test
    public void scrollToElement(){
        driverChrome.get(ConstantsUtils.JACKSON_WIKI_URL);
        WebElement textElement = driverChrome.findElement(By.xpath(ConstantsUtils.THEMES_ANS_GENRES_TEXT));
        WebElement linkElement = driverChrome.findElement(By.xpath(ConstantsUtils.TITO_LINK));
        jse.executeScript("arguments[0].scrollIntoView();", textElement);
        jse.executeScript("arguments[0].scrollIntoView();", linkElement);
    }

    @Test
    public void scrollDownAndUp(){
        driverChrome.get(ConstantsUtils.JACKSON_WIKI_URL);
        jse.executeScript("window.scrollBy(0, -50000)", "");
        jse.executeScript("window.scrollBy(0, 50000)", "");
    }

    @Test
    public void alertMessage(){
        jse.executeScript("alert('HELLO!');");
    }
}
