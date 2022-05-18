import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.BaseUtils;

public class UploadFileTest extends BaseUtils {
    WebDriver driverFireFox = BaseUtils.initializeFireFox();

    @Test
    public void uploadFile() {
        driverFireFox.get(ConstantsUtils.DEMOGA_UPLOAD_DOWNLOAD_URL);
        driverFireFox.findElement(By.xpath(ConstantsUtils.DEMOGA_UPLOAD_FILE_XPATH)).sendKeys("B:\\test\\16-мая-2022__11_29screen.jpg");
    }
}
