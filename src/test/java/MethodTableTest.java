import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseUtils;
import table.MethodTable;

import static org.testng.Assert.*;

public class MethodTableTest extends BaseUtils {

    WebDriver driverFireFox = BaseUtils.initializeFireFox();
    MethodTable tableForTest;

    @BeforeMethod
    public void getTable() {
        driverFireFox.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement table_customers = driver.findElement(By.xpath("//table[@id='customers']"));
        tableForTest = new MethodTable(table_customers, driverFireFox);
    }

    @Test
    public void hetRowsNumber() {
        assertEquals(tableForTest.getRows().size(), 6);
    }

    @Test
    public void testGetValueFromCellFirst() {
        assertEquals(tableForTest.getValueFromCell(2, 3), "Mexico");
    }

    @Test
    public void testGetValueFromCellSecond() {
        assertEquals(tableForTest.getValueFromCell(4, 1), "Island Trading");
    }

    @Test
    public void testTestGetValueFromCellFirst() {
        assertEquals(tableForTest.getValueFromCell(4, "Company"), "Island Trading");
    }

    @Test
    public void testTestGetValueFromCellSecond() {
        assertEquals(tableForTest.getValueFromCell(1, "Country"), "Germany");
    }

    @Test
    public void testTestGetValueFromCellThird() {
        assertEquals(tableForTest.getValueFromCell(2, "Contact"), "Francisco Chang");
    }
}