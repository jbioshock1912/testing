import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class SearchingListElementWildberries {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jbios\\IdeaProjects\\testing\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.wildberries.ru/catalog/igrushki/igrovye-kompleksy?sort=popular&page=1");
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//fieldset[@class='j-list filter__fieldset list_left_fbrand render_type_6 filter__fieldset--limited']/label")); //почему 100
        /*driver.get("https://www.mvideo.ru/elektrotransport-4507/elektrosamokaty-6527");
       List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@class='filter-checkbox-list__container filter-checkbox-list__container--with-show-btn' and @_ngcontent-serverapp-c229=\"\"]//mvid-icon"));*/
        System.out.println(checkBoxes.size());
        for (var value:checkBoxes
             ) {value.click();
        }
    }
}
