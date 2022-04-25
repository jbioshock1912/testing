import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CheckBoxAndRadioButton {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jbios\\IdeaProjects\\testing\\drivers\\geckodriver.exe");
        WebDriver driverFirefox = new FirefoxDriver();
        driverFirefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driverFirefox.get("https://www.ozon.ru/category/sport-i-igry-na-ulitse-30726/");
        driverFirefox.manage().window().maximize();
        WebElement checkBoxBycicle = driverFirefox.findElement(By.xpath("//span[contains(text(), 'Велосипед')]/../..//*[@class='ui-ab5']"));
        WebElement checkBoxBycicle1 = driverFirefox.findElement(By.xpath("//span[contains(text(), 'Велосипед')]/../..//*[@class='ui-ab5']/../input"));
        checkBoxBycicle.click(); // выделяем чекбокс
        System.out.println(checkBoxBycicle1.isSelected()); //проверка
      /*  checkBoxBycicle.click(); //снимаем выделение
        System.out.println(checkBoxBycicle1.isSelected()); //проверка*/


      /*  checkBoxBycicle.click();*/
        /*System.out.println(checkBoxBycicle.isSelected());*/

       /*driverFirefox.get("https://www.wildberries.ru/catalog/detyam/odezhda/dlya-malchikov/bryuki-i-shorty");*/


      /* WebElement checkBoxAmoda = driverFirefox.findElement(By.xpath("//label[@data-value='1062240']"));
        *//*WebElement checkBoxAmoda = driverFirefox.findElement(By.cssSelector(".list_left_fbrand > .j-list-item:nth-child(1)"));*//*
       checkBoxAmoda.click();
       System.out.println(checkBoxAmoda.isSelected());
        checkBoxAmoda.click();
        System.out.println(checkBoxAmoda.isSelected());*/
    }
}
