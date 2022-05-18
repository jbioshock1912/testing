import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseUtils;

public class DisplayElementTest extends BaseUtils {

    WebDriver driverChrome = BaseUtils.initializeChromeDriver();

    @Test
    public void isDisplayedEbayElement() {
        driverChrome.get(ConstantsUtils.EBAY_URL);
        WebElement link1 = driverChrome.findElement(By.xpath(ConstantsUtils.EBAY_LINK_MENU_XIAOMI_XPATH));
        WebElement link2 = driverChrome.findElement(By.xpath(ConstantsUtils.EBAY_LINK_MENU_MAIN_XPATH));
        System.out.println(link1.isDisplayed());
        System.out.println(link2.isDisplayed());

        Assert.assertFalse(link1.isDisplayed());
        Assert.assertTrue(link2.isDisplayed());
    }
}
