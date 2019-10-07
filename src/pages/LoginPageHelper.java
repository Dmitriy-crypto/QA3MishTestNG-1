package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends PageBase {
    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }
 public void waitUntilPageIsLoaded(){
     waitUntilElementIsClickable(By.id("signinrequest"),20);
 }

 public void loginPageOpen(){
     WebElement loginIcon  = driver.findElement(By.id("idsignin"));
     loginIcon.click();
 }
}
