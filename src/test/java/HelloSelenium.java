import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseUtils;

import java.time.Duration;

public class HelloSelenium extends BaseUtils {

    @Test
    public void testFirstSelenium () {
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.getTitle(); // => "Google"
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); //

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        Assert.assertEquals(searchBox.getAttribute("value"), "Selenium"); // => "Selenium"
        driver.quit();
    }
}