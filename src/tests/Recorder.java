package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Recorder {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://www.negevjobs.co.il/");
        driver.findElement(By.linkText("הייטק")).click();
        driver.findElement(By.linkText("QA")).click();
        driver.findElement(By.linkText("פתיחת חשבון")).click();
        driver.findElement(By.linkText("מחפש עבודה?")).click();
        driver.findElement(By.id("first_name")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='הרשמה למערכת'])[1]/following::h4[1]")).click();
        driver.findElement(By.id("last_name")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("repassword")).click();
        driver.findElement(By.id("function")).click();
        driver.findElement(By.linkText("הוסף")).click();
        assertEquals(closeAlertAndGetItsText(), "נא לבחור תחום/ תת - תחום");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ניתן לקבל משרות חמות מסוכן חכם על ידי בחירת שתי קטגוריות'])[1]/following::select[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ניתן לקבל משרות חמות מסוכן חכם על ידי בחירת שתי קטגוריות'])[1]/following::select[2]")).click();
        driver.findElement(By.id("primary-cat")).click();
        new Select(driver.findElement(By.id("primary-cat"))).selectByVisibleText("תחום לימוד");
        driver.findElement(By.id("primary-cat")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ניתן לקבל משרות חמות מסוכן חכם על ידי בחירת שתי קטגוריות'])[1]/following::select[3]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ניתן לקבל משרות חמות מסוכן חכם על ידי בחירת שתי קטגוריות'])[1]/following::select[3]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='אזורים'])[1]/following::select[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='אזורים'])[1]/following::select[2]")).click();
        driver.findElement(By.name("primary_locale")).click();
        new Select(driver.findElement(By.name("primary_locale"))).selectByVisibleText("באר שבע והסביבה");
        driver.findElement(By.name("primary_locale")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
