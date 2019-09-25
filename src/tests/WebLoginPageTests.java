package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static tests.TestBase.LOGIN;

public class WebLoginPageTests extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {
        Thread.sleep(6000);
        WebElement loginIcon  = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        Thread.sleep(3000);
    }

    @Test
    public void webLoginPositive() throws InterruptedException {

     WebElement loginInput = driver.findElement(By.id("logininput"));
     WebElement passwordInput = driver.findElement(By.id("passwordinput"));
     loginInput.click();
     loginInput.sendKeys("marinaA");
     passwordInput.click();
     passwordInput.sendKeys("marina1!");
     driver.findElement(By.id("signinrequest")).click();
     Thread.sleep(10000);
     WebElement profileIcon = driver.findElement(By.id("profile"));
     System.out.println("We are on the Home Page (Auth) screen: " + profileIcon.getAttribute("title").contains("marinaA"));

 }

 @Test
 public void webNegativeLogin() throws InterruptedException {

     System.out.println("We are on the Login window: " + driver
             .findElement(By.id("clickreg")).getText().contains("registration"));

     //---- Enter incorrect login/psw ---
     driver.findElement(By.id("logininput")).sendKeys(LOGIN);
     driver.findElement(By.id("passwordinput")).sendKeys("123");
     WebElement signInButton = driver.findElement(By.id("signinrequest"));
     signInButton.click();
     Thread.sleep(3000);

     //--- Error message 'wrong authorization is displayed' ----
     System.out.println("The system displays an error message: " + driver
             .findElement(By.id("wrongloginorpassword")).getText().contains("Wrong Authorization"));

     //--- Close login window ---
     driver.findElement(By.id("closedsignin")).click();
     Thread.sleep(3000);
     // ---- Usr is on the HomePage for the unauthorized user
     System.out.println("User is on the HomePage unauthorized: " + driver
             .findElement(By.id("idsignin")).getText().equals("Login"));

 }
}
