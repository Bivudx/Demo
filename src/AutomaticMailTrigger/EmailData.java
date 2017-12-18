package AutomaticMailTrigger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class EmailData {
	
	public static FileInputStream fis=null;
	public static Workbook wb=null;

	public String arr[]=new String[2];
	
	List<EmailDto> emailList = null;
	public EmailData(String filename) throws InvalidFormatException, IOException
	{
		
		String filePath=filename;
		fis=new FileInputStream(filePath);
		wb=WorkbookFactory.create(fis);
	}

	public String [] loginCredentials()
	{
		Sheet sh=wb.getSheet("Credentials");
		
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			
			Row row=sh.getRow(i);
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				arr[j]=row.getCell(j).getStringCellValue();
			}
			
		}
		
		return arr;
	}
	
	public List<EmailDto>  mailTo()
	{
		Sheet sh=wb.getSheet("TO");
		emailList = new ArrayList<EmailDto>();
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			
			EmailDto dto = new EmailDto();
			Row row=sh.getRow(i);
			
			
			
			 System.out.println("no of rows present :: "+sh.getLastRowNum());
			
			
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				if(j==0)
					dto.email=row.getCell(j).getStringCellValue();
				if(j==1)
					dto.status=row.getCell(j).getStringCellValue();
			
			}
			
			emailList.add(dto);
			
		}
		
		return emailList;
		
	}
	
	public List<EmailDto> mailCC()
	{
		Sheet sh=wb.getSheet("CC");
		emailList = new ArrayList<EmailDto>();
	
		
		 System.out.println("no of rows present :: "+sh.getLastRowNum());
		 
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			
			EmailDto dto = new EmailDto();
			Row row=sh.getRow(i);
			
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				
				if(j==0)
					dto.email=row.getCell(j).getStringCellValue();
				if(j==1)
					dto.status=row.getCell(j).getStringCellValue();
				
			}
			emailList.add(dto);
			
		}
		
		return emailList;
		
	}
	
	public String [] getEmailText()
	{
		String arr1[]=new String[2];
		Sheet sh=wb.getSheet("body");
		
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			
			Row row=sh.getRow(i);
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				arr1[j]=row.getCell(j).getStringCellValue();
			}
			
		}
		
		return arr1;
	}
	
	public List<String> getFilePath()
	{
		List<String> pathList=new ArrayList<String>();
		Sheet sh=wb.getSheet("Attachments");
		
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			
			Row row=sh.getRow(i);
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				pathList.add(row.getCell(j).getStringCellValue());
			}
			
		}
		
		return pathList;
	}
	
}
