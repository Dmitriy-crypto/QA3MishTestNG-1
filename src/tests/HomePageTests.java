package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTests extends TestBase {

    @Test
    public void homePageVerificationTest() throws InterruptedException {

        // ------ Find list events element ----
        WebElement listEvent
                = driver.findElement(By.id("idtitletypesearchevents"));
        //--Verify that listEvent elements contains 'list events' text


        Assert.assertEquals(listEvent.getText(),"List evvents",
                "Name of the listEventt element is not 'List evvents'");

    }

}
