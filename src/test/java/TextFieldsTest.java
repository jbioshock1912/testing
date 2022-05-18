import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseUtils;

public class TextFieldsTest extends BaseUtils {

    WebDriver driverFireFox = BaseUtils.initializeFireFox();

    @Test
    public void makeRequestCheckValue() {
        driverFireFox.get("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        WebElement searchField = driverFireFox.findElement(By.xpath("//input[@id=\"searchInput\"]"));
        searchField.sendKeys("Selenium WebDriver"); // ищем текст в выбранном веб элементе - текстовом поле
        WebElement searchButton = driverFireFox.findElement(By.xpath("//input[@id=\"searchButton\"]"));
        searchButton.click();
        String result = driverFireFox.findElement(By.xpath("//input[@id='ooui-php-1']")).getAttribute("value");
        Assert.assertEquals(result, "Selenium WebDriver"); // проверка, что в поле введенный текст - Selenium WebDriver
        driverFireFox.findElement(By.xpath("//input[@id='ooui-php-1']")).clear(); // очистить
    }

    @Test
    public void fillLoginAndPassword(){
        driverFireFox.get("https://github.com/login");
        WebElement login = driverFireFox.findElement(By.xpath("//*[@id='login_field']"));
        WebElement password = driverFireFox.findElement(By.xpath("//*[@id='password']"));

        login.sendKeys("test1");
        password.sendKeys("test2");

        String result1 = login.getAttribute("value");
        String result2 = password.getAttribute("value");
        Assert.assertEquals(result1, "test1");
        Assert.assertEquals(result2, "test2");

        driverFireFox.findElement(By.cssSelector(".btn")).click();
    }

    @Test
    public void fillNumber(){
        driverFireFox.get("https://vk.com/");
        WebElement buttonVk = driverFireFox.findElement(By.cssSelector("button.FlatButton:nth-child(1) > span:nth-child(1)"));
        buttonVk.click();

        WebElement textField = driverFireFox.findElement(By.xpath("//*[contains(@class,\"vkc__TextField__input\")]"));
        textField.sendKeys("89545253122");

        String result = textField.getAttribute("value");
        Assert.assertEquals(result, "89545253122");

        driverFireFox.findElement(By.xpath("//*[contains(@class, \"vkc__Button__title\")]")).click();
    }
}
