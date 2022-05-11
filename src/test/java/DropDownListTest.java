import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DropDownListTest extends BaseUtils {
    WebDriver driverFireFox = BaseUtils.initializeFireFox();

    @Test
    public void inputBirthday() {
        driverFireFox.get("https://account.mail.ru/signup?from=main&rf=auth.mail.ru&app_id_mytracker=58519");
        DropDownList.setBirthDay("28", "Январь", "1991");
    }
}
