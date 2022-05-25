package test_сases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseUtils;
import java.util.List;

public class Song99BottlesTest extends BaseUtils {
    WebDriver driverFireFox = initializeFireFox();
    private List<WebElement> textOfSong;
    private static final String URL_BASE= "http://www.99-bottles-of-beer.net/";
    private static final By XPATH_BROWSE_LANGUAGES_LINK  = By.xpath("//li/a[@href='/abc.html']");
    private static final By XPATH_LETTER_J = By.xpath("//a[@href='j.html']");
    private static final By XPATH_LETTER_M = By.xpath("//a[@href='m.html']");
    private static final By XPATH_DESCRIPTION_CATEGORY_J = By.xpath("//p[contains(text(), 'All languages')]");
    private static final By XPATH_TEXT_OF_SONG = By.xpath("//div[@id='main']/p");
    private static final By XPATH_LAST_LANGUAGE = By.xpath("//tr[last()]/td/a");

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
    public void testConfirmThePageDescription(){
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
    public void testConfirmLastLanguage(){
        String expectedResult = "MySQL";

        driverFireFox.get(URL_BASE);
        driverFireFox.findElement(XPATH_BROWSE_LANGUAGES_LINK).click();
        driverFireFox.findElement(XPATH_LETTER_M).click();

        String actualResult = driverFireFox.findElement(XPATH_LAST_LANGUAGE).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
