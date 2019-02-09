package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AvailableFlights {

	WebDriver driver;
	By availablityTable = By.id("availabilityTable1");
	
	public AvailableFlights(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAvailablityTable() {
		return driver.findElement(availablityTable);
	}
}
