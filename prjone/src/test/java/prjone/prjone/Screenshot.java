package prjone.prjone;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	static String reportLocation = "D:\\Extent Reports\\FNPTEST.html";
	static String imageLocation = "images/";
	public static String createScreenshot(WebDriver driver) {
		 
	    UUID uuid = UUID.randomUUID();
	 
	    // generate screenshot as a file object
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
	        // copy file object to designated location
	        FileUtils.copyFile(scrFile, new File("D:\\Extent Reports\\FNPTEST.html" + imageLocation + uuid + ".png"));
	    } catch (IOException e) {
	        System.out.println("Error while generating screenshot:\n" + e.toString());
	    }
	    //return "http://172.31.25.147:8090/FnPExtentReports/FnP_One_Hour.htmlimages/" + uuid + ".png";
	    
	    return reportLocation + imageLocation + uuid + ".png";
	    
	}
	
	

}
