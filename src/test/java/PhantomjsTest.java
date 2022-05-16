import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.File;

public class PhantomjsTest {

    @Ignore
    @Test
    public  void PhantomjsTest() {//TODO не работает

        File path=new File("B:\\test\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        System.setProperty("phantomjs.binary.path",path.getAbsolutePath());
        WebDriver driver= new PhantomJSDriver();
        driver.navigate().to("https://www.google.co.in/");
    }
}
