package com.epam.framework.page;

import com.epam.framework.service.TestDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage  extends AbstractPage{
    private final String BASE_URL = "https://www.svyaznoy.by/";
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//*[@class=\"alert alert-danger\"]")
    private WebElement searchAlert;

    protected SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchAlert() {
        return searchAlert.getText();
    }

    public List<WebElement> getListElements() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/div[2]")));
    }

    @Override
    protected SearchPage openPage() {
        driver.navigate().to(TestDataReader.getTestData(BASE_URL));
        logger.info("Product page opened");
        return this;
    }
}
