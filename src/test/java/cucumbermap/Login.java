package cucumbermap;


import java.util.Hashtable;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.HTMLReportGenerator;
import utility.SeleniumOperation;

public class Login 
{
	@When ("^user open \"(.*)\" broswer with exe$")
	 public void bLaunch(String bname)
	 {
		 	Object[] input=new Object[1];
			input[0]=bname;
			SeleniumOperation.browserLaunch(input);
	 }
	
	@When ("^user open url as$")
	 public void openApp()
	 {     
			SeleniumOperation.openApplication();
	 }
	 
	 @When ("^user cancel the Initial Login Window$")
	 public void cancelLoginw()
	 {
		 	Object[] input2=new Object[1];
			input2[0]="//*[@class='_2KpZ6l _2doB4z']";
			SeleniumOperation.clickOnElement(input2);
	 }
	
	 @When ("^user navigate on Login button$")
	 public void mouceOver()
	 {
		 	Object[] input3=new Object[1];
			input3[0]="//*[text()='Login']";
			Hashtable<String,Object> output3=SeleniumOperation.mouseOver(input3);
	 }
	 
	 @When ("^user click on MyProfile$")
	 public void clickOnElemenet()
	 {
		 	Object[] input4=new Object[1];
			input4[0]="//*[text()='My Profile']";
			Hashtable<String,Object> output4=SeleniumOperation.clickOnElement(input4);
			HTMLReportGenerator.StepDetails(output4.get("STATUS").toString(), "^user click on MyProfile$", output4.get("MESSAGE").toString());
	 }
	 
	 @When ("^user enter \"(.*)\" as username$")
	 public void userName(String uName) throws InterruptedException
	 {
		 	Thread.sleep(5000);	
		 	Object[] input5=new Object[2];
		 	input5[0]="(//*[@type='text'])[2]";
			input5[1]=uName;
			Hashtable<String,Object> output5=SeleniumOperation.sendKey(input5);
			HTMLReportGenerator.StepDetails(output5.get("STATUS").toString(), "^user enter \"(.*)\" as username$", output5.get("MESSAGE").toString());
	 }
	 
	 @When ("^user enter \"(.*)\" as password$")
	 public void passWord(String passWord)
	 {
		 	Object[] input6=new Object[2];
		 	input6[0]="//input[@type='password']";
			input6[1]=passWord;
			Hashtable<String,Object> output6=SeleniumOperation.sendKey(input6);
			HTMLReportGenerator.StepDetails(output6.get("STATUS").toString(), "^user enter \"(.*)\" as password$", output6.get("MESSAGE").toString());
		
	 }
	 
	 @When ("^user click on Login button$")
	 public void loginButton() 
	 {
		 	Object[] input7=new Object[1];
			input7[0]="(//*[@type='submit'])[2]";
			Hashtable<String,Object> output7=SeleniumOperation.clickOnElement(input7);
			HTMLReportGenerator.StepDetails(output7.get("STATUS").toString(), "^user click on Login button$", output7.get("MESSAGE").toString());
	 }
	 
	 @Then ("^Aplication shows user profile to user$")
	 public void valid () throws InterruptedException
	 {
		 	Thread.sleep(5000);
		 	Object[] input8=new Object[2];
		 	input8[0]="//*[@class='_1ruvv2']";
			input8[1]="AVI THANGE";
			Hashtable<String,Object> output8=SeleniumOperation.validation(input8);
			HTMLReportGenerator.StepDetails(output8.get("STATUS").toString(), "^Aplication shows user profile to user$", output8.get("MESSAGE").toString());
	 }	
	 
	 @Then ("^browser close$")
		public void bclose()
		{
			
			Hashtable<String, Object>input20p=SeleniumOperation.browserClose();
			
			HTMLReportGenerator.StepDetails(input20p.get("STATUS").toString(),"^browser close$",input20p.get("MESSAGE").toString() );
		}
		 
	
}
