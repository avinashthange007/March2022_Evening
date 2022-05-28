package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Temt 
{	
	public static void main(String[]args) throws Throwable
	{
		//Launch Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Automation support\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Open application
		driver.get("https://www.flipkart.com/");
		//cancel login page																				//click 3 times
		driver.findElementByXPath("//*[@class='_2KpZ6l _2doB4z']").click();
		//move to element
		Actions act=new Actions(driver);
		WebElement a=driver.findElementByXPath("//*[text()='Login']");
		act.moveToElement(a).build().perform();
		
		//Click on my profile
		driver.findElementByXPath("//*[text()='My Profile']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Enter Username																		//sendkeys 2 times
		driver.findElementByXPath("(//*[@type='text'])[2]").sendKeys("7020712080");
		//Enter Password
		driver.findElementByXPath("//*[@type='password']").sendKeys("@Avit1492$");
		//Click on Login Button																		
		driver.findElementByXPath("(//*[@type='submit'])[2]").click();
		
		Thread.sleep(5000);
		driver.findElementByXPath("//*[text()='Manage Addresses']").click();
		driver.findElementByXPath("//*[text()='ADD ADDRESSES']").click();
		driver.findElementByXPath("//*[@name='name']").sendKeys("Avi");
		driver.findElementByXPath("//*[@name='phone']").sendKeys("7020712080");
		driver.findElementByXPath("//*[@name='pincode']").sendKeys("414303");
		driver.findElementByXPath("//*[@name='addressLine2']").sendKeys("Karandi");
		driver.findElementByXPath("//*[@name='addressLine1']").sendKeys("Gavthan, Karandi");
		driver.findElementByXPath("//*[@name='city']").sendKeys("Parner");
		driver.findElementByXPath("//*[@name='landmark']").sendKeys("Parner");
		driver.findElementByXPath("//*[@name='alternatePhone']").sendKeys("9762142701");
		driver.findElementByXPath("//*[text()='Address Type']").click();
		driver.findElementByXPath("//*[text()='Home']").click();
		driver.findElementByXPath("//*[text()='Save']").click();
		
		Thread.sleep(5000);
		driver.findElementByXPath("//*[text()='Confirm']").click();
	}

}
