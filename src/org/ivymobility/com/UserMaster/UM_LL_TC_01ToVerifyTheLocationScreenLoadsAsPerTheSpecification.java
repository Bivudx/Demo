package org.ivymobility.com.UserMaster;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.io.FileUtils;
import org.ivymobility.com.base.Common_Functions;
import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UM_LL_TC_01ToVerifyTheLocationScreenLoadsAsPerTheSpecification extends UserMasterSuiteBase{
	// Run Mode of a test in a suite
			String runmodes[]=null; 
			static int count=-1;



				@BeforeTest
				public void checkTestSkip() 
				{
				
					if(!TestUtil.isTestCaseRunnable(UserMasterSuitexls,this.getClass().getSimpleName()))
					{
						
						 TestBase .skip=true;
						TestUtil.reportTestResult(UserMasterSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(UserMasterSuitexls, this.getClass().getSimpleName()), "skipped");
					
						APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
						throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
					}
					// load the runmodes of the tests
					runmodes = TestUtil.getDataSetRunmodes(UserMasterSuitexls,this.getClass().getSimpleName() );
					
					
				}
				
				
	
	@Test
	public void UM_LL_TC_01() throws IOException,InterruptedException{
		openUrl();
	try
	{
		
	
		APP_LOGS.info("******************************Execution starts for the test case UM_LL_TC_01***********************************");
		
//Common_Functions.commonClick("managerlink");

Common_Functions.commonClick("newcustomer");

Common_Functions.commonSendKeys("custname", "bivu");
Common_Functions.commonSendKeys("dob", "05-06-1991");
Common_Functions.commonSendKeys("add", "rrhtr,gygugkuyagkUHILUFHIUHUI,GGADSGG");
Common_Functions.commonSendKeys("city", "bbsr");
Common_Functions.commonSendKeys("state", "odisha");
Common_Functions.commonSendKeys("pinno", "752068");
Common_Functions.commonSendKeys("email", "bivudx@gmail.com");
Common_Functions.commonClick("submit");
Alert alt =driver.switchTo().alert();
System.out.println(alt.getText());
alt.accept();
//driver.findElement(By.id("hb")).click();
		
		APP_LOGS.info("******************************Executing the test case UM_LL_TC_01 has finished***********************************");
	}
	catch(Exception e)
	{
		APP_LOGS.error("Error-",e);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
	
		//System.out.println(e);
    	TestBase.isTestPass=false;
    	TestBase.fail=true;
		System.out.println("####################################");
		Assert.fail(exceptionAsString);
	}
	}
	@AfterMethod
	public void reportDatasetResult() throws IOException   //after method will be executed for each dataset every time test case is executed....
	{
		if(TestBase .skip)
		{
			TestUtil.reportDataSetResult(UserMasterSuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
		}
		
		else if(TestBase .fail)
		{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		     FileUtils.copyFile(scrFile, new File(TestBase.Screenshot.getProperty("Usermaster_fail")+this.getClass().getSimpleName()+System.currentTimeMillis()+"IVY.png")); 
	
			
			TestUtil.reportDataSetResult(UserMasterSuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			
			
			
			
	
			
			
			
		}
		else 
		{
			
			

			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		     FileUtils.copyFile(scrFile, new File(TestBase.Screenshot.getProperty("Usermaster_pass")+this.getClass().getSimpleName()+System.currentTimeMillis()+"IVY.png")); 
				
			TestUtil.reportDataSetResult(UserMasterSuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		
		
		
		
		
		
		}
		
		
		
		TestBase .skip = false;
		TestBase .fail= false;
		TestBase.pass= false;
	
		
	}

	@AfterTest


	public void reportTestResult()
	{
		
	
		
		if(TestBase.isTestPass)
		{
			TestUtil.reportTestResult(UserMasterSuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(UserMasterSuitexls, this.getClass().getSimpleName()), "Pass");
		}
			else 
			{
			TestUtil.reportTestResult(UserMasterSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(UserMasterSuitexls, this.getClass().getSimpleName()), "Fail");
			}
			
		TestBase .isTestPass=true;
	}

	
  

	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(UserMasterSuitexls,this.getClass().getSimpleName());
				
		}

	




}
