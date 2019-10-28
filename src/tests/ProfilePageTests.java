package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase{

    @BeforeMethod
    public void initTests()  {
        //--- Login to the system ---
        waitUntilElementIsClickable(By.id("idsignin"),20);
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        //Thread.sleep(3000);
        waitUntilElementIsClickable(By.id("signinrequest"),20);

        WebElement loginField = driver.findElement(By.id("logininput"));
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        loginField.click();
        loginField.sendKeys("marinaA");
        passwordField.click();
        passwordField.sendKeys("marina1!");

        driver.findElement(By.id("signinrequest")).click();
        //Thread.sleep(5000);
        waitUntilElementIsClickable(By.id("profile"),20);

        //--- Go to the Profile Page
        driver.findElement(By.id("profile")).click();
        //Thread.sleep(3000);
        waitUntilElementIsClickable(By.id("idbtneditprofile"),20);
        waitUntilTextPresentInElement(By.id("titleprofile"), "My Profile:",20);
        waitUntilElementIsVisible(By.id("imgavatarinprofilefamily"), 20);

    }

    @Test
    public void lastNameOfFamilyChanging()  {

        // --- Open in edit mode ----
        driver.findElement(By.id("idbtneditprofile")).click();
        //Thread.sleep(7000);
        waitUntilElementIsClickable(By.xpath("//span[@id='fieldobjfamilyName']/input"),30);
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"),30);

        //--- Enter new last name ---
        WebElement lastNameField = driver
                .findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("Petrov");

        //Thread.sleep(20000);

        //--- Save profile ---
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"),20);
        driver.findElement(By.id("idbtnsaveprofile")).click();
        waitUntilTextPresentInElement(By
                .xpath("//span[@id='fieldobjfamilyName']/a"),"Petrov", 20);
        //Thread.sleep(5000);
        waitUntilElementIsClickable(By.id("family"),20);

        // --- Go to the family page-----
        driver.findElement(By.id("family")).click();

        //Thread.sleep(5000);
        waitUntilTextPresentInElement(By.id("titleprofile"), "My Family:",30);


        // ---- Return to the profile
        driver.findElement(By.id("profile")).click();
        waitUntilElementIsClickable(By.id("idbtneditprofile"),20);
        waitUntilTextPresentInElement(By.id("titleprofile"), "My Profile:",20);
        waitUntilElementIsVisible(By.id("imgavatarinprofilefamily"), 20);
        //Thread.sleep(3000);

        // --- Open in edit mode ----
        driver.findElement(By.id("idbtneditprofile")).click();
        //Thread.sleep(7000);
        waitUntilElementIsClickable(By.xpath("//span[@id='fieldobjfamilyName']/input"),30);
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"),30);

        //--- Enter new last name ---
        lastNameField = driver
                .findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("Shuster");

       // Thread.sleep(5000);
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"),20);

        //--- Save profile ---
        driver.findElement(By.id("idbtnsaveprofile")).click();
        waitUntilTextPresentInElement(By
                .xpath("//span[@id='fieldobjfamilyName']/a"),"Shuster", 20);

        //Thread.sleep(5000);


        Assert.assertTrue(driver.findElement(By.linkText("Shuster")).isDisplayed(),
                "There is no an element which can be find by linkText('Shuster')");

    }
    @Test
    public void profileAndFamilyPageComparing() {

        String profileConfession = driver.findElement(By.xpath("//span[@id='fieldobjconfession']")).getText();
        System.out.println("Profile confession: " + profileConfession);

        String profileLanguage = driver.findElement(By.cssSelector("#fieldobjlanguages")).getText();
        System.out.println("Profile Language: " + profileLanguage);

        String profileFoodPreference = driver.findElement(By.xpath("//*[@id='fieldobjfoodPreferences']")).getText();
        System.out.println("Profile Food Preference: " + profileFoodPreference);


        //----------------- Go to the Family ------------------------
        waitUntilElementIsClickable(By.id("family"),20);
        driver.findElement(By.id("family")).click();
        //Thread.sleep(5000);
        waitUntilTextPresentInElement(By.id("titleprofile"), "My Family:",30);

        //----------------------Comparing--------------------------

        System.out.println("Confession values are the same for profile and family page: "
                + driver.findElement(By.xpath("//span[@id='fieldobjconfession']"))
                                        .getText().equals(profileConfession));

        System.out.println("Language values are the same for profile and family page: "
                + driver.findElement(By.xpath("//span[@id='fieldobjlanguages']"))
                                        .getText().equals(profileLanguage));

        System.out.println("Food preferences values are the same for profile and family page: "
                + driver.findElement(By.cssSelector(".itemprofilefit > #fieldobjfoodPreferences"))
                                        .getText().equals(profileFoodPreference));
        int counter = 0;
        if (driver.findElement(By.xpath("//span[@id='fieldobjconfession']"))
                .getText().equals(profileConfession)) counter++;
        if (driver.findElement(By.xpath("//span[@id='fieldobjlanguages']"))
                .getText().equals(profileLanguage)) counter++;
        if (driver.findElement(By.cssSelector(".itemprofilefit > #fieldobjfoodPreferences"))
                .getText().equals(profileFoodPreference)) counter++;

        Assert.assertEquals(counter,3);
    }

}
