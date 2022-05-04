import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDownList {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jbios\\IdeaProjects\\testing\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://account.mail.ru/signup?from=main&rf=auth.mail.ru&app_id_mytracker=58519");
        setBirthDay("28", "Январь", "1991");

    }

    public static void setBirthDay(String day, String month, String year){
        String xPathForInputText = "//span[contains(text(), '%s')]";

        WebElement birthDayList = driver.findElement(By.xpath("//div[@data-test-id='birth-date__day']//*[@class='base-0-2-37']"));
        birthDayList.click();

        WebElement chooseDay = driver.findElement(By.xpath(String.format(xPathForInputText, day)));
        chooseDay.click();

        WebElement monthList = driver.findElement(By.xpath("//div[@data-test-id='birth-date__month']//*[@class='base-0-2-37']"));
        monthList.click();

        WebElement chooseMonth = driver.findElement(By.xpath(String.format(xPathForInputText, month)));
        chooseMonth.click();


        WebElement yearList = driver.findElement(By.xpath("//div[@data-test-id='birth-date__year']//*[@class='base-0-2-37']"));
        yearList.click();

        WebElement chooseYear = driver.findElement(By.xpath(String.format(xPathForInputText, year)));
        chooseYear.click();
    }
}