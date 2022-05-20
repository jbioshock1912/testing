package books;

import org.openqa.selenium.WebDriver;
import utils.BaseUtils;

public class MainClass extends BaseUtils {
    static WebDriver driverFirefox;

    public static void main(String[] args) {
        driverFirefox = BaseUtils.initializeFireFox();
        driverFirefox.get("https://demoqa.com/profile");

        LoginPage loginPage = new LoginPage(driverFirefox);
        MainBookStorePage mainBookStorePage = new MainBookStorePage(driverFirefox);
        ProfilePage profilePage = new ProfilePage(driverFirefox);
        RegistrationNewUserPage registrationNewUserPage = new RegistrationNewUserPage(driverFirefox);

    }
}
