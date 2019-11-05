package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class WebPageHomeHelper extends PageBase{
    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement loginIcon;

    @FindBy(id = "idtitletypesearchevents")
    WebElement textListEvents;

    @FindBy(name = "selectholidays")
    WebElement filterHoliday;

    @FindBy(xpath = "//div[@id='idbtnclearfilter']")
    WebElement clearButton;

    @FindBy(xpath = "//div[@class = 'itemEventInsert']")
    List<WebElement> eventsList;

    @FindBy(xpath = "//div[@class = 'holidayItemEvents']")
    List<WebElement> holidaysList;


    public WebPageHomeHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsloaded(){
        waitUntilElementIsClickable(loginIcon, 30);
    }

    public Boolean correctPageIsLoaded(){
        return textListEvents.getText().equals("List events")&&loginIcon.isDisplayed();
    }

    public void filterByHolidayShabbat() {
        // ----- to wait that select-element (filter by holiday) and all options are loaded ---
        waitUntilElementIsVisible(filterHoliday, 30);
        waitUntilAllElementsPresent(By.xpath("//select[@name = 'selectholidays']/option"),30);

        // ------ choose filter "shabbat" ------
        Select selector = new Select(filterHoliday);
        selector.selectByValue("Shabbat");

        // ------ wait that filter "shabbat" is chosen -----
        waitUntilElementIsClickable(clearButton, 20);
        waitUntilElementIsPresent(By
                .xpath("//option[@selected][@value = 'Shabbat']"),20);
        // ------ wait that all events by fiter "shabbat" are loaded ----
        waitUntilAllElementsVisible(eventsList,40);
    }

    public boolean eventsListBelongToShabbat() {

        // --- verify that all holidays values are "Shabbat" ----
        int counter = 0;
        for (int i=0; i < holidaysList.size(); i++){
            if (holidaysList.get(i).getText().equals("Shabbat")) counter++;
        }
        return counter == holidaysList.size();

    }
}
