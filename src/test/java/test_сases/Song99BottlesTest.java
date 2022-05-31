package test_сases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseUtils;

import java.util.*;

public  class Song99BottlesTest extends BaseUtils {
    WebDriver driverFireFox;
    private List<WebElement> textOfSong;
    private List<WebElement> tableHeaders;
    private static final String URL_BASE = "http://www.99-bottles-of-beer.net/";
    private static final By XPATH_BROWSE_LANGUAGES_LINK = By.xpath("//li/a[@href='/abc.html']");
    private static final By XPATH_TOP_LIST_LINK = By.xpath("//li/a[@href='/toplist.html']");
    private static final By XPATH_TOP_RATED_ESOTERIC = By.xpath("//a[@href='./toplist_esoteric.html']");
    private static final By XPATH_TOP_HITS = By.xpath("//a[@href='./tophits.html']");
    private static final By XPATH_TOP_RATED_REAL = By.xpath("//a[@href='./toplist_real.html']");
    private static final By XPATH_LETTER_J = By.xpath("//a[@href='j.html']");
    private static final By XPATH_LETTER_M = By.xpath("//a[@href='m.html']");
    private static final By XPATH_LETTER_A = By.xpath("//a[@href='a.html']");
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
    private static final By XPATH_INPUT_MESSAGE = By.xpath("//textarea[@name='comment']");
    private static final By XPATH_SUBMIT_BUTTON = By.xpath("//input[@name='submit']");
    private static final By XPATH_ERROR_MESSAGE = By.xpath("//div[@id='main']/p");
    private static final By XPATH_ABAL_LANGUAGE = By.xpath("//a[@href='language-abal-712.html']");
    private static final By XPATH_JAVA_LANGUAGE = By.xpath("//a[@href=\"language-java-3.html\"]");
    private static final By XPATH_TABLE_ALTERNATIVE_VERSION = By.xpath("//div[@id='alternatives']/table");
    private static final By XPATH_JAVA_STANDARD_VERSION = By.xpath("//a[@href='language-java-4.html']");
    private static final By XPATH_ADD_TO_REDDIT = By.xpath("//a[@title='reddit']");
    private static final By XPATH_TABLE_CELL_OF_LANGUAGE = By.xpath("//tr/td[2]");

    @BeforeMethod
    public void createBrowser() {
       driverFireFox = initializeFireFox();
    }

    /* Подтвердить текст песни "99 bottles of beer on the wall..."
    Шаги
    1 Перейти сразу по адресу http://www.99-bottles-of-beer.net/lyrics.html
    2 Считать текст песни в коде (проверка функциональности, не ю ай)
    3 Подтвердить текстп песни
    */
    public static String constructorForSong() {
        StringBuilder song = new StringBuilder();
        String startText = "99 bottles of beer on the wall, 99 bottles of beer.\n";
        String finalText = "Take one down and pass it around, 1 bottle of beer on the wall.1 bottle of beer on the wall, 1 bottle of beer.\n" +
                "Take one down and pass it around, no more bottles of beer on the wall.No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.";

        for (int i = 98; i > 1; i--) {
            song.append(String.format("Take one down and pass it around, " + i + " bottles of beer on the wall." +
                    i + " bottles of beer on the wall, " + i + " bottles of beer.\n"));
        }
        return startText + song + finalText;
    }

    @Test
    public void testSongLyricTest() {
        String expectedResult = constructorForSong();
        driverFireFox.get("http://www.99-bottles-of-beer.net/lyrics.html");
        textOfSong = driverFireFox.findElements(XPATH_TEXT_OF_SONG);

        StringBuilder actualResult = new StringBuilder();
        for (WebElement value : textOfSong) {
            actualResult.append(value.getText());
        }
        Assert.assertEquals(actualResult.toString(), expectedResult);
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
        String code = Integer.toString(randomNumber);
        driverFireFox.findElement(XPATH_INPUT_SECURITY_CODE).sendKeys(code);
        driverFireFox.findElement(XPATH_INPUT_MESSAGE).sendKeys("testing");
        driverFireFox.findElement(XPATH_SUBMIT_BUTTON).click();
        String actualResult = driverFireFox.findElement(XPATH_ERROR_MESSAGE).getText();
        Assert.assertEquals(actualResult, "Error: Error: Invalid security code.");
    }

