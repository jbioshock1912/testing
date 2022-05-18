import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utils.BaseUtils;

import java.time.Duration;

public class DemoqaTest extends BaseUtils {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/buttons");

        Actions actions = new Actions(driver);

        WebElement btnElement = driver.findElement(By.id("rightClickBtn"));

        actions.contextClick(btnElement).perform(); //Щелкнуть правой кнопкой мыши на кнопке

        // Следующий ниже код предназначен для выбора элемента из контекстного меню, которое открывается при щелчке правой кнопкой мыши
       // в зависимости от конкретного тестового примера вашего приложения:
       //Выберите и нажмите "Копировать меня", т.е. 2-й вариант в контекстном меню
        WebElement elementOpen = driver.findElement(By.xpath(".//div[@id='rightclickItem']/div[1]"));
        elementOpen.click();

        // Accept the Alert
        driver.switchTo().alert().accept();
        System.out.println("Right click Alert Accepted");
    }
}
