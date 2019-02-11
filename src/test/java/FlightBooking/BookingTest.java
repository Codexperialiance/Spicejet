package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
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
	public void roundTripBooking() throws InterruptedException {
		String origin = "Bengaluru (BLR)";
		String destination = "BOM";
		String departingDate = "23";
		String departingMonth = "May";
		String departingYear = "2019";

		String returningDate = "08-03-2019";
		String travelOption = "RoundTrip";
		String currency = "USD";
		driver.manage().window().maximize();
		hp.getTravelOptions().findElement(By.xpath("//input[@value='"+travelOption+"']")).click();
		hp.getFrom().click();
		hp.getFrom().findElement(By.xpath("//a[@text='"+origin+"']")).click();
		WebElement element=hp.getTo().findElement(By.xpath("//a[@value='BOM']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	
		flightDateFinder(departingDate, departingMonth, departingYear);
		Thread.sleep(3000);
		hp.getReturningDate().click();
		flightDateFinder(departingDate, departingMonth, departingYear);
	}

	public void flightDateFinder(String departingDate, String departingMonth, String departingYear) {
		int flag = 0;
		while(flag==0) {
			WebElement yy;
			yy = hp.getYearPicker();
			if(yy.getText().equalsIgnoreCase(departingYear)) {
				flag=1;
				break;
			}
			hp.getNext().click();
		}
		while(flag==1) {
			WebElement mm;
			mm = hp.getMonthPicker();
			if(mm.getText().equalsIgnoreCase(departingMonth)) {
				flag=0;
				break;
			}
			hp.getNext().click();		
			}
		
		hp.getDatePicker().findElement(By.xpath("//*//a[text()='"+departingDate+"']")).click();
	}
}
