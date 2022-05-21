package test_books;

import books.LoginPage;
import books.MainBookStorePage;
import books.ProfilePage;
import books.RegistrationNewUserPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utils.BaseUtils;

public class BookStoreTest extends BaseUtils {

    WebDriver driverFireFox = initializeFireFox();
    LoginPage loginPage = new LoginPage(driverFireFox);
    MainBookStorePage mainBookStorePage = new MainBookStorePage(driverFireFox);
    ProfilePage profilePage = new ProfilePage(driverFireFox);
    RegistrationNewUserPage registrationNewUserPage = new RegistrationNewUserPage(driverFireFox);

    @BeforeMethod
    public void startBaseUrl() {
        driverFireFox.get("https://demoqa.com/books");
    }

    /*Тест1. Ввести в поск корректное название/часть названия книги и подтвердить, что метод работает и находит книгу
    Шаги
    1. Зайти на страницу https://demoqa.com/books
    2. ВВести в поиск валидное значение Git Pocket Guide
    3. Подтвердить, что книга Git Pocket Guide находится по введенным данным
    4. Закрыть браузер
    */

    @Test
    public void testSearchValidationPositive1(){
        mainBookStorePage.searchBoxInputText("git");
        boolean actualResult = driverFireFox.findElement(By.xpath("//a[contains(text(), 'Git')]")).isDisplayed();
        Assert.assertTrue(actualResult);
    }

/*Тест2. Подтвердить, что новый пользователь успешно зарегистрирован
    Шаги
    1. Нажать на Log in
    2. Выбрать создание нового пользователя
    3. Ввести валидные данные
    4. Подтвердить, что получени сообщение User Register Successfully.
    5. Закрыть браузер
    */

    @Ignore //капчу не обойти
    @Test
    public void testRegistrationNewUserPositive2(){
        mainBookStorePage.logInButtonClick();
        loginPage.newUserButtonClick();
        registrationNewUserPage.registrationWithValidData("first", "Mylast", "myname", "Hello745*W");
    }
/*Тест3. Войти в профиль и подтвердить, что в поле user name отображается Jujukiss
    Шаги
    1. Нажать на Log in
    2. Ввести user name и пароль
    3. Войти в  профиль
    4. Подтвердить user name
    5. Выйти из профиля
    5. Закрыть браузер
    */
    @Test
    public void testLoInPositive(){
        mainBookStorePage.logInButtonClick();
        loginPage.typeUserName("Jujukiss");
        loginPage.typePassword("Hello745*");
        loginPage.logInButtonClick();
        System.out.println(driverFireFox.findElement(By.xpath("//label[@id='userName-value']")).getText());
    }

}
