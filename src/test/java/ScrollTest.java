import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseUtils;

public class ScrollTest extends BaseUtils {

    WebDriver driverChrome = initializeChromeDriver();
    JavascriptExecutor jse = (JavascriptExecutor)driver;

    @Test
    public void scrollToElement(){
        driverChrome.get(ConstantsUtils.JACKSON_WIKI_URL);
        WebElement textElement = driverChrome.findElement(By.xpath(ConstantsUtils.THEMES_ANS_GENRES_XPATH));
        WebElement linkElement = driverChrome.findElement(By.xpath(ConstantsUtils.TITO_XPATH));
        jse.executeScript("arguments[0].scrollIntoView();", textElement);
        jse.executeScript("arguments[0].scrollIntoView();", linkElement);
    }

    @Test
    public void scrollDown(){
        driverChrome.get(ConstantsUtils.JACKSON_WIKI_URL);
        jse.executeScript("window.scrollBy(0, 50000)", "");
    }

    @Test
    public void scrollUpTest(){
        driverChrome.get(ConstantsUtils.JACKSON_WIKI_URL);
        jse.executeScript("window.scrollBy(0, -50000)", "");
    }

    @Test
    public void alertMessage(){
        jse.executeScript("alert('HELLO!');");
    }
}
