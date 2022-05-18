import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.BaseUtils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAndSaveScreenTest extends BaseUtils {

    WebDriver driverFireFox = BaseUtils.initializeFireFox();

    @Test
    public void createScreenAndSave() throws IOException {
        driverFireFox.get(ConstantsUtils.MAIN_PAGE_WIKI_URL);

        File scrFile = ((TakesScreenshot)driverFireFox).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("B:\\test\\screenshot.png"));

        driverFireFox.quit();
    }

    @Test
    public void createScreenAndSaveWithDynamicName() throws IOException {
        driverFireFox.get(ConstantsUtils.MAIN_PAGE_WIKI_URL);

        File scrFile = ((TakesScreenshot)driverFireFox).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm");
        String fileName = "_screen";
        File targetFile = new File("B:\\test\\" + dateFormat.format(new Date()) + fileName + ".jpg");
        FileUtils.copyFile(scrFile, targetFile);

        driverFireFox.quit();
    }
}
