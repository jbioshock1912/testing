import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DropDownListTest extends BaseUtils {
    WebDriver driverFireFox = BaseUtils.initializeFireFox();

    public static void setBirthDay(String day, String month, String year){
        driver.get(ConstantsUtils.MAIL_REGISTRATION_URL);
        String xPathForInputText = "//span[contains(text(), '%s')]";

        driver.findElement(By.xpath(ConstantsUtils.BIRTH_DAY_XPATH)).click();
        driver.findElement(By.xpath(String.format(xPathForInputText, day))).click();

        driver.findElement(By.xpath(ConstantsUtils.MONTH_XPATH)).click();
        driver.findElement(By.xpath(String.format(xPathForInputText, month))).click();

        driver.findElement(By.xpath(ConstantsUtils.YEAR_XPATH)).click();
        driver.findElement(By.xpath(String.format(xPathForInputText, year))).click();
    }

    @Test
    public void inputBirthday() {
        setBirthDay("28", "Январь", "1991");
    }
}
