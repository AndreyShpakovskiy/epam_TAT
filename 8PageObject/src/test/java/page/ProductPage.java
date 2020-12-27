package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"bx_117848907_40583_basket_actions\"]/span")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"bx_117848907_40583\"]/div/div[2]/div[1]/div/div[1]/div/div/div[1]/span[1]")
    private WebElement likeButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public ProductPage openPage(String url) {
        driver.get(url);
        return this;
    }
    @Override
    public ProductPage openPage() {
        return null;
    }
}
