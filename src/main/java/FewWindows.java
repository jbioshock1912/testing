import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

public class FewWindows extends BaseUtils {

    private static Robot createRobotKeys() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN); // ищем в меню второй элемент - открыть в новом окне
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        return robot;
    }

    public static void main(String[] args) throws AWTException, InterruptedException {
        /*    initializeChromeDriver("https://www.oracle.com/java/technologies/downloads/#java8");
        String mainWindowName = driver.getWindowHandle(); // сохраняем имя окна
        Actions action= new Actions(driver);
        WebElement agreeBtn = driver.findElement(By.xpath("//*[@id=\"java8\"]/section[1]/div/p[3]/a[1]"));
        action.contextClick(agreeBtn).perform(); // щелкаем правкой кнопкой мыши и вызываем меню
        Robot robot = createRobotKeys();
*/
        for (String windowHandle : driver.getWindowHandles()){ // в цикле получаем значения метода windowHandle
            driver.switchTo().window(windowHandle); // переключаемся на вторую вкладку
        }
        driver.get("google.com");
        //driver.findElement(By.xpath("*//button[@data-navtarget = 'products']")).click(); // нажали на меню продукт в новой вкладке
       // driver.switchTo().window(mainWindowName); // переключились на окно
        driver.get("mai.ru");
        driver.findElement(By.xpath("*//button[@data-navtarget = 'products']")).click(); //нажали на продукт в старой вкладке(!)
        driver.findElement(By.xpath("*//button[@data-navtarget = 'industries']")).click();// нажали индастрис в старой вкладке

        //TODO разобраться почему не открывает меню в выбранном окне и почему бросает ошибку
    }
}
