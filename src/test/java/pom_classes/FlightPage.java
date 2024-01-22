package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage extends BasePage{


    public FlightPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//button[@data-ui-name='input_location_from_segment_0']")
    WebElement airportFrom;
    @FindBy(xpath = "//button[@data-ui-name='input_location_to_segment_0']")
    WebElement airportTo;
    @FindBy(xpath = "//input[@placeholder=\"Airport or city\"]")
    WebElement inputTo;
    @FindBy(css = "[placeholder='Depart – Return']")
    WebElement departReturnDate;
    @FindBy(xpath = "//button[contains(@class, 'Calendar-module__control--next___C2mkG')]")
    WebElement nextArrow;
    @FindBy(xpath = "//*[text()='Search']/..")
    WebElement submitSearch;
    @FindBy(css = "[data-testid='search_tabs_CHEAPEST']")
    WebElement cheapestTicket;


    public void setFromAirport(String location){
    //    sendKeys(airportFrom,location,"into search field");
        clickElement(driver.findElement(By.xpath("//ul[@id='flights-searchbox_suggestions']/li/span[2]/span[(text()='"+location+"')]/../..")),location);
    }
    public void setToAirport(String location) throws InterruptedException {
        clickElement(airportTo);
        Thread.sleep(2000);
        clickElement(inputTo);
        Thread.sleep(3000);
        sendKeys(inputTo,location,"into search field");
        clickElement(driver.findElement(By.xpath("//ul[@id='flights-searchbox_suggestions']/li/span[3]/span[(text()='"+location+"')]/../..")),location);
    }

    public void clickDate(String month,String year, String day){
        while(true) {
            if (driver.findElements(By.xpath("//h3[(text() = '"+month+"') and text()='"+year+"']")).size() == 0) {
                clickElement( nextArrow, "Next month");
            }else {
                clickElement(driver.findElement(By.xpath("//h3[(text() = '"+month+"') and text()='"+year+"']/..//span[text() ='"+day+"']")), "Clicked "+month +" "+year+" "+day);
                break;
            }
        }
    }


    public void dateOfFlight (String departMonth, String departYear,String departDay, String returnMonth, String returnYear, String returnDay){
        clickElement(departReturnDate);
        clickDate(departMonth, departYear,departDay);
        clickDate(returnMonth, returnYear, returnDay);

    }

    public void clickSubmitSearch(){
        clickElement(submitSearch);
    }
    public void clickCheapest() throws InterruptedException {
        Thread.sleep(7000);
        clickElement(cheapestTicket);
    }

    public String getDepartTime() {
        return driver.findElement(By.xpath("//input[@id='group_adults']")).getAttribute("value");
    }



}
