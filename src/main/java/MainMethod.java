import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MainMethod {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jbios\\IdeaProjects\\testing\\drivers\\geckodriver.exe");
        WebDriver driverFirefox = new FirefoxDriver();
        driverFirefox.get("https://www.google.com/"); // открывает страницу
        driverFirefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // неявное ожидание, задаем ед измерения; если время еще не вышло, но элемент с работой найден, то не ждет остаток времени
        driverFirefox.navigate().to("https://www.yandex.ru/"); // открывает страницу
        driverFirefox.navigate().to("https://translate.yandex.ru/?text=Suppliers&lang=en-ru"); // открывает страницу
        driverFirefox.navigate().back(); // назад
        driverFirefox.navigate().forward(); // вперед
        driverFirefox.manage().window().maximize(); // максимальный размер браузера
        driverFirefox.manage().window().setSize(new Dimension(500, 500)); // установка своего размера
        driverFirefox.navigate().refresh(); // перезагрузить страницу
        driverFirefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // неявное ожидание, задаем ед измерения
        driverFirefox.navigate().to("https://www.selenium.dev/");
        System.out.println(driverFirefox.getTitle()); // вывести в консоли title
        System.out.println(driverFirefox.getCurrentUrl()); // вывести url
        driverFirefox.quit(); // закрытие
    }
}
