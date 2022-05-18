package test_сases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseUtils;

import javax.swing.*;

public class WebTest extends BaseUtils {
    WebDriver driverFireFox = initializeFireFox();

    @BeforeMethod
    public void startBaseUrl() {
        driverFireFox.get("http://www.99-bottles-of-beer.net/");
    }


  /*
TC_11_01 Подтвердите, что на странице по базовой ссылке в правом верхнем углу пользователь видит заголовок 99 Bottles of Beer
Шаги:
1. Открыть вебсайт на базовой странице
2. Считать заголовок в правом верхнем углу
3. Подтвердить, что текст заголовка соответствует ожидаемому
4. Закрыть браузер*/

    @Test
    public void testGetHeader01() {
        String expectedResult = "99 Bottles of Beer";
        String actualResult = driverFireFox.findElement(By.xpath("//div[@id='header']/h1")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

/*
TC_11_02 Подтвердите, что на странице по базовой ссылке последний пункт меню называется Submit new Language
Шаги:
1. Открыть вебсайт на базовой странице
2. Считать название последнего пункта меню
3. Подтвердить, что название последнего пункта меню соответствует ожидаемому
4. Закрыть браузер*/

    @Test
    public void testSubmitNewLanguageMenu02() {
        String expectedResult = "Submit new Language";
        String actualResult = driverFireFox.findElement(By.xpath("//p/a[contains(text(), " +
                "'Submit new Language')]")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

/*
TC_11_03 Подтвердите, что на странице по базовой ссылке последний пункт меню имеет подзаголовок Submit new Language
Шаги:
1. Открыть вебсайт на базовой странице
2. Нажать на пункт меню Submit new Language
3. Считать название подзаголовка последнего пункта меню
4. Подтвердить, что название подзаголовка последнего пункта меню соответствует ожидаемому
5. Закрыть браузер*/

    @Test
    public void testConfirmSubtitleSubmitNewLanguageMenu03() {
        String expectedResult = "Submit New Language";

        driverFireFox.findElement(By.xpath("//p/a[contains(text(), " +
                "'Submit new Language')]")).click();
        String actualResult = driverFireFox.findElement(By.xpath("//ul[@id='submenu']//a")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

/*
TC_11_04 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html , первый пункт подменю называется 0-9
Шаги:
1. Открыть вебсайт на странице
2. Считать название первого подзаголовка
3. Подтвердить, что название подменю соответствует ожидаемому
4. Закрыть браузер*/

    @Test
    public void testConfirmFirstSubmenu04() {
        String expectedResult = "0-9";

        driverFireFox.findElement(By.xpath("//li/a[contains(text(), 'Browse Languages')]")).click();
        String actualResult = driverFireFox.findElement(By.xpath("//li/a[contains(text(), '0-9')]")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    /* TC_11_06 Подтвердите, что имена создателей сайта:
    Oliver Schade
    Gregor Scheithauer
    Stefan Scheler
Шаги:
Напишите самостоятельно (найдите информацию о создателях на сайте, и опишите шаги для навигации и исполнения тест кейса)
1. Открыть вебсайт на странице
2. Нажать на подменю "Team"
3. Найти имена создателей сайта и подтвердить, что это: Oliver Schade, Gregor Scheithauer, Stefan Scheler
4. Закрыть браузер
*/
    @Test
    public void testFindTheCreatorsOfWeb06() {
        String expectedOliver = "Oliver Schade";
        String expectedScheithauer = "Gregor Scheithauer";
        String expectedScheler = "Stefan Scheler";

        driverFireFox.findElement(By.xpath("//a[@href = 'team.html']")).click();

        String actualOliver = driverFireFox.findElement(By.xpath("//h3[contains(text(), 'Oliver Schade')]")).getText();
        Assert.assertEquals(actualOliver, expectedOliver);

        String actualScheithauer = driverFireFox.findElement(By.xpath("//h3[contains(text(), 'Gregor Scheithauer')]")).getText();
        Assert.assertEquals(actualScheithauer, expectedScheithauer);

        String actualScheler = driverFireFox.findElement(By.xpath("//h3[contains(text(), 'Stefan Scheler')]")).getText();
        Assert.assertEquals(actualScheler, expectedScheler);
    }

    /* TC_11_07 Придумайте и автоматизируйте свой собственный тест кейс на сайте http://www.99-bottles-of-beer.net/
 Убедиться, что при повторном голосовании возникает ошибка "Error: You're vote has already been counted."
 Шаги:
 1. Открыть вебсайт на странице
 2. Зайти в меню Browse languages
 3. Выбрать в таблице в первом столбце Abal и кликнуть
 4. При голосовании выбрать из выпадающего меню оценку Good
 5. Проголосовать
 6. Подтвердить, что при повторном голосовании видим ошибку с текстом "Error: You're vote has already been counted."
 7. Закрыть браузер
 */
    @Test
    public void testMessageRepeatVoting07() {
        String expectedResult = "Error: Error. You're vote has already been counted.";

        driverFireFox.findElement(By.xpath("//li/a[contains(text(), 'Browse Languages')]")).click();
        driverFireFox.findElement(By.xpath("//td/a[contains(text(), 'Abal')]")).click();
        driverFireFox.findElement(By.xpath("//select[@name = 'rate']")).click();
        driverFireFox.findElement(By.xpath("//option[@value = '3']")).click();
        driverFireFox.findElement(By.xpath("//input[@value = 'Vote']")).click();

        String actualResult = driverFireFox.findElement(By.cssSelector("#main > p")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    /*TC_11_11 Подтвердите, что если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка
Error: Precondition failed - Incomplete Input.
Шаги:
1. Открыть вебсайт на странице
2. Нажать на кнопку Submit Language
3. Подтвердить, что на странице показана ошибка
4. Подтвердить, что текст ошибки соответствует ожидаемому
5. Закрыть браузер
*/

    @Test
    public void testMessageIncompleteInput11(){
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        driverFireFox.findElement(By.xpath("//li/a[contains(text(), 'Submit new Language')]")).click();
        driverFireFox.findElement(By.xpath("//input[@name='submitlanguage']")).click();

        String actualResult = driverFireFox.findElement(By.cssSelector("#main > p")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    /*TC_11_12 Precondition: Если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
     пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка с текстом
Error: Precondition failed - Incomplete Input.
Подтвертите, что в тексте ошибки слова Error, Precondition, Incomplete и Input написаны с большой буквы, а слово failed  написано  с маленькой буквы.
Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .

Шаги:
1. Открыть вебсайт на странице
2. Нажать на кнопку Submit Language
3. Считать текст ошибки
4. Подтвердить requirenments
5. Закрыть браузер*/






    @AfterMethod
    public void closeBrowser() {
        driverFireFox.quit();
    }
}
