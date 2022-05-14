import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FindElementsMethods {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jbios\\IdeaProjects\\testing\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement logInLink = driver.findElement(By.linkText("Войти")); // найти элемент по текст-ссылке
        WebElement linkByWordJesus = driver.findElement(By.partialLinkText(" Иисуса Христа")); // найти элемент по части текста в ссылке
        WebElement searchField = driver.findElement(By.name("search")); // искать элемент по имени
        WebElement searchButton = driver.findElement(By.className("searchButton")); // по названию класса
        WebElement elementId = driver.findElement(By.id("coll-create_a_book")); // по id
        WebElement tagInput = driver.findElement(By.tagName("input")); // по тегу
        WebElement cssSearch = driver.findElement(By.cssSelector("div#simpleSearch")); // по селектору CSS
        WebElement xPathElementLogo = driver.findElement(By.xpath("//a[@class='mw-wiki-logo']")); // по XPath
        driver.quit();
    }
}
