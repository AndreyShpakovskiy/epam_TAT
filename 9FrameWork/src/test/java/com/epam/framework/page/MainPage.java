package com.epam.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://www.svyaznoy.by/";

	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div[1]/div/div/div/div/div[3]/div/a")
	private WebElement personalDataLink;

	@FindBy(xpath = "//*[@id=\"title-search-input_fixed\"]")
	private WebElement searchField;

	@FindBy(xpath = "//*[@id=\"title-search_fixed\"]/form/div[2]/button")
	private WebElement searchButton;

	private final By linkLoggedInUserLocator = By.xpath("//*[@id=\"content\"]/div[2]/div/div[1]/div/div/div/div/div/form/div[2]/div/div[1]/input");

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public MainPage searchInputText(String text) {
		searchField.sendKeys(text);
		return this;
	}

	public SearchPage openSearchPage() {
		searchButton.click();
		return new SearchPage(driver);
	}
	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

	public String getLoggedInUserName() {
		WebElement personalDataLinkWait= new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(personalDataLink));
		personalDataLink.click();
		WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
		return linkLoggedInUser.getAttribute("value");
	}
}
