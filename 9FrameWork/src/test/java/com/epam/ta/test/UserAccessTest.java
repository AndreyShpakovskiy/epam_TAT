package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.LoginPage;
import com.epam.ta.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UserAccessTest extends CommonConditions {
	@Test
	public void oneCanLogin() {
		User testUser = UserCreator.withCredentialsFromProperty();
		String loggedInUserName = new LoginPage(driver)
				.openPage()
				.login(testUser)
				.getLoggedInUserName();
		assertThat(loggedInUserName, is(equalTo(testUser.getUsername())));
	}
	@Test
	public void LoginWithInvalidPasswordTest() throws InterruptedException {
		User testUser=UserCreator.withWrongPasswordFromProperty();
		String expected="Неверный логин или пароль.";
		String actual= new LoginPage(driver)
				.openPage()
				.loginWithInvalidPassword(testUser)
				.getAlert();
		Assert.assertEquals(actual, expected);

	}
}
