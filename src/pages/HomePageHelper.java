package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePageHelper extends PageBase {
    @FindBy(id = "idsignin")
    WebElement loginIcon;

    @FindBy(xpath = "//div[@class = 'itemEventInsert']")
    List<WebElement> eventsList;

    @FindBy(id = "idtitletypesearchevents")
    WebElement listEvent;

    @FindBy(name = "selectholidays")
    WebElement filterHolidays;

    @FindBy (xpath = "//div[@id='idbtnclearfilter']")
    WebElement clearFilterButton;

    @FindBy (xpath = "//div[@class = 'holidayItemEvents']")
    List<WebElement> listHolidays;



    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public HomePageHelper waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(loginIcon, 20);
        waitUntilAllElementsVisible(eventsList,20);
        return this;
    }

    public Boolean correctPageIsLoaded(){

        return listEvent.getText().equals("List events");
    }


    public HomePageHelper filterEventsByHolidayShabbat() {
        // ----- to wait that select-element (filter by holiday) and all options are loaded ---
        waitUntilElementIsVisible(filterHolidays,30);
        waitUntilAllElementsPresent(By.xpath("//select[@name = 'selectholidays']/option"),30);
        // ------ choose filter "shabbat" ------
        Select selector;
        try{
            selector = new Select(filterHolidays);
            selector.selectByValue("Shabbat");
        }catch(Exception e){
            try {
                Thread.sleep(20000);
                System.out.println("Exception: " + e);
                /*selector = new Select(driver
                        .findElement(By.name("selectholidays")));*/
                selector = new Select(filterHolidays);
                selector.selectByValue("Shabbat");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        // ------ wait that filter "shabbat" is chosen -----
        waitUntilElementIsClickable(clearFilterButton,20);
        waitUntilElementIsPresent(By
                .xpath("//option[@selected][@value = 'Shabbat']"),20);
        waitUntilAllElementsVisible(eventsList,40);

        return this;
    }

    public Boolean allEventsBelongToHolidayShabbat() {

        // --- verify that all holidays values are "Shabbat" ----
        int counter = 0;
        for (int i=0; i < listHolidays.size(); i++){
            if (listHolidays.get(i).getText().equals("Shabbat")) counter++;
        }
        return counter == listHolidays.size();
    }
}
