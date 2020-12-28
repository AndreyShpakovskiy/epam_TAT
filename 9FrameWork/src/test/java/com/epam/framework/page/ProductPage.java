package com.epam.framework.page;

import com.epam.framework.service.TestDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String PRODUCT_URL= "testdata.product.link";

    @FindBy(xpath = "//*[@id=\"bx_117848907_40583_basket_actions\"]/span")
    private WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div[5]/div[7]/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/span[1]")
    private WebElement likeButton;

    @FindBy(xpath ="//*[@id=\"pagetitle\"]" )
    private WebElement productName;

    @FindBy(xpath ="/html/body/div[5]/div[7]/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div/div[2]/span[1]" )
    private WebElement addToComparisonButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductPage addToCart() throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(8000);
        return this;
}
    public ProductPage addToComparison() throws InterruptedException {
        addToComparisonButton.click();
        Thread.sleep(8000);
        return this;
    }
    public ProductPage addToFavorite() throws InterruptedException {
        likeButton.click();
        Thread.sleep(8000);
        return this;
    }
    public String getProductName() {
        return productName.getText();
    }
    @Override
    public ProductPage openPage() {
        driver.navigate().to(TestDataReader.getTestData(PRODUCT_URL));
        logger.info("Product page opened");
        return this;
    }
}
