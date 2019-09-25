package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {




    @BeforeMethod
    public void initTests() throws InterruptedException {


        //--- Login to the system ----
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        Thread.sleep(2000);

    }

    @Test
    public void loginScreenVerificationTest(){

        Assert.assertTrue(driver
                .findElement(By.id("clickreg")).getText().contains("registration"),
                "It is not login screen or there is no 'registration' on login screen");
    }

    @Test
    public void loginNegativeTest() throws InterruptedException {

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
        Assert.assertEquals(driver
                .findElement(By.id("idsignin")).getText(),"Login",
                "Name of the login button is not 'Login'");


    }

    @Test
    public void loginExitByCancelTest() throws InterruptedException {
        //--- Close login window ---
        driver.findElement(By.id("closedsignin")).click();
        Thread.sleep(3000);
        // ---- Usr is on the HomePage for the unauthorized user
        Assert.assertEquals(driver
                .findElement(By.id("idsignin")).getText(),"Login",
                "Name of the login button is not 'Login'");


    }
    @Test
    public void loginPositiveTest() throws InterruptedException {
        //----- Find login and password fields and fill them
        WebElement loginField = driver.findElement(By.id("logininput"));
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        loginField.click();
        loginField.sendKeys("marinaA");
        passwordField.click();
        passwordField.sendKeys("marina1!");

        //---- Find sign in button and press on it ----
        driver.findElement(By.id("signinrequest")).click();

        //---- Go to the HomePage Auth -------
        Thread.sleep(7000);
        WebElement profileIcon = driver.findElement(By.id("profile"));

        // ------ Check that we on the HomePage for authorized user---

        Assert.assertTrue(profileIcon.getAttribute("title").contains("marinaA"),"ProfileIcon do not contains login");


    }

}
