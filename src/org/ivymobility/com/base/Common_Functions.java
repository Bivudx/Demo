package org.ivymobility.com.base;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Common_Functions extends TestBase {
	

	
	
	
	
	
	//@@@@@@@@@@@This is the method for verify check box it is checked or not@@@@@@@@@@@@@@@@@@@@@@@@
	public static void verifyCheckbox(String object) {
		try{
			//Thread.sleep(1000);
		WebElement element = TestBase.getElement(driver,
				TestBase.OR.getProperty(object));
		boolean status = element.isSelected();
		if (status == true) {
			APP_LOGS.info("Web element already selected");
		} else {
			element.click();
			APP_LOGS.info("check box clicked successfully");
		}
		
		}catch(NoSuchElementException e)
    	{
		    System.out.println(e);
		    
		    
    	TestBase.isTestPass=false;
    	TestBase.fail=true;
    		System.out.println("####################################");
    		Assert.assertEquals("Fail", "Pass");
    	}
    	catch(NullPointerException e)
    	{
    	    System.out.println(e);
    		isTestPass=false;
    		fail=true;
    		System.out.println("####################################");
    		Assert.assertEquals("Fail", "Pass");
    	}
    	
    catch (Exception e)
    {
    System.out.println(e);
    	isTestPass=false;
		fail=true;
		System.out.println("####################################");
		Assert.assertEquals("Fail", "Pass");	
    }
	}

	
	
	
	
	//@@@@@@@@@@@This is the method for multiple select List@@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void multiSelectList(String object)
			throws InterruptedException {

		try{
			//Thread.sleep(1000);
		WebElement element = TestBase.getElement(driver,
				TestBase.OR.getProperty(object));
		Select oSelect = new Select(element);
		List<WebElement> elementCount = oSelect.getOptions();
		APP_LOGS.info(elementCount.size());
		for (WebElement webElement : elementCount) {
			APP_LOGS.info(webElement.getText());

		}
		}
		catch(NoSuchElementException e)
    	{
		    System.out.println(e.getMessage());
    		isTestPass=false;
    		fail=true;
    		System.out.println("####################################");
    		Assert.assertEquals("Fail", "Pass");
    	}
    	catch(NullPointerException e)
    	{
    	    System.out.println(e.getMessage());
    		isTestPass=false;
    		fail=true;
    		System.out.println("####################################");
    		Assert.assertEquals("Fail", "Pass");
    	}
    	
    catch (Exception e)
    {
    System.out.println(e.getMessage());
    	isTestPass=false;
		fail=true;
		System.out.println("####################################");
		Assert.assertEquals("Fail", "Pass");	
    }
	}
	
	

	//@@@@@@@@@@@This is the method for navigation @@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void navigate(WebDriver driver, String data) // for navigation
	{

		try {
			driver.navigate().to(data);
		} catch(NoSuchElementException e)
    	{
		    System.out.println(e.getMessage());
    		isTestPass=false;
    		fail=true;
    		System.out.println("####################################");
    		Assert.assertEquals("Fail", "Pass");
    	}
    	catch(NullPointerException e)
    	{
    	    System.out.println(e.getMessage());
    		isTestPass=false;
    		fail=true;
    		System.out.println("####################################");
    		Assert.assertEquals("Fail", "Pass");
    	}
    	
    catch (Exception e)
    {
    System.out.println(e.getMessage());
    	isTestPass=false;
		fail=true;
		System.out.println("####################################");
		Assert.assertEquals("Fail", "Pass");	
    }

	}

	
	
	
	
	//@@@@@@@@@@@This is the method for mouse over on specific webelement @@@@@@@@@@@@@@@@@@@@@@@@
	
	 public static void mouseOver(String object) throws InterruptedException    // to move the mouse pointer on specific webelement
	    {
	    	try{
	    		Thread.sleep(2000);
	    		
	    		element=TestBase.getElement(driver, TestBase.OR.getProperty(object));
	    		
	    		if(element.isDisplayed())
	    		{
	    			  APP_LOGS.info("web element is displayed for MouseOver ");
	    		  Actions actions=new Actions(driver);
	    		  actions.moveToElement(element);
	    		  actions.click().build().perform();
	    		
	    		  APP_LOGS.info("MouseOver Done on WebElement");
	    		  
	    		  
	    		  
	    		}else
	    		{
	    			APP_LOGS.error("Unable to do MouseOver");
	    		}
	    	}
	    	catch(NoSuchElementException e)
	    	{
			    System.out.println(e.getMessage());
	    		isTestPass=false;
	    		fail=true;
	    		System.out.println("####################################");
	    		Assert.assertEquals("Fail", "Pass");
	    	}
	    	catch(NullPointerException e)
	    	{
	    	    System.out.println(e.getMessage());
	    		isTestPass=false;
	    		fail=true;
	    		System.out.println("####################################");
	    		Assert.assertEquals("Fail", "Pass");
	    	}
	    	
	    catch (Exception e)
	    {
	    System.out.println(e.getMessage());
	    	isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
	    }
	    	
	    
	    }

	 
	//@@@@@@@@@@@This is the method for Double on webelement @@@@@@@@@@@@@@@@@@@@@@@@
	 
	public static void doubleClick(String object) // to double click on the
													// webelement
	{
		try {
			//Thread.sleep(1000);
			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));

			if (element.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.doubleClick(element).build().perform();
				APP_LOGS.info("DoubleClick done on WebElement");
			} else {
				APP_LOGS.error("Unable to do Double Click");
			}

		}
		
		catch(NoSuchElementException e)
    	{
		    System.out.println(e.getMessage());
    		isTestPass=false;
    		fail=true;
    		System.out.println("####################################");
    		Assert.assertEquals("Fail", "Pass");
    	}
    	catch(NullPointerException e)
    	{
    	    System.out.println(e.getMessage());
    		isTestPass=false;
    		fail=true;
    		System.out.println("####################################");
    		Assert.assertEquals("Fail", "Pass");
    	}
    	
    catch (Exception e)
    {
    System.out.println(e.getMessage());
    	isTestPass=false;
		fail=true;
		System.out.println("####################################");
		Assert.assertEquals("Fail", "Pass");	
    }
	}

	
	
	//@@@@@@@@@@@This is the method for Right Click on webelement @@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void rightClick(String object) 
	{
		try {
			//Thread.sleep(1000);
			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));

			if (element.isDisplayed()) {
				Actions a = new Actions(driver);
				a.contextClick(element).build().perform();
				APP_LOGS.info("RightClick done on WebElement");
			} else {
				APP_LOGS.error("Unable to do Right Click");
			}
		} catch(NoSuchElementException e)
    	{
		    System.out.println(e.getMessage());
    		isTestPass=false;
    		fail=true;
    		System.out.println("####################################");
    		Assert.assertEquals("Fail", "Pass");
    	}
    	catch(NullPointerException e)
    	{
    	    System.out.println(e.getMessage());
    		isTestPass=false;
    		fail=true;
    		System.out.println("####################################");
    		Assert.assertEquals("Fail", "Pass");
    	}
    	
    catch (Exception e)
    {
    System.out.println(e.getMessage());
    	isTestPass=false;
		fail=true;
		System.out.println("####################################");
		Assert.assertEquals("Fail", "Pass");	
    }
		
	}

	
	
	
	//@@@@@@@@@@@This is the method for Common Click on webelement @@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void commonClick(String object) 
	{
		try {
			//Thread.sleep(1000);
			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));
