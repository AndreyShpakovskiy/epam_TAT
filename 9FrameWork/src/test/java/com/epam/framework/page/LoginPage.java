package com.epam.framework.page;

import com.epam.framework.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String PAGE_URL = "https://www.svyaznoy.by/auth/";

	@FindBy(id = "USER_LOGIN_POPUP")
	private WebElement inputLogin;

	@FindBy(id = "USER_PASSWORD_POPUP")
	private WebElement inputPassword;

	@FindBy(xpath = "//*[@id=\"auth-page-form\"]/div[2]/div[2]/button")
	private WebElement buttonSubmit;
	@FindBy(xpath = "//*[@id=\"auth-page-form\"]/div[1]/div[1]")
	private WebElement loginAlert;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public LoginPage openPage()
	{
		driver.navigate().to(PAGE_URL);
		logger.info("Login page opened");
		return this;
	}
	public LoginPage loginWithInvalidPassword(User user) throws InterruptedException {
		inputLogin.sendKeys(user.getUsername());
		inputPassword.sendKeys(user.getPassword());
		buttonSubmit.click();
		return this;
	}
	public String getAlert() throws InterruptedException {
		Thread.sleep(8000);
		return loginAlert.getText();
	}

	public MainPage login(User user)
	{
		inputLogin.sendKeys(user.getUsername());
		inputPassword.sendKeys(user.getPassword());
		buttonSubmit.click();
		logger.info("Login performed");
		return new MainPage(driver);
	}

}
