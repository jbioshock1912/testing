package books;

import org.openqa.selenium.WebDriver;
import utils.BaseUtils;

public class MainClass extends BaseUtils {
    static WebDriver driverFirefox;

    public static void main(String[] args) {
        driverFirefox = BaseUtils.initializeFireFox();
        driverFirefox.get("https://demoqa.com/books");

       RegistrationNewUserPage registrationNewUser = new RegistrationNewUserPage(driverFirefox);
       MainBookStorePage mainBookStorePage = new MainBookStorePage(driverFirefox);
       mainBookStorePage.profileMenuClick();

       //registrationNewUser.registrationWithValidData("Jul", "Luj", "Julu", "789Holhol*");

    }
}
