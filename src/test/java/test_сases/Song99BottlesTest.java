package test_сases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import table.MethodTable;
import utils.BaseUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Song99BottlesTest extends BaseUtils {
    WebDriver driverFireFox = initializeFireFox();
    private List<WebElement> textOfSong;
    private List<WebElement> tableHeaders;
    private static final String URL_BASE = "http://www.99-bottles-of-beer.net/";
    private static final By XPATH_BROWSE_LANGUAGES_LINK = By.xpath("//li/a[@href='/abc.html']");
    private static final By XPATH_LETTER_J = By.xpath("//a[@href='j.html']");
    private static final By XPATH_LETTER_M = By.xpath("//a[@href='m.html']");
    private static final By XPATH_MENU_NUMBERS = By.xpath("//a[@href = '0.html']");
    private static final By XPATH_DESCRIPTION_CATEGORY_J = By.xpath("//p[contains(text(), 'All languages')]");
    private static final By XPATH_TEXT_OF_SONG = By.xpath("//div[@id='main']/p");
    private static final By XPATH_LAST_LANGUAGE = By.xpath("//tr[last()]/td/a");
    private static final By XPATH_FIRST_TABLE_HEADERS = By.xpath("//tbody/tr/th");
    private static final By XPATH_TABLE_WITHOUT_HEADERS_START_NUMBER = By.xpath("//tbody/tr[position()>1]");
    private static final By XPATH_GUESTBOOK_MENU = By.xpath("//li/a[@href='/guestbookv2.html']");
    private static final By XPATH_SIGN_GUESTBOOK_MENU = By.xpath("//li/a[@href='./signv2.html']");
    private static final By XPATH_INPUT_NAME = By.xpath("//input[@name='name']");
    private static final By XPATH_INPUT_LOCATION = By.xpath("//input[@name='location']");
    private static final By XPATH_INPUT_EMAIL = By.xpath("//input[@name='email']");
    private static final By XPATH_INPUT_HOME_PAGE = By.xpath("//input[@name='homepage']");
    private static final By XPATH_INPUT_SECURITY_CODE = By.xpath("//input[@name='captcha']");
    private static final By XPATH_SUBMIT_BUTTON = By.xpath("//input[@name='submit']");
    private static final By XPATH_ERROR_MESSAGE = By.xpath("//div[@id='main']/p");

    /* Подтвердить текст песни "99 bottles of beer on the wall..."
    Шаги
    1 Перейти сразу по адресу http://www.99-bottles-of-beer.net/lyrics.html
    2 Считать текст песни в коде (проверка функциональности, не ю ай)
    3 Подтвердить текстп песни
    */
    public static String constructorForSong() {
        String song = "";
        String startText = "99 bottles of beer on the wall, 99 bottles of beer.\n";
        String finalText = "Take one down and pass it around, 1 bottle of beer on the wall.1 bottle of beer on the wall, 1 bottle of beer.\n" +
                "Take one down and pass it around, no more bottles of beer on the wall.No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.";

        for (int i = 98; i > 1; i--) {
            song = song + String.format("Take one down and pass it around, " + i + " bottles of beer on the wall." +
                    i + " bottles of beer on the wall, " + i + " bottles of beer.\n");
        }
        return startText + song + finalText;
    }

    @Test
    public void testSongLyricTest() {
        String expectedResult = constructorForSong();
        driverFireFox.get("http://www.99-bottles-of-beer.net/lyrics.html");
        textOfSong = driverFireFox.findElements(XPATH_TEXT_OF_SONG);

        String actualResult = "";
        for (WebElement value : textOfSong) {
            actualResult = actualResult + value.getText();
        }
        Assert.assertEquals(actualResult, expectedResult);
    }

    /*TC_12_01 Подтвердите, что в меню BROWSE LANGUAGES, подменю  J, пользователь может найти описание страницы,
    на которой перечеслены все программные языки, начинающиеся с буквы J,  отсортированные по названию
     Шаги:
   1 Открыть базовую страницу
   2 Нажать на пункт меню BROWSE LANGUAGES
   3 Нажать на подменю J
   4 Подтвердить, что пользователь видит текст “All languages starting with the letter J are shown, sorted by Language.”*/

    @Test
    public void testConfirmThePageDescription() {
        String expectedResult = "All languages starting with the letter J are shown, sorted by Language.";

        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_BROWSE_LANGUAGES_LINK).click();
        driverFireFox.findElement(XPATH_LETTER_J).click();

        String actualResult = driverFireFox.findElement(XPATH_DESCRIPTION_CATEGORY_J).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    /*TC_12_02 Подтвердите, что в меню BROWSE LANGUAGES, подменю  M, последний программный язык в таблице -  MySQL
     Шаги:
   1 Открыть базовую страницу
   2 Нажать на пункт меню BROWSE LANGUAGES
   3 Нажать на подменю M
   4 Подтвердить, что последний язык программирования на странице - MySQL*/
    @Test
    public void testConfirmLastLanguage() {
        String expectedResult = "MySQL";

        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_BROWSE_LANGUAGES_LINK).click();
        driverFireFox.findElement(XPATH_LETTER_M).click();

        String actualResult = driverFireFox.findElement(XPATH_LAST_LANGUAGE).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    /*TC_12_03 Подтвердите, что в меню BROWSE LANGUAGES существует таблица с заголовками Language, Author, Date, Comments, Rate
    Шаги:
   1 Открыть базовую страницу
   2 Нажать на пункт меню BROWSE LANGUAGES
   3 Подтвердить, что на данной странице существует таблица с заголовками Language, Author, Date, Comments, Rate
   */
    @Test
    public void testConfirmTableHeaders() {
        List<String> expectedTableHeaders = Arrays.asList("Language", "Author", "Date", "Comments", "Rate");
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_BROWSE_LANGUAGES_LINK).click();
        tableHeaders = driverFireFox.findElements(XPATH_FIRST_TABLE_HEADERS);
        int actualResultSize = tableHeaders.size();

        Assert.assertEquals(actualResultSize, 5);

        List<String> actualTableHeaders = new ArrayList<>();
        for (WebElement value : tableHeaders) {
            actualTableHeaders.add(value.getText());
        }

        Assert.assertEquals(actualTableHeaders, expectedTableHeaders);
    }

    /*TC_12_04 Подтвердите, что создатель решения на языке Mathematica - Brenton Bostick, дата обновления решения на
    этом языке - 03/16/06, и что это решение имеет 1 комментарий
    Шаги:
    1 Открыть базовую страницу
    2 Нажать на пункт меню BROWSE LANGUAGES
    3 Нажать на подменю с буквой M
    4 Подтвердить, что создатель решения на языке Mathematica - Brenton Bostick, дата обновления решения на
    этом языке - 03/16/06, и что это решение имеет 1 комментарий
    */

    @Test
    public void testConfirmColumnValuesInRow() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_BROWSE_LANGUAGES_LINK).click();
        driverFireFox.findElement(XPATH_LETTER_M).click();
        String[] expectedlArray = {"Mathematica", "Brenton Bostick", "03/16/06", "1"};
        String[] actualArray = new String[4];
        for (int i = 0; i < 4; i++) {
            int position = i + 1;
            actualArray[i] = driverFireFox.findElement(By
                            .xpath("//a[@href='language-mathematica-1090.html']/ancestor-or-self::tr/td[" + position + "]"))
                    .getText();
        }
        Assert.assertEquals(actualArray, expectedlArray);
    }

   /* TC_12_05 Подтвердите, что на сайте существует 10 языков, названия которых начинаются с цифр.
     Шаги:
    1 Открыть базовую страницу
    2 Нажать на пункт меню BROWSE LANGUAGES
    3 Нажать на подменю 0-9
    4
    */

    @Test
    public void testConfirmCountOfLanguages() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_BROWSE_LANGUAGES_LINK).click();
        driverFireFox.findElement(XPATH_MENU_NUMBERS).click();
        List<WebElement> languagesStartWithNumber = driverFireFox
                .findElements(XPATH_TABLE_WITHOUT_HEADERS_START_NUMBER);

        Assert.assertTrue(languagesStartWithNumber.size() == 10);
    }

    /* TC_12_06 Подтвердите, что если на странице Sign Guestbook
     http://www.99-bottles-of-beer.net/signv2.html вы заполните все поля формы,
      но введете случайно сгенерированное трехзначное число в поле  Security Code: ,
      то вы получите сообщение об ошибке  Error: Error: Invalid security code.
      Шаги:
      1 Открыть базовую страницу
      2 Выбрать подменю GUESTBOOK, кликнуть
      3 Выбрать подменю Sign Guestbook, кликнуть
      4 Заполнить поля формы и ввести рандомное число в поле Security Code, нажать submit
      5 Подтвердить, что приходит сообщение Error: Please enter at least a message, your email address and the security code.
 */
    @Test
    public void testFillRegistrationFormAndConfirmErrorNegative() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_GUESTBOOK_MENU).click();
        driverFireFox.findElement(XPATH_SIGN_GUESTBOOK_MENU).click();
        driverFireFox.findElement(XPATH_INPUT_NAME).sendKeys("Name");
        driverFireFox.findElement(XPATH_INPUT_LOCATION).sendKeys("London");
        driverFireFox.findElement(XPATH_INPUT_EMAIL).sendKeys("email_test@mail.com");
        driverFireFox.findElement(XPATH_INPUT_HOME_PAGE).sendKeys("testing");
        int randomNumber = (int) (100 + Math.random() * 900);
        driverFireFox.findElement(XPATH_INPUT_SECURITY_CODE).sendKeys(randomNumber + "");
        driverFireFox.findElement(XPATH_SUBMIT_BUTTON).click();
        String actualResult = driverFireFox.findElement(XPATH_ERROR_MESSAGE).getText();
        Assert.assertEquals(actualResult, "Error: Please enter at least a message, your email address and the security code.");
    }
}
