package table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Table {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jbios\\IdeaProjects\\testing\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement table_customers = driver.findElement(By.xpath("//table[@id='customers']"));

        MethodTable tableForTest = new MethodTable(table_customers, driver);
        System.out.println("Rows numbers is " + tableForTest.getRows().size());
        System.out.println(tableForTest.getValueFromCell(2, 3));
        System.out.println(tableForTest.getValueFromCell(4, 1));

        System.out.println(tableForTest.getValueFromCell(4, "Company"));
        System.out.println(tableForTest.getValueFromCell(1, "Country"));
        System.out.println(tableForTest.getValueFromCell(2, "Contact"));
    }
}
