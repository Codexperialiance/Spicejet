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
		//WebElement year = hp.getDepartingDate().findElement(By.xpath("//*[@id='ui-datepicker-div']//div[@class='ui-datepicker-group ui-datepicker-group-first']//*[@class='ui-datepicker-year']"));
		//WebElement month = hp.getDepartingDate().findElement(By.xpath("//*[@id='ui-datepicker-div']//div[@class='ui-datepicker-group ui-datepicker-group-first']//*[@class='ui-datepicker-month']"));
	    
	   /*
		while(year.getText().contains("2019") && month.getText().contains("February")) {
				hp.getDepartingDatePicker().findElement(By.xpath("//*[@a[title='Next']")).click();
		}
		if(year.getText().contains("2019") && month.getText().contains("February")){	*/
			WebElement element = hp.getDepartingDate().findElement(By.xpath("//table//*[text()='28']"));
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
		//}
		
		Select select = new Select(hp.getCurrency());
		select.selectByValue(currency);
		hp.getSearchBtn().click();
		
	}
}
