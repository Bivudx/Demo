package org.ivymobility.com.base;








import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.ivymobility.com.utils.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import junit.framework.Assert;

public class TestBase
{
	public static Logger APP_LOGS = null;
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static Properties Messages = null;
	public static Properties Screenshot = null;

	public static Xls_Reader suitexls=null;
	


	public static Xls_Reader UserMasterSuitexls=null;
	public static WebDriver driver=null;
	public static boolean isinitialized = false;
	public static boolean isBrowserOpened= false;
	
	public static boolean pass=false;
	public static boolean fail=false;
	public static boolean skip=false;

	//for all variable for excel status reporting
	public static boolean isTestPass = true;//This is for After Test 
  
    //public	static boolean skip=false;
	public static WebElement element=null;
	// initializing the Tests
public static  void initialize() throws Exception
	
{
	if(!isinitialized)
	{
		
	
    // -----------------Initialize logs------------------
	APP_LOGS = Logger.getLogger("devpinoyLogger");
	//System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
	
	// -------------------Initialize config file---------------
			// CONFIG Properties 
	APP_LOGS.debug("Loading Properties files");   // Initialize properties files and putting them into log files.
	CONFIG = new Properties();
	
	FileInputStream ip = new FileInputStream("../Nestle/src/org/ivymobility/com/resources/Config.properties");
	CONFIG.load(ip);
	//System.out.println(CONFIG.getProperty("ScreenShotPath"));
			
			// OR Properties
    OR = new Properties();
	
    FileInputStream ip1 = new FileInputStream("../Nestle/src/org/ivymobility/com/resources/ObjectRepository.properties");
	OR.load(ip1);
	
	//message property file
	Messages=new Properties();
	  FileInputStream ip2 = new FileInputStream("../Nestle/src/org/ivymobility/com/resources/Messages.properties");
	  Messages.load(ip2);
	  //for screenshot propery file
	  Screenshot=new Properties();
		  FileInputStream ip3 = new FileInputStream("../Nestle/src/org/ivymobility/com/resources/ScreenshotPath.properties");
		  Screenshot.load(ip3);
		
		  
	
	  
	APP_LOGS.debug("Loaded Properties files successfully");   // indicate that properties files are successfully loaded in the log files.
	
	// ------------------Initialize excel file------------------
	//System.out.println (System.getProperty("user.dir"));
	APP_LOGS.debug("Loading All Excel files.....");   // Initialize Excel files and indicating them into log files.
	suitexls = new Xls_Reader("../Nestle/src/org/ivymobility/com/xlsfiles/Suite.xls");  

	

	UserMasterSuitexls=new Xls_Reader("../Nestle/src/org/ivymobility/com/xlsfiles/UserMaster.xls");
	APP_LOGS.debug("Loaded All Excel files successfully");   // indicate that Excel files are successfully loaded in the log files.
	
	isinitialized= true;
/*	pass = false;
	fail = false;
	skip = false;*/
	}
	
	
	
}
@SuppressWarnings("deprecation")
public static WebElement getElement(WebDriver driver, String locator){
	APP_LOGS.info("---------------------locator---------"+locator);
	String[] objects=locator.split("-");
	
	String locatorType=objects[0];
	String locatorValue=objects[1];
	WebElement element = null;
	//By by = null;
try
{
	

	if(locatorType.equals("clsName")){
	
		APP_LOGS.info("---------------------clsName---------");
			   element= driver.findElement(By.className(locatorValue));
	//This block will find element using Key value from web page and return It.
	//	by=By.className(locatorValue);
	
	
	
		
	}else if(locatorType.equals("cssSel")){
		APP_LOGS.info("---------------------cssSel---------");
	
			element= driver.findElement(By.cssSelector(OR.getProperty(locatorValue)));
			//This block will find element using Key value from web page and return It.
		//by=By.cssSelector(locatorValue);
			

		
	}else if(locatorType.equals("IDE")){
		APP_LOGS.info("---------------------IDE---------");
		
			element= driver.findElement(By.id(locatorValue));
			//This block will find element using Key value from web page and return It.
		//by=By.id(locatorValue);
			APP_LOGS.info("---------------------element---------"+element);
		
	}else if(locatorType.equals("lnkTxt")){

		//This block will find element using Key value from web page and return It.
			element= driver.findElement(By.linkText(locatorValue));
			//by=By.linkText(locatorValue);

			APP_LOGS.info("---------------------lnkTxt---------");
		
   }else if(locatorType.equals("name")){
	   
		   element= driver.findElement(By.name(locatorValue));
			//This block will find element using Key value from web page and return It.
		//by=By.name(locatorValue);
		   APP_LOGS.info("---------------------name---------");
   }else if(locatorType.equals("plLinkTxt")){
	  
			//This block will find element using Key value from web page and return It.
		   element= driver.findElement(By.partialLinkText(OR.getProperty(locatorValue)));  
		//by=By.partialLinkText(locatorValue);
			
		   APP_LOGS.info("---------------------plLinkTxt---------");
		
   }else if(locatorType.equals("tagName")){
	 
			//This block will find element using Key value from web page and return It.
	   
		   element= driver.findElement(By.tagName(OR.getProperty(locatorValue)));
		//by=By.tagName(locatorValue);
		   APP_LOGS.info("---------------------tagName---------");
   }else if(locatorType.equals("XPH")){

			//This block will find element using Key value from web page and return It.
	   
	   
		   element= driver.findElement(By.xpath(OR.getProperty(locatorValue)));
		//by=By.xpath(locatorValue);
		   APP_LOGS.info("---------------------XPH---------");
		
   }else {
	   APP_LOGS.info("Element  not Identified");  
   }
	
	/*for(int i=0; i<2; i++){
	   if(driver.findElements(by).size()>0){
		   element =driver.findElement(by);
		   break;
		   } else {
			   APP_LOGS.error("Unable to find Element");
		    
		
			}
	   }*/
	 
/*	 if(driver.findElements(by).size()>0){
		   element =driver.findElement(by);
	 }*/
		   //element =driver.findElement(by);
}catch(Exception e)
{
	TestBase.isTestPass=false;
	TestBase.fail=true;
	   APP_LOGS.error("----------->>>>",e);  
		APP_LOGS.error("Error-",e);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
	   Assert.fail(exceptionAsString);
}
		   return element;
	   }



//-------------------Initialize WebDriver----------------

//Case 1:
// opening browser as per Config property file
public void openBrowser() throws InterruptedException
{
if (!isBrowserOpened)
	{
		if (CONFIG.getProperty("browserType").equals("firefox"))
		{
			//FirefoxProfile fp = new FirefoxProfile();
			//fp.setPreference("webdriver.load.strategy", "unstable");
			
			
			driver=new FirefoxDriver();
			
	        driver.manage().window().maximize();
	       // loginCM();
		}
		else if (CONFIG.getProperty("browserType").equals("IE"))
		{
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
	        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	        driver = new InternetExplorerDriver(ieCapabilities);
	       
		}
		else if (CONFIG.getProperty("browserType").equals("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions");
Thread.sleep(5000);
			System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\Selenium jar's\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();

		}
		isBrowserOpened= true;
		
		String waitTime=CONFIG.getProperty("default_implicitlyWait");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(waitTime),TimeUnit.SECONDS);
	}
}

