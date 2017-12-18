package zipfileconverter;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PathData {
	
	public static FileInputStream fis=null;
	public static Workbook wb=null;

	
	List<PathDto> pathList = null;
	public PathData(String filename) throws InvalidFormatException, IOException
	{
		System.out.println("filename :"+filename);
		String filePath=filename;
		fis=new FileInputStream(filePath);
		wb=WorkbookFactory.create(fis);
	}

	
	public List<PathDto>  getPath()
	{
		Sheet sh=wb.getSheet("zipinput");
		pathList = new ArrayList<PathDto>();
		System.out.println("sh :"+sh);
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			System.out.println("row :");
			PathDto dto = new PathDto();
			Row row=sh.getRow(i);
			System.out.println("row :"+row);
			
			
			 System.out.println("no of rows present :: "+sh.getLastRowNum());
			
			
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				if(j==0)
					dto.source=row.getCell(j).getStringCellValue();
				if(j==1)
					dto.destination=row.getCell(j).getStringCellValue();
				if(j==2)
					dto.status=row.getCell(j).getStringCellValue();
			
			}
			
			pathList.add(dto);
			
		}
		
		return pathList;
		
	}
	
}
