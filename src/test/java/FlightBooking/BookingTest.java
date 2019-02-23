package FlightBooking;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Resources.Base;

public class BookingTest extends Base{

	public HomePage hp;
	private static Logger  log = LogManager.getLogger(BookingTest.class.getName());
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {
		
		browserSetup(browser);
		driver.get("https://book.spicejet.com/search.aspx");
		hp = new HomePage(driver);
	}
	
	@Test
	@Parameters({"travelOption", "origin", "destination", "departingDate", "departingMonth", "departingYear", "returningDate", "returningMonth", "returningYear", "expectedPass", "currency", "dicountPromo"})
	public void roundTripBooking(String travelOption, String origin, String destination, String departingDate, String departingMonth, String departingYear, String returningDate, String returningMonth, String returningYear, int expectedPass, String currency, String dicountPromo) throws InterruptedException, IOException {
		BasicConfigurator.configure();
		driver.manage().window().maximize();
		
		hp.getTravelOptions().findElement(By.xpath("//input[@value='"+travelOption+"']")).click();
		hp.getFrom().click();
		hp.getFrom().findElement(By.xpath("//a[@text='"+origin+"']")).click();
		WebElement element=hp.getTo().findElement(By.xpath("//a[@value='"+destination+"']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	
		flightDateFinder(departingDate, departingMonth, departingYear);
		Thread.sleep(2000);
		hp.getReturningDate().click();
		Thread.sleep(2000);
		flightDateFinder(returningDate, returningMonth, returningYear);
		hp.getNoOfPasangers().click();
			
		Thread.sleep(2000);
		addNoOfPasengers(expectedPass);
		
		Select selectCurrency = new Select(hp.getCurrency());
		selectCurrency.selectByValue(currency);
				
		hp.getDiscountCheckBox().findElement(By.xpath("//*[contains(@id,'"+dicountPromo+"')]/preceding-sibling::input")).click();
		hp.getSearchBtn().click();
		log.info("Flight Booking Test Completed Successfully!");
	}

	
	public void addNoOfPasengers(int expectedPass) {
		int pass = 1;
		while(pass==1) { 
			int actualPass=Integer.parseInt(hp.getNoOfAdults().getText());
			if(expectedPass==actualPass) {
				pass=0;
				break;
			}
			hp.getAddNoOfAdults().click();
		}
		hp.getPassengersBtn().click();
	}

	public void flightDateFinder(String Date, String Month, String Year) {
		int flag = 0;
		while(flag==0) {
			WebElement yy;
			yy = hp.getYearPicker();
			if(yy.getText().equalsIgnoreCase(Year)) {
				flag=1;
				break;
			}
			hp.getNext().click();
		}
		while(flag==1) {
			WebElement mm;
			mm = hp.getMonthPicker();
			if(mm.getText().equalsIgnoreCase(Month)) {
				flag=0;
				break;
			}
			hp.getNext().click();		
			}
		
		WebElement element = hp.getDatePicker().findElement(By.xpath("//*//a[text()='"+Date+"']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
}
