package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	By travelOptions = By.id("travelOptions");
	By from = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT");
	By toTextbox = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT");
	By to = By.xpath("//div[@id='ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR']");
	By departingTextbox = By.id("custom_date_picker_id_1");
	By departingDate = By.xpath("//*[@id='ui-datepicker-div']//div[@class='ui-datepicker-group ui-datepicker-group-first']");
	By datefinder = By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']");
	By returningDate = By.xpath("//input[@id='custom_date_picker_id_2']");
	By noOfPassengers = By.id("divpaxinfo");
	By currency = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency");
	By search = By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit");
	By discount = By.id("divdiscountcheckbox");
	By departingDatePicker = By.id("ui-datepicker-div");
	By yearPicker = By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//*[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']");
	By monthPicker = By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//*[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']");
	By datePicker = By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']");
	By next = By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//a[@title='Next']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getTravelOptions() {
		return driver.findElement(travelOptions);
	}
	
	public WebElement getToTextBox() {
		return driver.findElement(toTextbox);
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
	
	public WebElement getDepartingTextbox() {
		return driver.findElement(departingTextbox);
	}
	
	public WebElement getDepartingDatePicker() {
		return driver.findElement(departingDatePicker);
	}
	
	public WebElement getDatefinder() {
		return driver.findElement(datefinder);
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
}
