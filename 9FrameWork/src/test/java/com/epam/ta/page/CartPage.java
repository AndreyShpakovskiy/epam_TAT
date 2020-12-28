package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    private final String CART_URL="https://www.svyaznoy.by/basket/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@data-entity=\"basket-item-name\"]")
    private WebElement firstAddedProduct;
    @FindBy(xpath = "//*[@class=\"basket-item-actions-remove\"]")
    private WebElement deleteItemFromCart;
    @FindBy(xpath = "//*[@id=\"basket-items-list-wrapper\"]/div[1]/div[2]/a[1]")
    private WebElement cartCounter;

    public CartPage DeleteFromCart() throws InterruptedException {
        deleteItemFromCart.click();
        Thread.sleep(8000);
        return this;
    }
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductInCartName() {
        return firstAddedProduct.getText();
    }
    public String getProductInFavoriteName() {
        return firstAddedProduct.getText();
    }

    public String getCartCounter() {
        return cartCounter.getText();
    }
    @Override
    public CartPage openPage() {
        driver.navigate().to(CART_URL);
        logger.info("Cart page opened");
        return this;
    }
}
