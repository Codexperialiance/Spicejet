package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	By travelOptions = By.id("travelOptions");
	By from = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT");
	By to = By.xpath("//div[@id='ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR']");
	By returningDate = By.xpath("//input[@id='custom_date_picker_id_2']");
	By noOfPassengers = By.id("divpaxinfo");
	By noOfAdults = By.xpath("//div[@class='ad-row-right']//span[@id='spanAudlt']");
	By currency = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency");
	By search = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit");
	By discount = By.id("divdiscountcheckbox");
	By yearPicker = By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//*[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']");
	By monthPicker = By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//*[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']");
	By datePicker = By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']");
	By next = By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//a[@title='Next']");
	By addNoOfAdults = By.id("hrefIncAdt");
	By passengersBtn = By.id("btnclosepaxoption");
	
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
	
	public WebElement getYearPicker() {
		return driver.findElement(yearPicker);
	}
	
	public WebElement getMonthPicker() {
		return driver.findElement(monthPicker);
	}
	
	public WebElement getNext() {
		return driver.findElement(next);
	}
	
	public WebElement getDatePicker() {
		return driver.findElement(datePicker);
	}
	
	public WebElement getNoOfAdults() {
		return driver.findElement(noOfAdults);
	}
	
	public WebElement getAddNoOfAdults() {
		return driver.findElement(addNoOfAdults);
	}
	
	public WebElement getPassengersBtn() {
		return driver.findElement(passengersBtn);
	}
}
