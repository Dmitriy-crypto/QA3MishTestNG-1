package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebHomePageTests extends TestBase{

    @Test
    public void webHomePageTest()  {

        WebElement eventList = driver.findElement(By.id("idtitletypesearchevents"));
        System.out.println("List events element exists: " + eventList.getText().equals("List events"));
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        System.out.println("Login Icon exists: " + loginIcon.getText().equals("Login"));

    }
}
