import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BaseUtils;

public class FewTab extends BaseUtils {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.oracle.com/java/technologies/downloads/#java8");
        String mainTabName = driver.getWindowHandle(); // сохраняем имя вклдаки
        driver.findElement(By.xpath("//*[@id=\"java8\"]/section[1]/div/p[3]/a[1]")).click(); // кликаем на соглашение

        for (String tabHandle : driver.getWindowHandles()){ // в цикле получаем значения метода windowHandle
            driver.switchTo().window(tabHandle); // переключаемся на вторую вкладку
        }
        driver.findElement(By.xpath("*//button[@data-navtarget = 'products']")).click(); // нажали на меню продукт в новой вкладке
        driver.switchTo().window(mainTabName); // переключились на окно
        driver.findElement(By.xpath("*//button[@data-navtarget = 'products']")).click(); //нажали на продукт в старой вкладке(!)
        driver.findElement(By.xpath("*//button[@data-navtarget = 'industries']")).click();// нажали индастрис в старой вкладке
        //TODO разобраться с открытыми окнами, а не вкладками и почему не работает в мозилле?
    }
}
