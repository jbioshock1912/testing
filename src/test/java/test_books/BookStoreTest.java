package test_books;

import books.LoginPage;
import books.MainBookStorePage;
import books.ProfilePage;
import books.RegistrationNewUserPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utils.BaseUtils;

public class BookStoreTest extends BaseUtils {

    WebDriver driverFireFox = initializeFireFox();
    LoginPage loginPage = PageFactory.initElements(driverFireFox, LoginPage.class);
    MainBookStorePage mainBookStorePage = PageFactory.initElements(driverFireFox, MainBookStorePage.class);
    ProfilePage profilePage = PageFactory.initElements(driverFireFox, ProfilePage.class);
    RegistrationNewUserPage registrationNewUserPage = PageFactory.initElements(driverFireFox, RegistrationNewUserPage.class);

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
    public void testSearchValidationPositive1() {
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

    //капчу не обойти
    @Ignore
    @Test
    public void testRegistrationNewUserPositive2() {
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
    public void testLoInPositive3() {
        String expectedResult = "Jujukiss";
        mainBookStorePage.logInButtonClick();
        loginPage.typeUserName("Jujukiss");
        loginPage.typePassword("Hello745*");
        loginPage.logInButtonClick();
        String actualResult = driverFireFox.findElement(By.xpath("//label[@id='userName-value']")).getText();

        Assert.assertEquals(actualResult, expectedResult);
        profilePage.logOutLinkClick();
    }

    /*Тест4. При регистрации нового юзера заполнить поля First Name,Last Name, UserName.
    Подтвердить, что в данных полях присутствуют введенные значения
    Шаги
    1. Нажать на Log in
    2. Выбрать создание нового пользователя
    3. Ввести данные
    4. Подтвердить, что в поля введены данные
    5. Закрыть браузер
    */

    @Test
    public void testInputDataInRegistrationForm4() {
        mainBookStorePage.logInButtonClick();
        loginPage.newUserButtonClick();

        registrationNewUserPage.typeFirstName("Julia");
        String expectedResultJulia = "Julia";
        String actualResultJulia = registrationNewUserPage.getInputFirstName()
                .getAttribute("value");
        Assert.assertEquals(actualResultJulia, expectedResultJulia);

        registrationNewUserPage.typeLastName("Georg");
        String expectedResultGeorg = "Georg";
        String actualResultGeorg = registrationNewUserPage.getInputLastName()
                .getAttribute("value");
        Assert.assertEquals(actualResultGeorg, expectedResultGeorg);

        registrationNewUserPage.typeUserName("Lololo");
        String expectedResultLololo = "Lololo";
        String actualResultLololo = registrationNewUserPage.getInputUserName()
                .getAttribute("value");
        Assert.assertEquals(actualResultLololo, expectedResultLololo);
    }
}
