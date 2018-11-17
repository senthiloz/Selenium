package prjone.prjone;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.Set;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;



public class TESTFNP {
	
	ExtentReports extent;
	ExtentTest log;
	WebDriver driver;
	

	@BeforeTest
	public void fnpproject()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver.exe");
	}			

	@Test
	public void fnppage() throws InterruptedException, AWTException
	{
		try
		{
			extent=new ExtentReports("D:\\Extent Reports\\FNP Order.html");
			log=extent.startTest("Verify user is able to launch the FNP Application");
				driver=new ChromeDriver();
		driver.get("https://www.fnp.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"fnpsearch\"]")).sendKeys("Premium flowers");
		driver.findElement(By.xpath("//i[@class='material-icons'][contains(text(),'search')]")).click();
		String expectedTitle = "https://www.fnp.com/search?FNP_CURRENT_CATALOG_ID=india&qs=birthday+gifts";
		String actualTitle ="";
		actualTitle=driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle))
		{System.out.println("Test Passed");}
		else {System.out.println("Test Failed");}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Premium Beauty']")).click();
		Thread.sleep(3000);
		String mainWindow=driver.getWindowHandle();
		Set<String> set =driver.getWindowHandles();
		Iterator<String> itr=set.iterator();
		while(itr.hasNext()) {
			String childWindow=itr.next();
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='destlookup']")).sendKeys("620021");
				Thread.sleep(2000);
				Robot rb1=new Robot();
				rb1.keyPress(KeyEvent.VK_DOWN);
				rb1.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"datetimelink\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@title='Next']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"deliverydatepicker\"]/div/table/tbody/tr[2]/td[3]/a")).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("//*[@id=\"shippingmethoddiv\"]/div/ul/li/a/label/span[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"timeslotDiv\"]/div/div/div[3]/ul/li/ul/li/a/label/span[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"buynow\"]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"quantity_1\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"addon\"]/form/div[3]/button/span")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='USERNAME']")).sendKeys("kumar.mba@gmail.com");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"loginbtn\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("senthil01");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@id='loginbtn']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"sendform\"]/section[1]/div[1]/div[1]/div[3]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"sendform\"]/section[1]/div[1]/div[2]/div[4]/ul/li[2]/a/img")).click();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"sendform\"]/section[1]/div[1]/div[1]/div[3]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"sendform\"]/section[1]/div[6]/div[2]/div/ul/li[2]/a")).click();
				Thread.sleep(1000);
				rb1.keyPress(KeyEvent.VK_DOWN);
				rb1.keyPress(KeyEvent.VK_DOWN);
				rb1.keyPress(KeyEvent.VK_ENTER);
				String screenshot_path = Screenshot.createScreenshot(driver);
				String image = log.addScreenCapture(screenshot_path);
				log.log(LogStatus.PASS, "Verify Register Page", image);
				extent.endTest(log);
					}
		}
		}
		
			catch (Exception e)
			{
				log.log(LogStatus.INFO, "URL in Browser Launched Successfully");
				String screenshot_path=Screenshot.createScreenshot(driver);
				String image= log.addScreenCapture(screenshot_path);
				
				String URL=driver.getCurrentUrl();
				log.log(LogStatus.INFO, "Current URL:"+ URL +" ");
				
				log.log(LogStatus.FAIL, "FNP ONLINE PURCHASE", image);
				extent.endTest(log);
	    		e.printStackTrace();
	    		
			}
		}
}
		
		

		
	
	
		
	

	


