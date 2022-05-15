import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxTest {
    WebDriver driverFireFox = BaseUtils.initializeFireFox();

    @Test
    public void findListCheckBox() {
        driverFireFox.get("https://demoqa.com/checkbox");
        driverFireFox.findElement(By.xpath("//button[@class='rct-option rct-option-expand-all']")).click();
        List<WebElement> checkBoxes = driverFireFox.findElements(By.xpath("//div[@class='check-box-tree-wrapper']//li"));
        Assert.assertEquals(checkBoxes.size(), 17);
    }
}