if(element==null)
{
	APP_LOGS.error("Element not found");
	TestBase.isTestPass=false;
	TestBase.fail=true;
}


else {
	        if(element.isDisplayed())
	        {
	        	
	        
				element.click();
				APP_LOGS.info("element clicked sucessfully");
			} 
}
		} catch(NoSuchElementException e)
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
		catch(NullPointerException e)
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

		catch (Exception e)
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
	
	
	
	//@@@@@@@@@@@This is the method for checking a webelement is Visible or not@@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void isVisible(String object) 
	{

		try{
			//Thread.sleep(1000);
		boolean element = TestBase.getElement(driver,
				TestBase.OR.getProperty(object)).isDisplayed();

		if (element == true) {

			//isTestPass = true;
			APP_LOGS.info(" WebElement is visible");
		} else {
			//isTestPass = false;

			Assert.assertEquals("pass","fail");
			APP_LOGS.error("WebElement is not visible");
		}
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}

	}

	
	
	
	//@@@@@@@@@@@This is the method for clicking the Checkbox@@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void selectCheckbox(String object) 
	{
		try {
			//Thread.sleep(1000);

			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));

			if (element.isDisplayed()) {
				element.click();

				APP_LOGS.info("Selected Checkbox");
			} else {
				APP_LOGS.error("Unable to Select Checkbox");
			}

		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}

	}
	
	
	
	
	
	//@@@@@@@@@@@This is the method for selecting a Radio button@@@@@@@@@@@@@@@@@@@@@@@@

	public static void selectRadioButton(String object) 
	{
		try {
			//Thread.sleep(1000);

			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));

			if (element.isDisplayed()) {
				element.click();

				APP_LOGS.info("Selected Radio Button");
			} else {
				APP_LOGS.error("Unable to Select Radio Button");
			}

		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}

	}

	
	
	
	//@@@@@@@@@@@This is the method for sending data to a TextField or PasswordField@@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void commonSendKeys(String object, String data) 
	{
		try {
			//Thread.sleep(1000);
			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));
