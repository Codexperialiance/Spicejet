package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	By travelOptions = By.id("travelOptions");
	By from = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT");
	By to = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT");
	By departingDate = By.id("custom_date_picker_id_1");
	By returningDate = By.id("custom_date_picker_id_2");
	By noOfPassengers = By.id("divpaxinfo");
	By currency = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency");
	By search = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit");
	By discount = By.id("divdiscountcheckbox");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getTravelOptions() {
		return driver.findElement(travelOptions);
	}
	
	public WebElement getFrom() {
		return driver.findElement(from);
	}
	
	public WebElement getTo() {
		return driver.findElement(to);
	}
	
	public WebElement getDepartingDate() {
		return driver.findElement(departingDate);
	}
	
	public WebElement getReturningDate() {
		return driver.findElement(returningDate);
	}
	
	public WebElement getNoOfPasangers() {
		return driver.findElement(noOfPassengers);
	}
	
	public WebElement getCurrency() {
		return driver.findElement(currency);
	}
	
	public WebElement getSearchBtn() {
		return driver.findElement(search);
	}
	
	public WebElement getDiscountCheckBox() {
		return driver.findElement(discount);
	}
}