import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FewWindow extends BaseUtils {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.oracle.com/java/technologies/downloads/#java8");
        String mainWindowName = driver.getWindowHandle(); // сохраняем имя окна
        driver.findElement(By.xpath("//*[@id=\"java8\"]/section[1]/div/p[3]/a[1]")).click(); // кликаем на соглашение

        for (String windowHandle : driver.getWindowHandles()){ // в цикле получаем значения метода windowHandle
            driver.switchTo().window(windowHandle); // переключаемся на наше второе окно
        }
        driver.findElement(By.xpath("*//button[@data-navtarget = 'products']")).click(); // нажали на продукт в новом окне
        driver.switchTo().window(mainWindowName);
        driver.findElement(By.xpath("*//button[@data-navtarget = 'products']")).click(); //нажали на продукт в старом окне!
        driver.findElement(By.xpath("*//button[@data-navtarget = 'industries']")).click();// нажали индастрис
    }
}
