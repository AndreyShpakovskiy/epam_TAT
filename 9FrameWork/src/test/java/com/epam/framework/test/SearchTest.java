package com.epam.framework.test;

import com.epam.framework.page.MainPage;
import com.epam.framework.service.TestDataReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SearchTest  extends CommonConditions{

    @Test
    public void SearchPhoneTest()
    {
        String SEARCH_REQUEST="testdata.search.request";
        List<WebElement> actualSearchElements = new MainPage(driver)
                .openPage()
                .searchInputText(TestDataReader.getTestData(SEARCH_REQUEST))
                .openSearchPage()
                .getListElements();
        Assert.assertFalse(actualSearchElements.isEmpty());

    }
    @Test
    public void NonExistingElementSearch()
    {
        String expected="Сожалеем, но ничего не найдено.";
        String actual = new MainPage(driver)
                .openPage()
                .searchInputText("wrong search")
                .openSearchPage()
                .getSearchAlert();
        Assert.assertEquals(actual,expected);
    }
}
