package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePageHelper extends PageBase {
    public ProfilePageHelper(WebDriver driver) {
        super(driver);
    }

    public void openProfilePage() {
        driver.findElement(By.id("profile")).click();
        waitUntilPageLoaded();
    }

    public void waitUntilPageLoaded(){
        waitUntilElementIsClickable(By.id("idbtneditprofile"),20);
        waitUntilTextPresentInElement(By.id("titleprofile"), "My Profile:",20);
        waitUntilElementIsVisible(By.id("imgavatarinprofilefamily"), 20);
    }

    public void openEditMode() {
        driver.findElement(By.id("idbtneditprofile")).click();
        waitUntilElementIsClickable(By.xpath("//span[@id='fieldobjfamilyName']/input"),30);
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"),30);
    }

    public void enterFamilyName(String name) {
        WebElement lastNameField = driver
                .findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(name);
    }

    public void saveChanges() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"),20);

        driver.findElement(By.id("idbtnsaveprofile")).click();
        waitUntilElementIsClickable(By
                .xpath("//div[@id='idbtneditprofile']"),20);
        //waitUntilTextPresentInElement(By
           //     .xpath("//span[@id='fieldobjfamilyName']/a"),"Petrov", 20);
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
