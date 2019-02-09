package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
		String destination = "Mumbai (BOM)";
		String departingDate = "18-02-2019";
		String returningDate = "08-03-2019";
		String travelOption = "RoundTrip";
		String currency = "USD";
		driver.manage().window().maximize();
		hp.getTravelOptions().findElement(By.xpath("//input[@value='"+travelOption+"']")).click();
		hp.getFrom().click();
		hp.getFrom().findElement(By.xpath("//a[@text='"+origin+"']")).click();
		
		hp.getToTextBox().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR']//*[text()=' Mumbai (BOM)']")).click();
		hp.getTo().findElement(By.xpath("//*[text()=' "+destination+"']")).click();
		hp.getDepartingTextbox().click();
		Thread.sleep(3000);
		WebElement year = hp.getDepartingDate().findElement(By.xpath("//*[text()='2019']"));
		int y = hp.getDepartingDate().findElements(By.xpath("//*[text()='2019']")).size();
		WebElement month = hp.getDepartingDate().findElement(By.xpath("//*[text()='February']"));
		int m = hp.getDepartingDate().findElements(By.xpath("//*[text()='February']")).size();
		>//driver.findElement(By.xpath("*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[2]/a")).click();
		
		while(hp.getDepartingDate().findElements(By.xpath("//*[text()='2019']")).size()==0 || 
				hp.getDepartingDate().findElements(By.xpath("//*[text()='February']")).size()==0) {
				hp.getDepartingDatePicker().findElement(By.xpath("//*[@a[title='Next']")).click();
		}
		if(hp.getDepartingDate().findElements(By.xpath("//*[text()='2019']")).size()>0 || 
				hp.getDepartingDate().findElements(By.xpath("//*[text()='February']")).size()>0){
					hp.getDatefinder().findElement(By.xpath("//*[text()='18']")).click();
		}
		
		Select select = new Select(hp.getCurrency());
		select.selectByValue(currency);
		hp.getSearchBtn().click();
		
	}
}
