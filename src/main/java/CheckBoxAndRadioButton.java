import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CheckBoxAndRadioButton extends BaseUtils {

    /*public static void main(String[] args) {
        driver.get("https://www.ozon.ru/category/sport-i-igry-na-ulitse-30726/");
        isSelectedButton("//span[contains(text(), 'Велосипед')]/../..//*[@class='ui-ab5']", driver);
        deSelectedButton("//span[contains(text(), 'Велосипед')]/../..//*[@class='ui-ab5']", driver);

        WebElement checkBoxBycicle = driver.findElement(By.xpath("//span[contains(text(), 'Велосипед')]/../..//*[@class='ui-ab5']"));
        WebElement checkBoxBycicle1 = driver.findElement(By.xpath("//span[contains(text(), 'Велосипед')]/../..//*[@class='ui-ab5']/../input"));
        checkBoxBycicle.click(); // выделяем чекбокс
        System.out.println(checkBoxBycicle1.isSelected()); //проверка
        checkBoxBycicle.click(); //снимаем выделение
        System.out.println(checkBoxBycicle1.isSelected()); //проверка


        checkBoxBycicle.click();
        System.out.println(checkBoxBycicle.isSelected());


        driver.get("https://www.wildberries.ru/catalog/detyam/odezhda/dlya-malchikov/bryuki-i-shorty");


        WebElement checkBoxAmoda = driver.findElement(By.xpath("//label[@data-value='1062240']"));


        WebElement checkBoxAmoda2 = driver.findElement(By.cssSelector(".list_left_fbrand > .j-list-item:nth-child(1)"));


        checkBoxAmoda.click();
        System.out.println(checkBoxAmoda.isSelected());
        checkBoxAmoda.click();
        System.out.println(checkBoxAmoda.isSelected());

    }
*/
    public static void isSelectedButton(WebElement element, WebDriver driver) {
        if (!element.isSelected()) {
            element.click();
            System.out.println("isSelected");
            System.out.println(element.isSelected());
        }
    }

    public static void deSelectedButton(WebElement element, WebDriver driver) {
        if (element.isSelected()) {
            element.click();
            System.out.println("deSelected");
            System.out.println(element.isSelected());
        }
    }
}
