package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumOperation1 
{
	public static ChromeDriver driver=null;
	public static void browserLaunch(String key, String value)
	{
		String strkey=key;
		String strvalue=value;
		
		System.setProperty(strkey, strvalue);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void openApplication(String url)
	{
		String URL=url;
		
		driver.get(URL);
	}
	
	public static void clickOnElement(String xpath)
	{
		String XPATAH=xpath;
		
		
		driver.findElementByXPath(XPATAH).click();
	}
	
	public static void mouseOver(String xpath)
	{
		String XPATH=xpath;
		
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement a=driver.findElementByXPath("//*[text()='Login']");
		act.moveToElement(a).build().perform();
	}
	
	public static void sendKey(String key,String value)
	{
		String abckey=key;
		String abcvalue=value;
		
		driver.findElementByXPath(abckey).sendKeys(abcvalue);	
		
	}
	
	public static void Select(String value,int a)
	{
		String selectvalue=value;
		int ab=a; 
		Select State=new Select(driver.findElementByXPath(selectvalue));
		 State.selectByIndex(ab);
	}

	
	public static void main(String[]args) throws Throwable 
	{
		SeleniumOperation1.browserLaunch("webdriver.chrome.driver", "D:\\APPILCATION SUPPORT\\chromedriver.exe");
		
		SeleniumOperation1.openApplication("https://www.flipkart.com/");
		
		SeleniumOperation1.clickOnElement("//*[@class='_2KpZ6l _2doB4z']");
		
		SeleniumOperation1.mouseOver("//*[text()='Login']");
		
		SeleniumOperation1.clickOnElement("//*[text()='My Profile']");
		
		SeleniumOperation1.sendKey("(//*[@type='text'])[2]", "7020712080");
		
		SeleniumOperation1.sendKey("//*[@type='password']", "@Avit1492$");
		
		SeleniumOperation1.clickOnElement("(//*[@type='submit'])[2]");
		
		Thread.sleep(5000);
		
		SeleniumOperation1.clickOnElement("//*[text()='Manage Addresses']");
		SeleniumOperation1.clickOnElement("//*[text()='ADD ADDRESSES']");
		SeleniumOperation1.sendKey("//*[@name='name']", "Avi");
		SeleniumOperation1.sendKey("//*[@name='phone']", "7020712080");
		SeleniumOperation1.sendKey("//*[@name='pincode']", "414303");
		SeleniumOperation1.sendKey("//*[@name='addressLine2']", "Karandi");
		SeleniumOperation1.sendKey("//*[@name='addressLine1']", "Gavthan, Karandi");
		SeleniumOperation1.sendKey("//*[@name='city']", "Ahmednagar");
		SeleniumOperation1.sendKey("//*[@name='landmark']", "Parner");
		SeleniumOperation1.sendKey("//*[@name='alternatePhone']", "9762142701");
		SeleniumOperation1.clickOnElement("//*[text()='Address Type']");
		SeleniumOperation1.clickOnElement("//*[text()='Home']");
		SeleniumOperation1.clickOnElement("//*[text()='Save']");
		
		Thread.sleep(5000);
		SeleniumOperation1.clickOnElement("//*[text()='Confirm']");
		
	}	
}
