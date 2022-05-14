import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElementTest extends BaseUtils {
    WebDriver driverFireFox = BaseUtils.initializeFireFox();

    @Test
    public void disableElement(){
        driverFireFox.get(ConstantsUtils.DEMOGA_TEST_URL);
        boolean value = driverFireFox.findElement(By.xpath(ConstantsUtils.DEMOGA_DISABLE_BUTTON_XPATH)).isEnabled();
        Assert.assertFalse(value);
    }

    @Test
    public void disableRadioBtn(){
        driverFireFox.get(ConstantsUtils.DEMOGA_RADIO_BTN_URL);
        boolean value = driverFireFox.findElement(By.xpath(ConstantsUtils.DEMOGA_NO_RADIO_BTN_XPATH)).isEnabled();
        System.out.println(value);
        Assert.assertFalse(value);
    }

    @Test
    public void seleniumEnableTest(){
        driverFireFox.get("https://www.google.com/");
        boolean value = driver.findElement(By.name("btnK")).isEnabled();
        Assert.assertTrue(value);
    }
}
