
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ButtonTest extends BaseUtils {
    WebDriver driverChrome = BaseUtils.initializeChromeDriver();

    @Test
    public void testClickButton(){
        driverChrome.get("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        driverChrome.findElement(By.xpath("//input[@id=\"searchButton\"]")).click(); // нашли кнопку и нажимаем на нее
    }

    @Test
    public void getTextOfButton(){
        driverChrome.get("https://github.com/");
        WebElement buttonGitHub = driverChrome.findElement(By.xpath("//button[contains(@class, 'btn-mktg width-full width-sm-auto')]"));
        System.out.println("button text " + buttonGitHub.getText()); //вывести текст кнопки
        Assert.assertEquals(buttonGitHub.getText(), "Sign up for GitHub");
    }

    @Test
    public void checkSubmit(){
        driverChrome.get("https://vk.com/");
        driverChrome.findElement(By.cssSelector("button.FlatButton:nth-child(1) > span:nth-child(1)")).submit();
    }
}
