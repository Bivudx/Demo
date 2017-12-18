package org.ivymobility.com.utils;
import java.io.*;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Xls_Writer {

	 public static void main(String[] args) throws InterruptedException { 

	        WebDriver driver = new FirefoxDriver();

	        driver.get("http://www.gmail.com");

	        driver.manage().window().maximize();  
	       
	        WebElement username = driver.findElement(By.id("Email"));
	        driver.findElement(By.id("next")).click();
	        
	        WebElement password=driver.findElement(By.id("Passwd"));
	        driver.findElement(By.id("signIn")).click();

	 try {
	    
	  FileInputStream file = new FileInputStream(new File("D:\\Demo 1st phase\\Automation_IVYCPG_FirstPhase\\src\\org\\ivymobility\\com\\xlsfiles\\Test.xls")); 
	  HSSFWorkbook workbook = new HSSFWorkbook(file);

	  HSSFSheet sheet = workbook.getSheetAt(0);

	        Cell resultCell= sheet.getRow(1).getCell(3);
	        Cell resultcell1=sheet.getRow(2).getCell(3);
	        String usernamevalue = sheet.getRow(1).getCell(2).getStringCellValue();
	        String passwordvalue=sheet.getRow(2).getCell(2).getStringCellValue();
	        username.sendKeys(usernamevalue);
	        password.sendKeys(passwordvalue);

	        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

	        String usernametext=  username.getAttribute("value");
	        String passwordtext= password.getAttribute("value");

	        if(usernametext.equals(usernamevalue)){
	                System.out.println("set is successful.");
	                resultCell.setCellValue("PASS");
	        } else {
	                System.out.println("set is not successful.");
	                resultCell.setCellValue("FAIL");
	        }
	        if(passwordtext.equals(passwordvalue)){
	            System.out.println("set is successful.");
	            resultcell1.setCellValue("PASS");
	    } else {
	            System.out.println("set is not successful.");
	            resultcell1.setCellValue("FAIL");
	    }

	  
	  file.close();

	  FileOutputStream outFile =new FileOutputStream(new File("D:\\Demo 1st phase\\Automation_IVYCPG_FirstPhase\\src\\org\\ivymobility\\com\\xlsfiles\\Test.xls"));
	  workbook.write(outFile);
	  outFile.close();

	 } catch (FileNotFoundException fnfe) {
	  fnfe.printStackTrace();
	 } catch (IOException e) {
	  e.printStackTrace();
	 }
	 driver.findElement(By.name("signIn")).click();

	 }
}
