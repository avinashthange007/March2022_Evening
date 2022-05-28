package utility;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import cucumbermap.ConfigReader;

public class SeleniumOperation 
{
	public static ConfigReader config;
	
	public static WebDriver driver=null;
	
	public static Hashtable<String,Object> outputParameters=new Hashtable <String,Object>();
	
	public static Hashtable<String,Object> browserLaunch(Object[]inputParameters)					//Launch Browser and Maximize it
	{
		try
		{
			String bname=(String) inputParameters[0];
		
			if(bname.equalsIgnoreCase("chrome"))
			{
				
				config=new ConfigReader();
				System.setProperty("webdriver.chrome.driver", config.getDriverPathChrome());
				
					driver=new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
			}			
			else if(bname.equalsIgnoreCase("FF"))
			{
				System.setProperty("webdriver.geckodriver.driver", config.getDriverPathFF());
			
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
			}
			
			outputParameters.put("STATUS", "PASS");
			outputParameters.put("MESSAGE", "methodUsed: browserLaunch, Input Given: "+ inputParameters[0].toString());
						
			}
		catch(Exception e)
			{
			
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE", "methodUsed: browserLaunch, Input Given: "+ inputParameters[0].toString());
			
			}
		return outputParameters;
	 }
	
	public static Hashtable<String,Object> openApplication()
	{
		try
		{
		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.get(config.getApplicationUrl());
		
		outputParameters.put("STATUS", "PASS");
	    outputParameters.put("MESSAGE", "methodUsed: OpenApplication,Input Given"+config.getApplicationUrl().toString());
	}
	catch(Exception e)
	{
		outputParameters.put("STATUS", "FAIL");
	    outputParameters.put("MESSAGE", "methodUsed: OpenApplication,Input Given"+config.getApplicationUrl().toString());
	}
		return outputParameters;
		
	}
	
	
	public static Hashtable<String,Object> clickOnElement(Object[]inputParameters)     				//click on 1)Cancel Login, 2)My Profile, 3)Login Button
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
			String XPATH= (String) inputParameters[0];
			driver.findElement(By.xpath(XPATH)).click();
			
			outputParameters.put("STATUS", "PASS");
			outputParameters.put("MESSAGE", "methodUsed: clickOnElement, Input Given: "+ inputParameters[0].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE", "methodUsed: clickOnElement, Input Given: "+ inputParameters[0].toString());
		}
		
		return outputParameters;
		
	}
	
	public static Hashtable<String,Object> mouseOver(Object[]inputParameters)							//Mouse actions>> will automate element based on mouse interaction
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
			String XPATH=(String) inputParameters[0];
			Actions act=new Actions(driver);
			WebElement a=driver.findElement(By.xpath(XPATH));
			act.moveToElement(a).build().perform();

			outputParameters.put("STATUS", "PASS");
			outputParameters.put("MESSAGE", "methodUsed: mouseOver, Input Given: "+ inputParameters[0].toString());
			
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE", "methodUsed: mouseOver, Input Given: "+ inputParameters[0].toString());
			
		}
		return outputParameters;
	}
	
	public static Hashtable<String,Object> sendKey(Object[]inputParameters) 								//1) Enter UserName 2)Enter Password
	{
		try
		{
			String XPATH=(String) inputParameters[0];
			String USERNAME=(String) inputParameters[1];
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
			driver.findElement(By.xpath(XPATH)).sendKeys(USERNAME);
			
			outputParameters.put("STATUS", "PASS");
			outputParameters.put("MESSAGE", "methodUsed: sendKey, Input Given: "+ inputParameters[1].toString());
			
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE", "methodUsed: sendKey, Input Given: "+ inputParameters[1].toString());
		}
		return outputParameters;
	}
	
	public static Hashtable<String,Object> validation(Object[]inputParameters) 								//1) Enter UserName 2)Enter Password
	{
		try
		{
			String XPATH=(String) inputParameters[0];									//xpath
			String text=(String) inputParameters[1];									//name
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
			String actualText=driver.findElement(By.xpath(XPATH)).getText();			//name
		
			if (actualText.equalsIgnoreCase(text))
			{
				System.out.println("Test Case Pass");
			}
			else
			{
				System.out.println("Test Case Fail");
			}
			
			outputParameters.put("STATUS", "PASS");
			outputParameters.put("MESSAGE", "methodUsed: validation, Input Given: "+ inputParameters[1].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE", "methodUsed: validation, Input Given: "+ inputParameters[1].toString());
		}
		
		return outputParameters;
		
	}
	
	public static Hashtable<String,Object> validationforInvalid(Object[]inputParameters) 				//1) Enter UserName 2)Enter Password
	{
		try
		{
			String XPATH=(String) inputParameters[0];								//namepath
			String text=(String) inputParameters[1];								//name
		
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
			String actualText=driver.findElement(By.xpath(XPATH)).getText();		//name
		
			if (actualText.equalsIgnoreCase(text))
			{
				System.out.println("Test Case Pass");
			}
			else 
			{
				System.out.println("Test Case Fail");
			}
			
			outputParameters.put("STATUS", "PASS");
			outputParameters.put("MESSAGE", "methodUsed: validationforInvalid, Input Given: "+ inputParameters[1].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE", "methodUsed: validationforInvalid, Input Given: "+ inputParameters[1].toString());
		
		}	
		
		return outputParameters;
	}
	
	public static Hashtable<String,Object> browserClose()
	{
		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.close();
		return outputParameters;
	}
	
	
}
