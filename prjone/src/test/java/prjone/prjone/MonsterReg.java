package prjone.prjone;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 

public class MonsterReg {
	WebDriver dr2;
	ExtentReports extent;
	ExtentTest log;
	Properties prop=new Properties();
	
			@BeforeTest
		public void practice2()
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
				dr2=new ChromeDriver();
				dr2.get("https://www.monster.com.my/");
				dr2.manage().window().maximize();
	}
					@DataProvider(name = "Monster")
			public Object[][] Salutation() {
				Object[][] arrayObject = ExcelDataConfig.getExcelData(prop.getProperty("Excel"), "Sheet1");
				return arrayObject;
			}
		@AfterTest
		public void test99()
		{
			extent.flush();
		}
					
	
		@Test(dataProvider="Monster")
		public  void registration(String name,String last,String gmail) throws InterruptedException, AWTException

		
		{
				
			extent=new ExtentReports("D:\\Extent Reports\\MonsterReg.html");
			log=extent.startTest("Verify user registeration in monster");
				dr2.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
				String expectedTitle="Create Your Profile Now - Submit Resume on Monster Malaysia";
				String actualTitle="";
				actualTitle=dr2.getTitle();
						if(actualTitle.contentEquals(expectedTitle))
						{System.out.println("Test Passed");}
						else {System.out.println("Test Failed");}
						dr2.findElement(By.id("firstName_id")).sendKeys(name);
						dr2.findElement(By.id("lastName_id")).sendKeys(last);
						dr2.findElement(By.id("email")).sendKeys(gmail);
						dr2.findElement(By.id("passwd_id")).sendKeys("Aryan2014");
						//Thread.sleep(3000);
						dr2.findElement(By.xpath("//span[text()='Current location']")).click();
						Thread.sleep(3000);
						dr2.findElement(By.id("s2id_autogen2_search")).sendKeys("Mal");
						Robot rb1=new Robot();
						rb1.keyPress(KeyEvent.VK_DOWN);
						rb1.keyPress(KeyEvent.VK_UP);
						rb1.keyPress(KeyEvent.VK_ENTER);
						//dr2.findElement(By.xpath("//span[@class='select2-hidden-accessible']")).click();
						//Select country = new Select(dr2.findElement(By.xpath("//span[text()='Current location']")));
						Thread.sleep(3000);
						//country.selectByVisibleText("Kuala Lumpur");
						Thread.sleep(3000);
						dr2.findElement(By.xpath("//*[@id=\"select2-chosen-1\"]")).click();
						Thread.sleep(2000);
						dr2.findElement(By.id("s2id_autogen1_search")).sendKeys("Ind");
						rb1.keyPress(KeyEvent.VK_DOWN);
						//rb1.keyPress(KeyEvent.VK_UP);
						rb1.keyPress(KeyEvent.VK_ENTER);
						//Select nation = new Select(dr2.findElement(By.name("Nationality")));
						//nation.selectByVisibleText("Indian");
						dr2.findElement(By.id("mobile2")).sendKeys("01121270692");
						Thread.sleep(3000);
						dr2.findElement(By.xpath("//*[@id=\"expYrMonth_value\"]")).click();
						dr2.findElement((By.xpath("//*[@id=\"expYrMonth_popup\"]/div/div[4]/label[13]/div/div[1]"))).click();
						dr2.findElement(By.id("exp_month0")).click();
						dr2.findElement(By.xpath("//*[@id=\"expYrMonth\"]/div[2]")).click();
						//WebElement radio13=dr2.findElement(By.id("exp_year12"));
						//radio13.click();
						//WebElement radio14=dr2.findElement(By.id("exp_month0"));
						//radio14.click();
						dr2.findElement(By.id("skills")).sendKeys("Testing");
						Thread.sleep(3000);
						//rb1.keyPress(KeyEvent.VK_DOWN);
						//Thread.sleep(3000);
						//rb1.keyPress(KeyEvent.VK_ENTER);
						//Thread.sleep(3000);
						dr2.findElement(By.xpath("//input[@id='mobile2']")).click();
						Thread.sleep(2000);
						dr2.findElement(By.xpath("//div[@id='ind_value']")).click();
						Thread.sleep(2000);
						dr2.findElement(By.xpath("//div[@id='other_ind_8_val']")).click();
						Thread.sleep(2000);
						dr2.findElement(By.xpath("//div[@class='right clip_image closedropdown']")).click();
						Thread.sleep(2000);
						dr2.findElement(By.xpath("//div[@id='cat_value']")).click();
						Thread.sleep(2000);
						dr2.findElement(By.xpath("//div[@id='other_cat_22_check']")).click();
						Thread.sleep(2000);
						dr2.findElement(By.xpath("//div[@class='right clip_image closedropdown']")).click();
						Thread.sleep(2000);
						dr2.findElement(By.xpath("//*[@id=\"wordresume\"]")).click();
						Thread.sleep(2000);
						StringSelection stringselect=new StringSelection("C:\\Users\\celkumar\\Desktop\\Resume malaysia\\Resume_Celiaselvakumari_Mainframe_developer");
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(stringselect, null);
						Robot rb3=null;
						try {
							rb3=new Robot();
						} catch (AWTException e) {
							e.printStackTrace();
						}
						rb3.delay(250);
						rb3.keyPress(KeyEvent.VK_ENTER);
				        rb3.keyRelease(KeyEvent.VK_ENTER);
				        rb3.keyPress(KeyEvent.VK_CONTROL);
				        rb3.keyPress(KeyEvent.VK_V);
				        rb3.keyRelease(KeyEvent.VK_V);
				        rb3.keyRelease(KeyEvent.VK_CONTROL);
				        rb3.keyPress(KeyEvent.VK_ENTER);
				        rb3.delay(150);
				        rb3.keyRelease(KeyEvent.VK_ENTER);
				        				
				        
						extent.endTest(log);
									
		
	
}
}
	

