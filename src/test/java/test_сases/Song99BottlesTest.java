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
    List<WebElement> textOfSong;

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
        textOfSong = driverFireFox.findElements(By.xpath("//div[@id='main']/p"));

        String actualResult = "";
        for (WebElement value : textOfSong) {
            actualResult = actualResult + value.getText();
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
}
