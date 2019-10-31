package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FamilyPageHelper extends PageBase{
    public FamilyPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageLoaded(){
        waitUntilTextPresentInElement(By.id("titleprofile"), "My Family:",30);

    }

    public void openFamilyPage(){
        waitUntilElementIsClickable(By.id("family"),20);
        driver.findElement(By.id("family")).click();
        waitUntilPageLoaded();
    }

    public String getTitle() {
        return driver.findElement(By.id("titleprofile")).getText();
    }

    public String getConfession(){
        return driver.findElement(By.xpath("//span[@id='fieldobjconfession']"))
                .getText();
    }

    public String getLanguages(){
        return driver.findElement(By.xpath("//span[@id='fieldobjlanguages']"))
                .getText();
    }

    public String getFood(){
        return driver.findElement(By.cssSelector(".itemprofilefit > #fieldobjfoodPreferences"))
                .getText();
    }
}