//***********************
// case 2:
//Closing the opened browser
//************************
public void closeBrowser()
	{
		driver.quit();	
		isinitialized = false;
		isBrowserOpened = false;
		
	}





public void adminLogin() throws InterruptedException
{
    driver.get(CONFIG.getProperty("baseUrl"));
   
    WebElement usernameElement=TestBase.getElement(driver,TestBase.OR.getProperty("username"));
    if(usernameElement != null){
    usernameElement.sendKeys(CONFIG.getProperty("adminUsername"));
    APP_LOGS.info("Entered Data in username Input Field");
	}else{
	APP_LOGS.error("Unable to Enter Data in username Input Field");	
	}
    
    
    
    WebElement passwordElement=TestBase.getElement(driver,TestBase.OR.getProperty("password"));
    if(passwordElement != null){
    passwordElement.sendKeys(CONFIG.getProperty("adminPassword"));
    APP_LOGS.info("Entered Data in Password Input Field");
	}else{
	APP_LOGS.error("Unable to Enter Data in Password Input Field");	
	}
    
    WebElement loginButtonElement=TestBase.getElement(driver,TestBase.OR.getProperty("loginButton"));
    if(loginButtonElement != null){
    loginButtonElement.click(); 
    APP_LOGS.info("Clicked on Login Button");
	}else{
	APP_LOGS.error("Unable to Click on Login Button");	
	}
   
}

public void distributorLogin() throws InterruptedException
{
    driver.get(CONFIG.getProperty("baseUrl"));
   
    //"Code Map List".equals(driver.getTitle());
    WebElement usernameElement=TestBase.getElement(driver,TestBase.OR.getProperty("username"));
    if(usernameElement != null){
    usernameElement.sendKeys(CONFIG.getProperty("distributorUsername"));
    APP_LOGS.info("Entered Data in username Input Field");
	}else{
	APP_LOGS.error("Unable to Enter Data in username Input Field");	
	}
    
    
    
    WebElement passwordElement=TestBase.getElement(driver,TestBase.OR.getProperty("password"));
    if(passwordElement != null){
    passwordElement.sendKeys(CONFIG.getProperty("distributorPassword"));
    APP_LOGS.info("Entered Data in Password Input Field");
	}else{
	APP_LOGS.error("Unable to Enter Data in Password Input Field");	
	}
    
    WebElement loginButtonElement=TestBase.getElement(driver,TestBase.OR.getProperty("loginButton"));
    if(loginButtonElement != null){
    loginButtonElement.click(); 
    APP_LOGS.info("Clicked on Login Button");
	}else{
	APP_LOGS.error("Unable to Click on Login Button");	
	}
   
}
public void openUrl(){
	driver.get(CONFIG.getProperty("url"));
}

// Case: 12 - TestLinkResults Updation


}