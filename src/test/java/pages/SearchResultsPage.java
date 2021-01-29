package pages;

import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage extends BasePage {

    public static final By HOTEL_NAME_CSS = By.cssSelector(".sr-hotel__name ");
    public static final By AVAILABLE_PROPERTIES_CSS = By.cssSelector(".sr_header ");

    public String ratingPattern = "//*[contains(text(),'%s')]/ancestor::*[contains(@class, 'sr_item_content')]" +
            "//*[@class='bui-review-score__badge']";

    public List<String> getHotelNames() {
        isPageOpened();
        return $$(HOTEL_NAME_CSS).texts();
    }

    public String getRating(String hotelName) {
        isPageOpened();
        return $(By.xpath(String.format(ratingPattern, hotelName))).getText().trim();
    }

    @Override
    protected void isPageOpened() {
        explicitWaitElementVisible(AVAILABLE_PROPERTIES_CSS);
    }
}
