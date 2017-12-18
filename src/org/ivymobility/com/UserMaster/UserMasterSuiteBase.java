package org.ivymobility.com.UserMaster;


import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;

public class UserMasterSuiteBase extends  TestBase{

	@BeforeSuite

	public void checkSuiteSkip() throws Exception
	{ 
		initialize();
		openBrowser();
	

		distributorLogin();
		
		
		
	
	   
	    
	    APP_LOGS.debug("Checking Runmode of suitexls");
	    if (!TestUtil.isSuiteRunnable(suitexls,"UserMaster"))
		{

			//System.out.println(Smoketestsuitexls.getRowCount("testcase"));
			APP_LOGS.debug("Skipping the execution of  DistributorManagementSuitexls as the runmode of the suite was set to NO");
			throw new SkipException(" RunMode of  DistributorManagementSuitexls  is set to No, therefore skipping all test cases in DistributorManagementSuitexls");
			
		}

		}
		
	@AfterSuite
	public void tearDown()  {
		
		
	
	try
	{
		driver.close();
	}catch(NullPointerException e)	
	{
		System.out.println(e);
	}
		

			

		}

}
