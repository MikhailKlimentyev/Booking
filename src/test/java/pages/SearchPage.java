package pages;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage extends BasePage {

    public static final String URL = "https://www.booking.com/searchresults.en-gb.html";

    public static final By LOCATION_ID = By.id("ss");
    public static final By SEARCH_BUTTON_CSS = By.cssSelector(".sb-searchbox__button ");

    public void openPage() {
        open(URL);
    }

    public void enterLocation(String location) {
        $(LOCATION_ID).sendKeys(location);
    }

    public void clickOnSearchButton() {
        Configuration.clickViaJs = true;
        $(SEARCH_BUTTON_CSS).click();
        Configuration.clickViaJs = false;
    }

    @Override
    public void isPageOpened() {
        explicitWaitElementVisible(SEARCH_BUTTON_CSS);
    }
}
