import org.openqa.selenium.WebElement;

public class ConstantsUtils {
    // url
    public static final String JACKSON_WIKI_URL = "https://en.wikipedia.org/wiki/Michael_Jackson";
    public static final String MAIL_REGISTRATION_URL = "https://account.mail.ru/signup?from=main&rf=auth.mail.ru&app_id_mytracker=58519";
    public static final String DEMOGA_TEST_URL = "https://demoqa.com/dynamic-properties";
    public static final String DEMOGA_RADIO_BTN_URL = "https://demoqa.com/radio-button";
    //xpath
    public static final String THEMES_ANS_GENRES_XPATH = "//p[contains(text(), 'Jackson explored genres including pop')]";
    public static final String TITO_XPATH = "//p[contains(text(), 'The eighth child')]/a[@title = 'Tito Jackson']";
    public static final String BIRTH_DAY_XPATH = "//div[@data-test-id='birth-date__day']//*[@class='base-0-2-37']";
    public static final String MONTH_XPATH = "//div[@data-test-id='birth-date__month']//*[@class='base-0-2-37']";
    public static final String YEAR_XPATH = "//div[@data-test-id='birth-date__year']//*[@class='base-0-2-37']";
    public static final String DEMOGA_DISABLE_BUTTON_XPATH = "//*[@id='enableAfter']";

    public static final String DEMOGA_YES_CHECK_BTN_XPATH = "//label[@for='yesRadio']";
    public static final String DEMOGA_YES_RADIO_BTN_XPATH = "//*[@id='yesRadio']";

    public static final String DEMOGA_IMPRESSIVE_BTN_XPATH = "*//label[@for='impressiveRadio']";
    public static final String DEMOGA_IMPRESSIVE_RADIO_BTN_XPATH = "//*[@id=\"impressiveRadio\"]";

    public static final String DEMOGA_NO_RADIO_BTN_XPATH = "//*[@id='noRadio']";




}
