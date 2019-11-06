package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageAuthHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import pages.WebLoginPageHelper;

public class WebLoginPageTests extends TestBase{
    HomePageHelper homePage;
    HomePageAuthHelper homePageAuth;
    LoginPageHelper loginPage;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        //loginPage = new WebLoginPageHelper(driver);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        homePageAuth = PageFactory.initElements(driver, HomePageAuthHelper.class);
        loginPage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
    }

    @Test
    public void webLoginPositive()  {

        loginPage.loginToTheSystem(LOGIN,PASSWORD);
        homePageAuth.waitUntilPageIsLoaded();
        Assert.assertTrue(homePageAuth.correctPageIsLoaded());

 }

 @Test
 public void webNegativeLogin()  {

     loginPage.loginToTheSystem(LOGIN,"123");
     Assert.assertTrue(loginPage.loginToTheSystemIncorrect());

     loginPage.closeLoginWindowByX();
     homePage.waitUntilPageIsLoaded();
     Assert.assertTrue(homePage.correctPageIsLoaded());
 }
}
