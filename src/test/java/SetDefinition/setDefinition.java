package SetDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import FlightBooking.HomePage;
import Resources.Base;
import cucumber.api.java.en.*;

public class setDefinition extends Base{

	HomePage hp;
	
	@Given("^User is on www\\.spicejet\\.com home page using \"([^\"]*)\" browser$")
	public void user_is_on_www_spicejet_com_home_page_using_browser(String arg1) throws Throwable {
		browserSetup(arg1);
		driver.get("https://book.spicejet.com/search.aspx");
		driver.manage().window().maximize();
		hp = new HomePage(driver);
	}
	@When("^User submit necessary travel information travelOption \"([^\"]*)\" origin \"([^\"]*)\"and destination \"([^\"]*)\"$")
	public void user_submit_necessary_travel_information_travelOption_origin_and_destination(String arg1, String arg2, String arg3) throws Throwable {
		hp.getTravelOptions().findElement(By.xpath("//input[@value='"+arg1+"']")).click();
		hp.getFrom().click();
		hp.getFrom().findElement(By.xpath("//a[@text='"+arg2+"']")).click();
		WebElement element=hp.getTo().findElement(By.xpath("//a[@value='"+arg3+"']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	@When("^User submit departing Date \"([^\"]*)\" Month \"([^\"]*)\" Year \"([^\"]*)\"$")
	public void user_submit_departing_Date_Month_Year(String arg1, String arg2, String arg3) throws Throwable {
		flightDateFinder(arg1, arg2, arg3);
		Thread.sleep(2000);
		hp.getReturningDate().click();
}	
	
@When("^User submit returning Date \"([^\"]*)\" Month \"([^\"]*)\" Year \"([^\"]*)\"$")
public void user_submit_returning_Date_Month_Year(String arg1, String arg2, String arg3) throws Throwable {
	flightDateFinder(arg1, arg2, arg3);
		hp.getNoOfPasangers().click();
	}

@When("^User submit  currency \"([^\"]*)\" dicountPromo \"([^\"]*)\" expectedPass \"([^\"]*)\"$")
public void user_submit_currency_dicountPromo_expectedPass(String arg1, String arg2, String arg3) throws Throwable {
	int pass = Integer.parseInt(arg3);
	Thread.sleep(2000);
	addNoOfPasengers(pass);
	Thread.sleep(2000);	
	Select selectCurrency = new Select(hp.getCurrency());
	selectCurrency.selectByValue(arg1);
	hp.getDiscountCheckBox().findElement(By.xpath("//*[contains(@id,'"+arg2+"')]/preceding-sibling::input")).click();
	hp.getSearchBtn().click();
	}

	@Then("^User will land on a page with available flight and price offers$")
	public void user_will_land_on_a_page_with_available_flight_and_price_offers() throws Throwable {
		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//div[@id='atAGlanceContent']//*[@class='price-summary uppercase price-summary-header']")).getText();
	   String expected = "FARE DETAILS ";
	   Assert.assertEquals(actual, expected);
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
