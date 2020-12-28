package com.epam.ta.test;

import com.epam.ta.page.CartPage;
import com.epam.ta.page.ComparisonPage;
import com.epam.ta.page.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends CommonConditions{

    @Test
    public void AddToCart() throws InterruptedException {
        String actual= new ProductPage(driver)
                .openPage()
                .addToCart()
                .getProductName();
        String expected= new CartPage(driver)
                .openPage()
                .getProductInCartName();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void DeleteFromCart() throws InterruptedException {
        String expected="В корзине 0 товаров";
        new ProductPage(driver)
                .openPage()
                .addToCart();
        String actual= new CartPage(driver)
                .openPage()
                .DeleteFromCart()
                .getCartCounter();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void AddToFavorite() throws InterruptedException {
        String actual= new ProductPage(driver)
                .openPage()
                .addToFavorite()
                .getProductName();
        String expected= new CartPage(driver)
                .openPage()
                .getProductInFavoriteName();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void AddToComparison() throws InterruptedException {
        String actual= new ProductPage(driver)
                .openPage()
                .addToComparison()
                .getProductName();
        String expected= new ComparisonPage(driver)
                .openPage()
                .getProductInComparison();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void DeleteFromComparison() throws InterruptedException {
        String expected="Список сравниваемых элементов пуст.";
        new ProductPage(driver)
                .openPage()
                .addToComparison();
        String actual= new ComparisonPage(driver)
                .openPage()
                .DeleteFromComparison()
                .getComparisonCounter();
        Assert.assertEquals(actual, expected);
    }
}
