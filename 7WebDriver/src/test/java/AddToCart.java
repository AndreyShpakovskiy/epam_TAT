import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class AddToCart {

    WebDriver driver;
    WebElement cartButton;
    @Before
    public final void setUpDriver(){
        driver = new ChromeDriver();
        driver.get("https://www.svyaznoy.by/catalog/phones/telefony/honor/honor-9s-dua-lx9-2gb-32gb-sinij/");
        driver.manage().window().maximize();
        cartButton = driver.findElement(By.xpath("/html/body/div[8]/div[7]/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div[4]/div[1]/div/div[1]/div/div[2]/div[1]/div[2]/span"));
        cartButton.click();
    }
    @After
    public final void shutDownDriver(){
        driver.quit();
    }

    @Test
    public  void testChangeText() {
        String expected="В корзине";
        String actual = driver.findElement(By.xpath("/html/body/div[8]/div[7]/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div[4]/div[1]/div/div[1]/div/div[2]/div[1]/div[2]/a/span")).getAttribute("innerHTML");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCounterChanging() throws InterruptedException {
        Thread.sleep(5000);
        String actual = driver.findElement(By.xpath("/html/body/div[8]/div[5]/div[1]/div[3]/div[1]/div/a[3]/span/span[2]")).getAttribute("innerHTML");
        String expected="1";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testAddedToCart() throws InterruptedException {
        Thread.sleep(5000);
        String expected="Смартфон HONOR 9S DUA-LX9 2GB/32GB (синий)";
        String actual=driver.findElement(By.xpath("/html/body/div[8]/div[2]/header/div[1]/div/div/div/div[1]/div/div/div/div[2]/div[3]/div[1]/div[3]/span/div/form/ul/li/div[1]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/a")).getAttribute("innerHTML");
        Assert.assertEquals(expected,actual);
    }



}