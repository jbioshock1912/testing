import com.beust.jcommander.Parameterized;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;


public class CheckBoxAndRadioButtonTest extends BaseUtils {
    WebDriver driverChrome = initializeChromeDriver();



    @Test
    public void isSelectedButtonTest() {

        driverChrome.get("https://www.ozon.ru/category/sport-i-igry-na-ulitse-30726/");
        WebElement bicycle = driverChrome.findElement(By.xpath("//span[contains(text(), 'Велосипед')]/../..//*[@class='ui-ab5']"));
        WebElement scooter = driverChrome.findElement(By.xpath("//span[contains(text(), 'Самокат')]/../..//*[@class='ui-ab5']"));

        CheckBoxAndRadioButton.isSelectedButton(bicycle, driverChrome);
        driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CheckBoxAndRadioButton.isSelectedButton(scooter, driverChrome);

    }

}
