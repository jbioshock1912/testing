import org.openqa.selenium.WebElement;

public class ConstantsUtils {
    // url
    public static final String JACKSON_WIKI_URL = "https://en.wikipedia.org/wiki/Michael_Jackson";
    public static final String MAIL_REGISTRATION = "https://account.mail.ru/signup?from=main&rf=auth.mail.ru&app_id_mytracker=58519";

    //xpath
    public static final String THEMES_ANS_GENRES_TEXT = "//p[contains(text(), 'Jackson explored genres including pop')]";
    public static final String TITO_LINK = "//p[contains(text(), 'The eighth child')]/a[@title = 'Tito Jackson']";
    public static final String BIRTH_DAY_LIST = "//div[@data-test-id='birth-date__day']//*[@class='base-0-2-37']";
    public static final String MONTH_LIST = "//div[@data-test-id='birth-date__month']//*[@class='base-0-2-37']";
    public static final String YEAR_LIST = "//div[@data-test-id='birth-date__year']//*[@class='base-0-2-37']";
}
