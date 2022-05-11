import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class BaseUtils {

    private static final String HUB_URL = "http://localhost:4444/wd/hub";
    private static boolean remoteWebDriver = false;
    protected static WebDriver driver;

    static {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(HUB_URL + "/status").openConnection();
            try {
                con.setRequestMethod("GET");
                remoteWebDriver = con.getResponseCode() == HttpURLConnection.HTTP_OK;
            } finally {
                con.disconnect();
            }
        } catch (IOException ignore) {}

        if (!remoteWebDriver) {
            WebDriverManager.chromedriver().setup();
            WebDriverManager.firefoxdriver().setup();
        }
    }

    protected static WebDriver initializeChromeDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    protected static WebDriver initializeFireFox(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}