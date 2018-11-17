package prjone.prjone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class FNPTEST {
	WebDriver driver;
	Properties prop = new Properties();
	ExtentReports extent;
	ExtentTest log;
	
	
	@BeforeTest
	public void FNPLAUNCH()
	{
		File file = new File("C:\\Users\\celkumar\\eclipse-workspace\\prjone\\data.properties");
		FileInputStream fileInput = null;
		try {	
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.fnp.com/");
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void test1()
	{
	
		extent.flush();
	}
	
		
	@DataProvider(name="menu")
	public Object[][] FNPdata()
	{
		Object[][] arrayObject=ExcelDataConfig.getExcelData(prop.getProperty("Excel"), "Sheet1");
		return arrayObject;
	}

	@Test(dataProvider = "menu")
	public void FNPPAGE(String L1, String L2, String L3, String L4, String L5, String L6, String L7, String L8,
			String L9) throws InterruptedException
	{
	try
	{
		
		extent=new ExtentReports("D:\\Extent Reports\\FNPTEST.html");
		log=extent.startTest("Verify FNP Menu");		
		String fnp1 = driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[1]/a")).getText();
		Thread.sleep(2000);
		System.out.println(fnp1);
		Assert.assertEquals(fnp1, L1);		
		String fnp2=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[2]/a")).getText();
		Thread.sleep(2000);
		System.out.println(fnp2);
		Assert.assertEquals(fnp2, L2);		
		String fnp3=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[3]/a")).getText();
		Thread.sleep(2000);
		System.out.println(fnp3);
		Assert.assertEquals(fnp3, L3);
		String fnp4=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[4]/a")).getText();
		Thread.sleep(2000);
		System.out.println(fnp4);
		Assert.assertEquals(fnp4, L4);		
		String fnp5=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[5]/a")).getText();
		Thread.sleep(2000);
		System.out.println(fnp5);
		Assert.assertEquals(fnp5, L5);		
		String fnp6=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[6]/a")).getText();
		Thread.sleep(2000);
		System.out.println(fnp6);
		Assert.assertEquals(fnp6, L6);		
		String fnp7=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[7]/a")).getText();
		Thread.sleep(2000);
		System.out.println(fnp7);
		Assert.assertEquals(fnp7, L7);			
		String fnp8=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[8]/a")).getText();
		Thread.sleep(2000);
		System.out.println(fnp8);
		Assert.assertEquals(fnp8, L8);		
		String fnp9=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[9]/a")).getText();
		Thread.sleep(2000);
		System.out.println(fnp9);
		Assert.assertEquals(fnp9, L9);			
		//String fnp10=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[11]/a")).getText();
		//Thread.sleep(2000);
		//System.out.println(fnp10);
		//Assert.assertEquals(fnp10, L11);	
		
		log.log(LogStatus.INFO, "URL in Browser Launched Successfully");
		log.log(LogStatus.INFO, "ALL UI headers are verified");
		String screenshot_path = Screenshot.createScreenshot(driver);
		String image = log.addScreenCapture(screenshot_path);
		log.log(LogStatus.PASS, "Verify UI of the FNP application", image);
		
		String URL = driver.getCurrentUrl();
		log.log(LogStatus.INFO, "Current URL:" + URL + " ");
		extent.endTest(log);
		
				
	}
	
	catch (Exception e)
	{
		log.log(LogStatus.INFO, "Failed");
		String screenshot_path = Screenshot.createScreenshot(driver);
		String image = log.addScreenCapture(screenshot_path);
		log.log(LogStatus.FAIL, "Failed", image);
		String URL = driver.getCurrentUrl();
		log.log(LogStatus.INFO, "Current URL:" + URL + " ");

		extent.endTest(log);
		e.printStackTrace();
				throw e;
		
		
	}
	
	}
	
	@DataProvider(name="Cakename")
	public Object[][] FNPcake()
	{
		Object[][] arrayObject=ExcelDataConfig.getExcelData(prop.getProperty("Excel"), "Sheet2");
		return arrayObject;
	}



	@Test(dataProvider = "Cakename")
	public void FNPcake(String L1, String L2, String L3, String L4, String L5) throws InterruptedException
	{
			log=extent.startTest("Verify cake link product functionality in the header menu ");
			//driver.get("https://www.fnp.com/");
			//Thread.sleep(2000);
			//driver.navigate().refresh();
			Thread.sleep(3000);	
			//driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[2]/a")).click();
			String cke = driver.findElement(By.xpath("//*[@id=\"cakesmenu\"]/div/section[2]/ul/li[1]/a")).getText();
			Thread.sleep(2000);
			System.out.println(cke);
			Assert.assertEquals(cke, L1);
			String cke1 = driver.findElement(By.xpath("//*[@id=\"cakesmenu\"]/div/section[2]/ul/li[2]/a")).getText();
			Thread.sleep(2000);
			System.out.println(cke1);
			Assert.assertEquals(cke1, L2);
			String cke2 = driver.findElement(By.xpath("//*[@id=\"cakesmenu\"]/div/section[2]/ul/li[3]/a")).getText();
			Thread.sleep(2000);
			System.out.println(cke2);
			Assert.assertEquals(cke2, L3);
			String cke3 = driver.findElement(By.xpath("//*[@id=\"cakesmenu\"]/div/section[2]/ul/li[4]/a")).getText();
			Thread.sleep(2000);
			System.out.println(cke3);
			Assert.assertEquals(cke3, L4);
			String cke4 = driver.findElement(By.xpath("//*[@id=\"cakesmenu\"]/div/section[2]/ul/li[5]/a")).getText();
			Thread.sleep(2000);
			System.out.println(cke4);
			Assert.assertEquals(cke4, L5);
			log.log(LogStatus.INFO, "URL in Browser Launched Successfully");
			log.log(LogStatus.INFO, "ALL Cake link header menus are verified");
			String screenshot_path = Screenshot.createScreenshot(driver);
			String image = log.addScreenCapture(screenshot_path);
			log.log(LogStatus.PASS, "Verify cake link product functionality in the header menu", image);
			
			extent.endTest(log);
		
			
						
				
		}
			
}



	



	

				
		
		
		



		
		
		
		
	
	
	




