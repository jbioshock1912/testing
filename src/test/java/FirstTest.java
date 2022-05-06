import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;


public class FirstTest extends BaseUtils {
    /*    WebDriver driver = new ChromeDriver();*/
    WebDriver firefox = new FirefoxDriver();

    @BeforeMethod
    public void Base() {
        /* System.out.println(driver.getTitle());*/
        firefox.get("https://www.google.com/");
        System.out.println(firefox.getTitle()); // прочитать заголовок текущей страницы из браузера и вывести
        System.out.println(firefox.getCurrentUrl()); // текущий урл

        firefox.manage().window().maximize();
        firefox.manage().deleteAllCookies();
    }

    @Test
    public void Test() throws AWTException {

        firefox.findElement(By.name("q")).sendKeys("Selenium");
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
    }

    @AfterMethod
    void Close() {
        firefox.close();
    }
}