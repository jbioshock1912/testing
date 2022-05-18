import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseUtils;

public class DropDownList extends BaseUtils {

    public static void setBirthDay(String day, String month, String year) {
        driver.get("https://account.mail.ru/signup?from=main&rf=auth.mail.ru&app_id_mytracker=58519");

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
