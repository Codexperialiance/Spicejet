package Resources;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CaptureScreenshot extends Base{
	public static String capture(String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dateStamp = getDateTime();
		String fileName = screenshotName+dateStamp;
		String dest = System.getProperty("user.dir")+"/ScreenShots/"+fileName+".png";
		File destination = new File(dest);
		FileUtils.getFileUtils().copyFile(source, destination);
		return dest;
	}
	
	private  final static String getDateTime() {
	    DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH mm ss Z");
	    df.setTimeZone(TimeZone.getTimeZone("EST"));
	    return df.format(new Date());
	}
}
