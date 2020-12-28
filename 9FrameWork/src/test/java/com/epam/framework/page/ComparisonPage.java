package com.epam.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparisonPage extends AbstractPage{

    private final String COMPARISON_URL="https://www.svyaznoy.by/catalog/compare.php";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath="//*[@class=\"dark_link option-font-bold font_sm\"]/span")
    private WebElement firstAddedProduct;
    @FindBy(xpath = "//span[@title=\"Удалить\"]")
    private WebElement deleteItemFromComparisonButton;
    @FindBy(xpath = "//*[@class=\"notetext\"]")
    private WebElement comparisonCounter;

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    public ComparisonPage DeleteFromComparison()  {
        deleteItemFromComparisonButton.click();
        return this;
    }
    public String getComparisonCounter() throws InterruptedException {
        Thread.sleep(5000);
        return comparisonCounter.getText();
    }
    public String getProductInComparison() {

        return firstAddedProduct.getText();
    }
    @Override
    public ComparisonPage openPage() {
        driver.navigate().to(COMPARISON_URL);
        logger.info("Comparison page opened");
        return this;
    }
}
