package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.reporters.jq.Main;
import util.CustomConditions;
import util.Utils;

import java.util.List;

public class MainPage extends AbstractPage
{

	private static final String BASE_URL = "https://www.mvideo.ru/";

	@FindBy (xpath = "//input[@id='header-search-input']")
	private WebElement searchInput;

	@FindBy (xpath = "//button[@class='c-text-field__search-button']")
	private WebElement searchButton;

	@FindBy(xpath = "//span[@class='suggested-search-text ']")
	private List<WebElement> suggestedItemsList;

	private static final By bySuggestedItemsList = By
			.xpath("//span[@class='suggested-search-text ']");

	public MainPage()
	{
		super();
	}

	public PostNavBarPage clickOnNavBarOption(String option) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//div[@class='header-collection__list-wrapper']" +
						"/div[@class='header-collection__list']" +
						"/a[@class='header-collection__item' and contains(text(), '"
						+ option + "')]"))).click();
		return new PostNavBarPage();
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Opened page " + BASE_URL);
		return this;
	}

	public MainPage enterSearchQuery(String query) {
		searchInput.sendKeys(query);
		return this;
	}

	public List<String> getSuggestedItemsList(){
		driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(bySuggestedItemsList));
		return Utils.parseListOfWebElementsToListOfStrings(suggestedItemsList);
	}

	public SearchResultsPage searchForQuery() {
		searchButton.click();
		return new SearchResultsPage();
	}

}