if(element==null)
{
	APP_LOGS.error("Element not found");
	TestBase.isTestPass=false;
	TestBase.fail=true;
}


else {
	        if(element.isDisplayed())
	        {
	        	
	        
				element.sendKeys(data);
				APP_LOGS.info("Enter Data in Code Input Field : : " + data);
			} 
}
		} catch(NoSuchElementException e)
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
		catch(NullPointerException e)
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

		catch (Exception e)
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

	
	
	//@@@@@@@@@@@This is the method for clearing data from a field@@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void commonClear(String object) 
	{
		try {
			//Thread.sleep(1000);
			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));

			if (element.isDisplayed()) {
				element.clear();
				APP_LOGS.info("Cleared Data From Input Field");
			} else {
				APP_LOGS.error("Unable to Clear Data in Input Field");
			}
		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}
	
	
	
	
	//@@@@@@@@@@@This is the method for verify a field is present or not@@@@@@@@@@@@@@@@@@@@@@@@

	public static void verifyFields(String object, String expectedText) {

		try {
			//Thread.sleep(1000);
			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));
			if (element.isDisplayed()) {
				APP_LOGS.info("Element is Displayed : : " + element.getText());

			} else {

			}

		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}

	}
	
	
	
	
	//@@@@@@@@@@@ This is the method for verify a field is present or not @@@@@@@@@@@@@@@@@@@@@@@@

	public static void verifyFields(String object) {

		try {
			
			//Thread.sleep(1000);
			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));
			if (element.isDisplayed()) {
				APP_LOGS.info("Field  is Displayed : : " + element.getText());

			} else {
				APP_LOGS.error("Field is not Displayed");
			}

		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}

	}
	
	
	//@@@@@@@@@@@ This is the method for scroll down @@@@@@@@@@@@@@@@@@@@@@@@
	
	public void scrollDown(Integer numberoftimes, Integer delay) {

		try {
			for (int i = 0; i <= numberoftimes; i++) {

				driver.findElement(By.tagName("body"))
						.sendKeys(Keys.ARROW_DOWN);
			}
			Thread.sleep(delay);

		}catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}
	
	
	
	
	//@@@@@@@@@@@ This is the method for scroll up @@@@@@@@@@@@@@@@@@@@@@@@

	public void scrollUp(Integer numberoftimes, Integer delay) {

		try {
			for (int i = 0; i <= numberoftimes; i++) {
				driver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_UP);
			}
			Thread.sleep(delay);

		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}

	
	
	//@@@@@@@@@@@ This is the method for chooseFiletoUpload @@@@@@@@@@@@@@@@@@@@@@@@
	
	public void chooseFiletoUpload(WebElement sourceFile, String fileName,
			Integer delay) {
		String path = fileName;
		try {
			WebElement sourcefileInput = sourceFile;
			sourcefileInput.sendKeys(path);
			sourcefileInput.click();
			Thread.sleep(delay);

		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}

	
	
	
	
	//@@@@@@@@@@@ This is the method for Switching into a frame  @@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void switchToFrame(String object) 
	{
		try
		{
			//Thread.sleep(1000);
			WebElement frameElement = TestBase.getElement(driver,
				TestBase.OR.getProperty(object));

		if (frameElement.isDisplayed()) {
			driver.switchTo().frame(frameElement);
			APP_LOGS.info("Switched To Frame Element");
			//isTestPass = true;

		} else {

			//isTestPass = false;
			//softAssert.assertEquals(1, 2);
			APP_LOGS.error("Unable to Switch Frame Element");
		}

	}catch(NoSuchElementException e)
	{
		System.out.println(e.getMessage());
		isTestPass=false;
		fail=true;
		System.out.println("####################################");
		Assert.assertEquals("Fail", "Pass");
	}
	catch(NullPointerException e)
	{
		System.out.println(e.getMessage());
		isTestPass=false;
		fail=true;
		System.out.println("####################################");
		Assert.assertEquals("Fail", "Pass");
	}
		
		catch(NoSuchFrameException e)
		
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}

	catch (Exception e)
	{
		System.out.println(e.getMessage());
		isTestPass=false;
		fail=true;
		System.out.println("####################################");
		Assert.assertEquals("Fail", "Pass");	
	}


	}

	
	
	
	//@@@@@@@@@@@ This is the method for checkbox is selected or not @@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void isSelected(String object) 
	{
		try {
			//Thread.sleep(1000);
			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));

			if (element.isDisplayed()) {

			} else {

			}

		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}

	
	
	//@@@@@@@@@@@ This is the method for Selecting Dropdown by Visible Text @@@@@@@@@@@@@@@@@@@@@@@@
	
	
	public static void selectDropdownByVisibleText(String object, String data) 
	{
		try {
			//Thread.sleep(1000);
			WebElement dropdownElement = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));

			if (dropdownElement.isDisplayed()) {
				Select selectElement = new Select(dropdownElement);
				selectElement.selectByVisibleText(data);
				APP_LOGS.info("Dropdown is selected by visible text");
			} else {

				APP_LOGS.error("Dropdown is not selected by visible text");
			}
		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}

	
	
	
	
	//@@@@@@@@@@@ This is the method for Selecting Dropdown by Value @@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void selectDropDownByValue(String object, String value) 
	{
		try {
			//Thread.sleep(1000);
			WebElement dropdownElement = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));

			if (dropdownElement.isDisplayed()) {
				Select selectElement = new Select(dropdownElement);
				selectElement.selectByValue(value);
				APP_LOGS.info("Dropdown is selected by Value");
			} else {
				APP_LOGS.info("Unable to select dropdown is by selecte by Value");
			}
		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}

	
	
	
	//@@@@@@@@@@@ This is the method for Selecting Dropdown by Index @@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void selectDropDownByIndex(String object, int index) 
	{
		try {
			//Thread.sleep(1000);
			WebElement dropdownElement = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));

			if (dropdownElement.isDisplayed()) {
				Select selectElement = new Select(dropdownElement);
				selectElement.selectByIndex(index);
				APP_LOGS.info("Dropdown is selected by Index");
			}
			else{
				APP_LOGS.info("Unable to select dropdown by Select by Index");
			}
		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}

	
	
	
	
	//@@@@@@@@@@@ This is the method for Alert Cancel @@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void alertCancel() 
	{
		try {
			//Thread.sleep(1000);
			//Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			APP_LOGS.info("Alert Text is :: " + alertText);

			alert.dismiss();
			APP_LOGS.info("Clicked On Alert Cancel Button");

		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NoAlertPresentException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}
	
	
	
	
	
	//@@@@@@@@@@@ This is the method for Alert Cancel @@@@@@@@@@@@@@@@@@@@@@@@

	public static void alertAccept() 
	{
		try {
			//Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			APP_LOGS.info("Alert Text is :: " + alertText);

			alert.accept();
			APP_LOGS.info("Clicked On Alert ok Button");

		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NoAlertPresentException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}

	
	
	
	//@@@@@@@@@@@ This is the method for Getting Alert Text @@@@@@@@@@@@@@@@@@@@@@@@
	
	
	public static void verifyAlertText(String object, String data) {
		
		try{
			//Thread.sleep(1000);
		WebElement alertElement = TestBase.getElement(driver,
				TestBase.OR.getProperty(object));
		if (alertElement.isDisplayed()) {
			String alertText = alertElement.getText();
			Assert.assertEquals(alertText, data);
			APP_LOGS.info("Actual is :: " + alertText + " Expected is :: "
					+ data);
		} else {
			APP_LOGS.error("Actual is Not equal with Expected");
		}
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NoAlertPresentException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
		
	}

	
	
	
	
	//@@@@@@@@@@@ This is the method for Accepting Popup @@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void popupAccept(String object) {
		
		try{
			//Thread.sleep(1000);
		WebElement alertAcceptElement = TestBase.getElement(driver,
				TestBase.OR.getProperty(object));
		if (alertAcceptElement.isDisplayed()) {
			alertAcceptElement.click();
			APP_LOGS.info("Clicked on Alert Accept Button");
		} else {
			APP_LOGS.error("Unable to Click on Alert Accept Button");
		}
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}
	}

	
	
	//@@@@@@@@@@@ This is the method for Switching into default content @@@@@@@@@@@@@@@@@@@@@@@@
	
	
	public static void switchToDefaultContent() 
	{
		try {
			//Thread.sleep(1000);
			driver.switchTo().defaultContent();
			APP_LOGS.info("Switched To Default Content");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	//@@@@@@@@@@@ This is the method for verify Error @@@@@@@@@@@@@@@@@@@@@@@@
	
	public static void verifyError(String object, String expected) {

		try {
			//Thread.sleep(1000);
			WebElement element = TestBase.getElement(driver,
					TestBase.OR.getProperty(object));
			String expected_message=TestBase.Messages.getProperty(expected);
			System.out.println("Expected message :: "+expected_message);

			if (element.isDisplayed()) {
				String actual = element.getText();
				Assert.assertEquals(actual, expected_message);
				APP_LOGS.debug("Actual is : : " + actual + "Expected is :: "
						+expected_message);
				APP_LOGS.info("Actual Value is Equal to Expected Value");
			} else {
				APP_LOGS.error("Actual Value is not Equal to Expected Value");
		
			}

		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			isTestPass=false;
			fail=true;
			System.out.println("####################################");
			Assert.assertEquals("Fail", "Pass");	
		}

	}
	//@@@@@@@@@@@This is the method for Common Click for sos module in merchandizing Activities  @@@@@@@@@@@@@@@@@@@@@@@@
		public static void SoscommonClick(String object) 
		{
			try{
				//Thread.sleep(1000);
		WebElement element=driver.findElement(By.xpath(object));
		
			if (element.isDisplayed()) {
				element.click();

				//isTestPass = true;
				APP_LOGS.info("Clicked on WebElement");
			} else {

				APP_LOGS.error("Unable to Click");
			}


			}  	catch(NoSuchElementException e)
				{
					System.out.println(e.getMessage());
					isTestPass=false;
					fail=true;
					System.out.println("####################################");
					Assert.assertEquals("Fail", "Pass");
				}
				catch(NullPointerException e)
				{
					System.out.println(e.getMessage());
					isTestPass=false;
					fail=true;
					System.out.println("####################################");
					Assert.assertEquals("Fail", "Pass");
				}
		
				catch (Exception e)
				{
					System.out.println(e.getMessage());
					isTestPass=false;
					fail=true;
					System.out.println("####################################");
					Assert.assertEquals("Fail", "Pass");	
				}
		}
		
		
		
}