    /*  TC_12_07 Выберите любой язык программирования (из меню BROWSE LANGUAGES) и любую версию решения (из раздела
      Alternative Versions, если такой раздел существует  для выбранного языка)
     Раздел с альтернативными версиями отсутвует:
      Шаги:
      1 Открыть базовую страницу
      2 Нажать на пункт меню BROWSE LANGUAGES
      3 Выбрать подменю с буквой A
      4 Выбрать из таблицы язык Language Abal
      5 Подтвердить, что в данном языке отсутствует таблицы с альтернативными версиями

      Раздел с альтернативными версиями присутствует:
      1 Открыть базовую страницу
      2 Нажать на пункт меню BROWSE LANGUAGES
      3 Выбрать подменю с буквой J
      4 Выбрать язык Java
      5 Убедиться, что есть таблица с альтернативными версиями
      6 Выбрать версию standard version, кликнуть
      7 Выбрать Bookmarking - reddit, кликнуть
      8 Подтвердите, что пользователь может сделать закладку на это решение на сайте Reddit
      (нажав на иконку сайта Reddit, пользователь перейдет на Логин страницу сайта Reddit)

 */
    @Test
    public void testConfirmNoAlternativeVersion() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_BROWSE_LANGUAGES_LINK).click();
        driverFireFox.findElement(XPATH_LETTER_A).click();
        driverFireFox.findElement(XPATH_ABAL_LANGUAGE).click();
        List<WebElement> table = driverFireFox.findElements(XPATH_TABLE_ALTERNATIVE_VERSION);
        Assert.assertEquals(table.size(), 0);
    }

    @Test
    public void testConfirmAlternativeVersionAndReddit() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_BROWSE_LANGUAGES_LINK).click();
        driverFireFox.findElement(XPATH_LETTER_J).click();
        driverFireFox.findElement(XPATH_JAVA_LANGUAGE).click();

        List<WebElement> table = driverFireFox.findElements(XPATH_TABLE_ALTERNATIVE_VERSION);
        Assert.assertTrue(table.size() > 0);

        driverFireFox.findElement(XPATH_JAVA_STANDARD_VERSION).click();
        driverFireFox.findElement(XPATH_ADD_TO_REDDIT).click();
        String currentURL = driverFireFox.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("www.reddit.com/login"));
    }

    /*TC_12_08 Подтвердите, что решение на языке Shakespeare входит в топ 20 всех решений, в топ 10 решений на Esoteric
    Languages и в топ 6 решений-хитов. Но решение на языке Shakespeare не входит в список топовых решений на реальных языках программирования.
    (Можно написать одним тестом, но так, чтобы все Asserts были в конце теста. Или можно написать отдельные тесты на каждый requirenment.)
//tr/td[2]
       Шаги:
       1 Открыть базовую страницу
       2 Выбрать меню TOP LISTS
       3 Подтвердите, что решение на языке Shakespeare входит в топ 20 всех решений

       Шаги:
       1 Открыть базовую страницу
       2 Выбрать меню TOP LISTS
       3 Выбрать Top Rated Esoteric Languages
       4 Подтвердить, что решение на языке Shakespeare входит  в топ 10 решений на Esoteric Languages

       Шаги:
       1 Открыть базовую страницу
       2 Выбрать меню TOP LISTS
       3 Выбрать меню TOP HITS
       4 Подтвердить, что решение на языке Shakespeare входит в топ 6 решений-хитов

         Шаги:
       1 Открыть базовую страницу
       2 Выбрать меню TOP LISTS
       3 Выбрать Top Rated Real Languages
       4 Подтвердить, что решение на языке Shakespeare
       не входит в список топовых решений на реальных языках программирования
*/

    @Test
    public void testConfirmIncludedInCommonTopShakespeare() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_TOP_LIST_LINK).click();
        int actualIndex = getIndexFromTableTopLists("Shakespeare");
        System.out.println(actualIndex);
        Assert.assertTrue(actualIndex < 21);
    }

    @Test
    public void testConfirmIncludedInEsotericTopShakespeare() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_TOP_LIST_LINK).click();
        driver.findElement(XPATH_TOP_RATED_ESOTERIC).click();
        int actualIndex = getIndexFromTableTopLists("Shakespeare");
        System.out.println(actualIndex);
        Assert.assertTrue(actualIndex < 11);
    }

    @Test
    public void testConfirmIncludedInHitsTopShakespeare() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_TOP_LIST_LINK).click();
        driverFireFox.findElement(XPATH_TOP_HITS).click();
        int actualIndex = getIndexFromTableTopLists("Shakespeare");
        System.out.println(actualIndex);
        Assert.assertTrue(actualIndex < 7);
    }

    @Test
    public void testConfirmNotIncludedInRealTopShakespeare() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_TOP_LIST_LINK).click();
        driverFireFox.findElement(XPATH_TOP_RATED_REAL).click();
        int actualIndex = getIndexFromTableTopLists("Shakespeare");
        System.out.println(actualIndex);
        Assert.assertEquals(actualIndex, Integer.MAX_VALUE);
    }

    private int getIndexFromTableTopLists(String language) {
        List<WebElement> table = driverFireFox.findElements(XPATH_TABLE_CELL_OF_LANGUAGE);
        int index = Integer.MAX_VALUE;
        for (WebElement languageCell : table) {
            if (languageCell.getText().contains(language)) {
                index = table.indexOf(languageCell) + 1;
                break;
            }
        }
        return index;
    }

    /*TC_12_09 Подтвердите, что существует 6 версий решений на языке программирования Java.
     Шаги:
     1 Открыть базовую страницу
     2 Нажать на пункт меню BROWSE LANGUAGES
     3 Выбрать подменю с буквой J
     4 Выбрать язык Java
     5 Убедиться, что существует 6 версий решений на данном языке
    */
    @Test
    public void testConfirmNumberOfVersionJava() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_BROWSE_LANGUAGES_LINK).click();
        driverFireFox.findElement(XPATH_LETTER_J).click();
        driverFireFox.findElement(XPATH_JAVA_LANGUAGE).click();
        List<WebElement> table = driverFireFox.findElements(By.xpath("//table[@id='category']//td[1]"));
        int actualResult = table.size() + 1;
        Assert.assertEquals(actualResult, 6);
    }

    /* TC_12_10 Подтвердите, что самое большое количество комментариев для решений на языке Java имеет версия “standard version”
    Шаги:
      1 Открыть базовую страницу
      2 Нажать на пункт меню BROWSE LANGUAGES
      3 Выбрать подменю с буквой J
      4 Выбрать язык Java
      5 Найти версию с самым большим количеством комментариев и убедиться, что (object-oriented version)
    */
    @Test
    public void testConfirmMaxNumberOfCommentsJava() {
        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_BROWSE_LANGUAGES_LINK).click();
        driverFireFox.findElement(XPATH_LETTER_J).click();
        driverFireFox.findElement(XPATH_JAVA_LANGUAGE).click();
        List<WebElement> valueCellVersionFromTable = driverFireFox.findElements(By.xpath("//table[@id='category']//td[1]"));
        List<WebElement> valueCellCommentsFromTable = driverFireFox.findElements(By.xpath("//table[@id='category']//td[4]"));

        Map<String, Integer> versionWithComments = new HashMap<>();
        String oopJava = driverFireFox.findElement(By.xpath("//table/preceding-sibling::p")).getText();
        int numberOfCommentsOOPJava = Integer.parseInt(driverFireFox
                .findElement(By
                        .xpath("//strong[contains(text(), 'Comments:')]/following::td[1]"))
                .getText());
        versionWithComments.put(oopJava, numberOfCommentsOOPJava);

        for (int i = 0; i < 5; i++) {
            String keyVersion = valueCellVersionFromTable.get(i).getText();
            int valueNumberComments = Integer.parseInt(valueCellCommentsFromTable.get(i).getText());
            versionWithComments.put(keyVersion, valueNumberComments);
        }

        int maxComments = 0;
        String versionWithMaxComments = "";

        for (Map.Entry<String, Integer> entry : versionWithComments.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (maxComments < entry.getValue()) {
                maxComments = entry.getValue();
                versionWithMaxComments = entry.getKey();

            }
        }
        System.out.println(maxComments);
        System.out.println(versionWithMaxComments);
        Assert.assertEquals(versionWithMaxComments, "(object-oriented version)");
    }

    @AfterMethod
    public void closeBrowser() {
        driverFireFox.quit();
    }
}

