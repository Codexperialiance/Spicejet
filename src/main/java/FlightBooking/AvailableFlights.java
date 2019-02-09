package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AvailableFlights {

	WebDriver driver;
	By returningFlightTable = By.id("availabilityTable1");
	By departingFlifhtTable = By.id("availabilityTable0");
	By fareTotal = By.xpath("//span[@class='total-price margin-left-30']");
	
	public AvailableFlights(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getReturningFlightTable() {
		return driver.findElement(returningFlightTable);
	}
	
	public WebElement getDepartingFlifhtTable() {
		return driver.findElement(departingFlifhtTable);
	}
	
	public WebElement getFareTotal() {
		return driver.findElement(fareTotal);
	}
}
