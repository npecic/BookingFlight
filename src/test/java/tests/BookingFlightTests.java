package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.BookingHomePage;
import pom_classes.FlightPage;
import selenium_core.DriverManager;

public class BookingFlightTests extends BaseTest{


    DriverManager driverManager;


    @BeforeMethod
    public void setup() {
        baseSetUP("CHROME", "99",5);


    }
    @Test
    public void booking() throws InterruptedException {

    BookingHomePage bookingHomePage = new BookingHomePage(driver);
    FlightPage flightPage = new FlightPage(driver);

    bookingHomePage.toFlights();
//    flightPage.setFromAirport("Belgrade Nikola Tesla Airport");
    flightPage.setToAirport("Dubai International Airport");
    flightPage.dateOfFlight("March","2024","15","June","2024","15");
    flightPage.clickSubmitSearch();
    flightPage.clickCheapest();


    }

    @AfterMethod
    public void tearDown (){
        baseTearDown();

    }
}
