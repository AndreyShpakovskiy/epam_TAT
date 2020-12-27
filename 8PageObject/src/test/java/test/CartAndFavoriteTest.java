package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CartPage;
import page.FavoritePage;
import page.ProductPage;

public class CartAndFavoriteTest {

    private static WebDriver driver;
    @Before
    public final void setUpDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public final void shutDownDriver(){
        driver.quit();
        driver = null;
    }

    @Test
    public void testCart() throws InterruptedException {
        String productPage = "https://www.svyaznoy.by/catalog/phones/telefony/honor/honor-9s-dua-lx9-2gb-32gb-sinij/";
        String expectedButtonText="В КОРЗИНЕ";
        String actualButtonText=new CartPage(driver)
                .openPage(productPage)
                .addToCart()
                .getButtonText();
        Assert.assertEquals(expectedButtonText, actualButtonText);
    }

    @Test
    public void testFavorite() throws InterruptedException {
        String productPage ="https://www.svyaznoy.by/catalog/phones/telefony/honor/honor-9s-dua-lx9-2gb-32gb-sinij/";
        String expectedCounter="1";
        String actualCounter=new FavoritePage(driver)
                .openPage(productPage)
                .addToFavorite()
                .getCounter();
        Assert.assertEquals(expectedCounter, actualCounter);

    }

}