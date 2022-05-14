
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioBtnTest extends BaseUtils {

    WebDriver driverChrome = initializeChromeDriver();

    @Test
    public void demogaIsSelectedTest1() {
        driverChrome.get(ConstantsUtils.DEMOGA_RADIO_BTN_URL);
        if (!(driverChrome.findElement(By.xpath(ConstantsUtils.DEMOGA_IMPRESSIVE_RADIO_BTN_XPATH)).isSelected())) {
            driverChrome.findElement(By.xpath(ConstantsUtils.DEMOGA_IMPRESSIVE_BTN_XPATH)).click();
        }
        System.out.println("isSelected");
        Assert.assertTrue(driverChrome.findElement(By.xpath(ConstantsUtils.DEMOGA_IMPRESSIVE_RADIO_BTN_XPATH)).isSelected());
    }

    @Test
    public void demogaDeselectedTest2() {
        driverChrome.get(ConstantsUtils.DEMOGA_RADIO_BTN_URL);
        if ((driverChrome.findElement(By.xpath(ConstantsUtils.DEMOGA_YES_RADIO_BTN_XPATH)).isSelected())) {
            driverChrome.findElement(By.xpath(ConstantsUtils.DEMOGA_YES_CHECK_BTN_XPATH)).click();
        }
        System.out.println("deSelected");
        Assert.assertFalse(driverChrome.findElement(By.xpath(ConstantsUtils.DEMOGA_YES_RADIO_BTN_XPATH)).isSelected());
    }
}
