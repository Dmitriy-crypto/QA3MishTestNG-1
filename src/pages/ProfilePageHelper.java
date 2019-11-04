package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePageHelper extends PageBase {
    public ProfilePageHelper(WebDriver driver) {
        super(driver);
    }

    public ProfilePageHelper openProfilePage() {
        driver.findElement(By.id("profile")).click();
        waitUntilPageLoaded();
        return this;
    }

    public ProfilePageHelper waitUntilPageLoaded(){
        waitUntilElementIsClickable(By.id("idbtneditprofile"),20);
        waitUntilTextPresentInElement(By.id("titleprofile"), "My Profile:",20);
        waitUntilElementIsVisible(By.id("imgavatarinprofilefamily"), 20);
        return this;
    }

    public ProfilePageHelper openEditMode() {
        driver.findElement(By.id("idbtneditprofile")).click();
        waitUntilElementIsClickable(By.xpath("//span[@id='fieldobjfamilyName']/input"),30);
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"),30);
        return this;
    }

    public ProfilePageHelper enterFamilyName(String name) {
        WebElement lastNameField = driver
                .findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        enterValueToField(lastNameField,name);
        return this;
    }

    public ProfilePageHelper saveChanges() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"),20);

        driver.findElement(By.id("idbtnsaveprofile")).click();
        waitUntilElementIsClickable(By
                .xpath("//div[@id='idbtneditprofile']"),20);
        return this;
    }

    public String getFamilyName() {
        return driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']/a")).getText();
    }

    public String getConfession() {
        return driver.findElement(By.xpath("//span[@id='fieldobjconfession']")).getText();
    }

    public String getLanguage() {
        return driver.findElement(By.cssSelector("#fieldobjlanguages")).getText();
    }

    public String getFood() {
        return driver.findElement(By.xpath("//*[@id='fieldobjfoodPreferences']")).getText();
    }

    public boolean familyNameIsDisplayed(String name) {
        waitUntilElementIsClickable(By.linkText(name),20);
        return driver.findElement(By.linkText(name)).isDisplayed();
    }
}
