package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.IntroPageHelper;

import java.util.List;

public class TestBase {
    public static final String LOGIN = "marinaA";
    public static final String PASSWORD = "marina1!";
    WebDriver driver;
    IntroPageHelper introPage;

    @BeforeMethod
    public void initWebDriver() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        driver.manage().window().fullscreen();
        introPage = PageFactory
                .initElements(driver, IntroPageHelper.class);
        introPage.waitUntilPageLoaded();

        introPage.closeIntroPage();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
