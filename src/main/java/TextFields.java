import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextFields {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jbios\\IdeaProjects\\testing\\drivers\\geckodriver.exe");
        WebDriver driverFirefox = new FirefoxDriver();
        driverFirefox.get("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        driverFirefox.manage().window().maximize();
        WebElement searchField = driverFirefox.findElement(By.xpath("//input[@id=\"searchInput\"]"));
        searchField.sendKeys("Selenium WebDriver"); // ищем текст в выбранном веб элементе - текстовом поле
        WebElement searchButton = driverFirefox.findElement(By.xpath("//input[@id=\"searchButton\"]"));
        searchButton.click();
        System.out.println(driverFirefox.findElement(By.xpath("//input[@id='ooui-php-1']")).getAttribute("value")); // получаем текстовые атрибут поля и выводим в консоль
        driverFirefox.findElement(By.xpath("//input[@id='ooui-php-1']")).clear(); // очистить
        driverFirefox.get("https://github.com/login");
        WebElement loginField = driverFirefox.findElement(By.xpath("//*[@id='login_field']"));
        loginField.sendKeys("test1"); //заполнить поле логин
        WebElement passwordField = driverFirefox.findElement(By.xpath("//*[@id='password']"));
        passwordField.sendKeys("test2"); // заполнить поле пароль
        driverFirefox.findElement(By.cssSelector(".btn")).click();
        driverFirefox.get("https://vk.com/");
        WebElement buttonVk = driverFirefox.findElement(By.cssSelector("button.FlatButton:nth-child(1) > span:nth-child(1)"));
        buttonVk.click();
        WebElement textField = driverFirefox.findElement(By.xpath("//*[contains(@class,\"vkc__TextField__input\")]"));
        textField.sendKeys("89545253122");
        System.out.println(textField.getAttribute("value").equals("89545253122"));
        driverFirefox.findElement(By.xpath("//*[contains(@class, \"vkc__Button__title\")]")).click();



    }

}
