import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BaseUtils;

public class InteractionAlert extends BaseUtils {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://learn.javascript.ru/alert-prompt-confirm");
        WebElement demo = driver.findElement(By.xpath("//a[contains(text(), 'Запустить демо')]"));
        demo.click();
        Thread.sleep(3000);
        // добавили задержку чтоб видеть алерт
        driver.switchTo().alert().sendKeys("Julia");
        Thread.sleep(3000);
        driver.switchTo().alert().accept(); // принять алерт
        driver.switchTo().alert().accept();
        driver.get("http://google.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("confirm('Are you sure?');");
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        //TODO взять введенный текст из алерт
    }
}
