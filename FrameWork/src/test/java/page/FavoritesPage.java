package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavoritesPage extends AbstractPage {
    private static final String BASE_URL = "https://www.mvideo.ru/wish-list";

    private static final By byItemName = By.xpath("//h3[@class='wishlist-product-title']");

    @FindBy (xpath = "//div[@class='wishlist-item-holder']")
    private List<WebElement> addedItems;

    public FavoritesPage() {
        super();
    }

    @Override
    public FavoritesPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Opened page " + BASE_URL);
        return this;
    }

    public String getItemNameByIndex(int index) {
        return addedItems.get(index).findElement(byItemName).getText();
    }
}
