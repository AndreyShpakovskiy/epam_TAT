package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"bx_117848907_40583_basket_actions\"]/span")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"bx_117848907_40583_basket_actions\"]/a/span")
    private WebElement buttonText;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public CartPage addToCart() {
        addToCartButton.click();
        return this;
    }
    public String getButtonText() throws InterruptedException {
        Thread.sleep(5000);
        return buttonText.getText();
    }

    @Override
    protected CartPage openPage() {
        return null;
    }
    public CartPage openPage(String url) {
        driver.get(url);
        return this;
    }
}
