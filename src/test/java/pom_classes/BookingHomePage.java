package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingHomePage extends BasePage {
    WebDriver driver;


    public BookingHomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@aria-label='Dismiss sign-in info.']")
    WebElement clickClose;
    @FindBy(css = "[id='flights']")
    WebElement clickFlights;

    public void toFlights(){
        clickElement(clickClose,"closed ad");
        clickElement(clickFlights,"to flights");
    }




}
