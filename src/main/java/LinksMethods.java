import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinksMethods {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jbios\\IdeaProjects\\testing\\drivers\\geckodriver.exe");
        WebDriver driverFirefox = new FirefoxDriver();
        driverFirefox.get("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        driverFirefox.manage().window().maximize();
        WebElement linkContent = driverFirefox.findElement(By.xpath("//li[@id=\"n-content\"]//span"));
        System.out.println(linkContent.getText()); //выводим в консоль текст элемента
        linkContent.click(); // кликаем на элемент
        driverFirefox.get("https://www.google.com/");
        WebElement luckButton = driverFirefox.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[2]")); // находим кнопку Мне повезет
        luckButton.click();
    }
}
