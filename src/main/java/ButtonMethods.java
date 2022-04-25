import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ButtonMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jbios\\IdeaProjects\\testing\\drivers\\geckodriver.exe");
        WebDriver driverTestForButton = new FirefoxDriver();
        driverTestForButton.get("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        driverTestForButton.manage().window().maximize();
        driverTestForButton.findElement(By.xpath("//input[@id=\"searchButton\"]")).click(); // нашли кнопку и нажимаем на нее
        driverTestForButton.get("https://github.com/");
        WebElement buttonGitHub = driverTestForButton.findElement(By.xpath("//button[contains(@class, 'btn-mktg width-full width-sm-auto')]"));
        System.out.println("button text " + buttonGitHub.getText()); //вывести текст кнопки
        if (buttonGitHub.getText().equals("Sign up for GitHub")){
            System.out.println("successfully");
        }
        else {
            System.out.println("Failed");
        }
        //buttonGitHub.submit();
        driverTestForButton.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();
        driverTestForButton.get("https://vk.com/");
        WebElement buttonVk = driverTestForButton.findElement(By.cssSelector("button.FlatButton:nth-child(1) > span:nth-child(1)"));
        buttonVk.click();


    }
}
