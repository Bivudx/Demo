package Upload.utility.excelvalidation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Retailer_Validation {
	
	
	public static String path="../Nestle/src/org/ivymobility/com/xlsfiles/Suite.xls";
	public static String sheetname="TestSuiteSheet";
	public static Properties input = null;
	public static void main(String args[]) throws IOException, EncryptedDocumentException, InvalidFormatException 
	{
FileInputStream fis= new FileInputStream(path);
Workbook wb=WorkbookFactory.create(fis);
Sheet sh=wb.getSheet(sheetname);
int rowcount=sh.getLastRowNum();

input = new Properties();

FileInputStream ip = new FileInputStream("../Nestle/src/Upload/utility/excelvalidation/Input.properties");
input.load(ip);



//for mandate field validation
for(int i=1;i<=rowcount;i++)
{

	Row row=sh.getRow(i);
	for(int j=0;j<row.getLastCellNum();j++)
	{

		
		if(j==0&&input.getProperty("retal_col1M").equals("Y"))
		{
			System.out.println(row.getCell(j));
			
			ValidateResponseDTO dto=Excelutility.MandatefieldValidation(row.getCell(j));
			
			
			
			Cell cell=row.createCell(3);

			cell.setCellType(cell.CELL_TYPE_STRING);

			cell.setCellValue(dto.status);
			FileOutputStream fos=new FileOutputStream(path);
			wb.write(fos);
			fos.close();
			
			
			Cell cell1=row.createCell(4);

			cell1.setCellType(cell.CELL_TYPE_STRING);

			cell1.setCellValue(dto.description);
			FileOutputStream fos1=new FileOutputStream(path);
			wb.write(fos1);
			fos.close();
			
System.out.println(dto.status);
System.out.println(dto.description);


		}
		
		
	}
	

	

	System.out.println();
}



//for checking theno of columns
for(int i=0;i<=0;i++)
{
	Row row=sh.getRow(i);
	for(int j=0;j<row.getLastCellNum();j++)
	{
		if(j==0)
		{
		int  colno=row.getLastCellNum();
		String s = Integer.toString(colno); 
		
		
		if(s.equals(input.getProperty("last_row_no")))
		{
			System.out.println("the no of columns are ok");
		}
		else
		{
			System.out.println("the no of columns are not ok");
		}
		}
	}
	
	}

//for checking the sequence of columns


for(int i=0;i<=0;i++)
{
	Row row=sh.getRow(i);

		if(row.getCell(0).getStringCellValue().equals(input.getProperty("retal_col1")))
		{
			System.out.println("column 1 is ok");
		}
		else
		{
			System.out.println("column no 1 is not ok");
		}
		
		if(row.getCell(1).getStringCellValue().equals(input.getProperty("retal_col2")))
		{
			System.out.println("column 2 is ok");
		}
		else
		{
			System.out.println("column 2 is not ok");
		}	
		
		if(row.getCell(2).getStringCellValue().equals(input.getProperty("retail_col3")))
		{
			System.out.println("column 3 is ok");
		}
		else
		{
			System.out.println("column 3 is not ok");
		}	
		
		
	
	
	}

	}
	
	
	
	

	
	
}
	
	


