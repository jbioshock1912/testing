import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;

public class FewWindows extends BaseUtils {
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.oracle.com/java/technologies/downloads/#java8");
        Actions action= new Actions(driver);
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"java8\"]/section[1]/div/p[3]/a[1]"));
        action.contextClick(searchBtn).build().perform();




    }
}
