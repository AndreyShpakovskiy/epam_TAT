package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"bx_117848907_40583\"]/div/div[2]/div[1]/div/div[1]/div/div/div[1]/span[1]")
    private WebElement likeButton;
    @FindBy(xpath = "//*[@id=\"mobileheader\"]/div[1]/div[3]/div[1]/div/a[2]/span/span[2]")
    private WebElement LikeCounter;

    public FavoritePage(WebDriver driver) {
        super(driver);
    }
    public FavoritePage addToFavorite() {
        likeButton.click();
        return this;
    }

    public String getCounter() throws InterruptedException {
        Thread.sleep(5000);
        return LikeCounter.getAttribute("innerHTML");
    }
    public FavoritePage openPage(String url) {
        driver.get(url);
        return this;
    }
    @Override
    protected FavoritePage openPage() {
        return null;
    }
}
