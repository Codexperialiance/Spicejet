package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Resources.Base;

public class BookingTest extends Base{

	public HomePage hp;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {
		
		browserSetup(browser);
		driver.get("https://book.spicejet.com/search.aspx");
		hp = new HomePage(driver);
	}
	
	@Test
	public void roundTripBooking() {
		String origin = "Bengaluru (BLR)";
		String destination = "Mumbai (BOM)";
		String departingDate = "18-02-2019";
		String returningDate = "08-03-2019";
		String travelOption = "RoundTrip";
		String currency = "USD";
		
		hp.getTravelOptions().findElement(By.xpath("//input[@value='"+travelOption+"']")).click();
		hp.getFrom().click();
		hp.getFrom().findElement(By.xpath("//a[@text='"+origin+"']")).click();
		hp.getTo().click();
		hp.getTo().findElement(By.xpath("//a[@text='"+destination+"']")).click();
		hp.getDepartingDate().click();
		hp.getDepartingDate().findElement(By.xpath("//input[@value='"+departingDate+"']")).click();
		hp.getReturningDate().click();
		hp.getReturningDate().findElement(By.xpath("//input[@value='"+returningDate+"']")).click();
		Select select = new Select(hp.getCurrency());
		select.selectByValue(currency);
		hp.getSearchBtn().click();
	}
}
