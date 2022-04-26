import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CheckBoxAndRadioUdemy {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jbios\\IdeaProjects\\testing\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://market.yandex.ru/catalog--stiralnye-mashiny/18031204/list?hid=90566&onstock=0&local-offers-first=0");
        driver.findElement(By.xpath("//input[@class=\"CheckboxCaptcha-Button\"]")).click();
        /*driver.findElement(By.xpath("//a[text()='Бытовая техника']")).click();
        driver.findElement(By.xpath("//a[text()='Стиральные машины']")).click();*/

        selectCheckBox("ATLANT");
        selectCheckBox("Bosch");
        selectCheckBox("Candy");

        deselectCheckBox("Bosch");

//        System.out.println();
//
//        System.out.println(driver.findElement(By.xpath("//label[text()='Самовывоз']/span/input")).isSelected());
//        driver.findElement(By.xpath("//label[text()='Самовывоз']/span")).click();
//        System.out.println(driver.findElement(By.xpath("//label[text()='Самовывоз']/span/input")).isSelected());
//        driver.findElement(By.xpath("//label[text()='С доставкой']/span")).click();
//        driver.quit();
    }

    public static void selectCheckBox(String name){
        String rbXpath = "//label[text()='%s']/preceding-sibling::span";
        if (!driver.findElement(By.xpath(String.format(rbXpath, name) + "/input")).isSelected())
            driver.findElement(By.xpath(String.format(rbXpath, name))).click();
    }
    public static void deselectCheckBox(String name){
        String rbXpath = "//label[text()='%s']/preceding-sibling::span";
        if (driver.findElement(By.xpath(String.format(rbXpath, name) + "/input")).isSelected())
            driver.findElement(By.xpath(String.format(rbXpath, name))).click();
    }
}
