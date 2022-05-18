import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseUtils;

public class KeyUsageTest extends BaseUtils {

    WebDriver driverFireFox = BaseUtils.initializeFireFox();

    @Test
    public void SelectCutPaste() {
        driverFireFox.get(ConstantsUtils.MAIN_PAGE_WIKI_URL);
        WebElement searchInput = driverFireFox.findElement(By.xpath(ConstantsUtils.SEARCH_WIKI__XPATH));

        String select = Keys.chord(Keys.CONTROL, "a");
        String cut = Keys.chord(Keys.CONTROL, "x");
        String paste = Keys.chord(Keys.CONTROL, "v");

        searchInput.sendKeys("test text");
        searchInput.sendKeys(select);
        searchInput.sendKeys(cut);
        searchInput.sendKeys(paste);
        searchInput.sendKeys(Keys.ENTER);
    }
}
