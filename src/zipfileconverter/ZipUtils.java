package zipfileconverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.ivymobility.com.base.TestBase;


public class ZipUtils
{

	private List<String> fileList;


	// SourceFolder path
	private static String SOURCE_FOLDER =null;

	public ZipUtils()
	{
		fileList = new ArrayList<String>();
	}

	public static void main(String[] args) throws InvalidFormatException, IOException 
	{
		String fileName="../MerchandizingActivities/src/zipfileconverter/zip.xls";
		PathData e1=new PathData(fileName);
		List<PathDto> pathList = e1.getPath();
		System.out.println("pathList :"+pathList);
		
		for(PathDto dto:pathList){
			System.out.println("inside for loop :");
			if(dto.status.equalsIgnoreCase("Y")){
				ZipUtils appZip = new ZipUtils();
				SOURCE_FOLDER = dto.source;
				System.out.println("SOURCE_FOLDER :"+SOURCE_FOLDER);
				appZip.generateFileList(new File(dto.source));
				appZip.zipIt(dto.destination,dto.source);
				SOURCE_FOLDER=null;
				//System.out.println("SOURCE_FOLDER :"+SOURCE_FOLDER);
			}
		}
	}

	public void zipIt(String zipFile,String sourceFile)
	{
		byte[] buffer = new byte[1024];
		String source = "";
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try
		{
			try
			{
				source = sourceFile.substring(sourceFile.lastIndexOf("\\") + 1, sourceFile.length());
			}
			catch (Exception e)
			{
				source = sourceFile;
			}
			fos = new FileOutputStream(zipFile);
			zos = new ZipOutputStream(fos);

			System.out.println("Output to Zip : " + zipFile);
			FileInputStream in = null;

			for (String file : this.fileList)
			{
				System.out.println("File Added :"  + file);
				ZipEntry ze = new ZipEntry(source + File.separator + file);
				zos.putNextEntry(ze);
				try
				{
					in = new FileInputStream(sourceFile + File.separator + file);
					int len;
					while ((len = in.read(buffer)) > 0)
					{
						zos.write(buffer, 0, len);
					}
				}
				finally
				{
					in.close();
				}
			}

			zos.closeEntry();
			System.out.println("Folder successfully compressed");

		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				zos.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void generateFileList(File node)
	{

		// add file only
		if (node.isFile())
		{
			fileList.add(generateZipEntry(node.toString()));

		}

		if (node.isDirectory())
		{
			String[] subNote = node.list();
			for (String filename : subNote)
			{
				generateFileList(new File(node, filename));
			}
		}
	}

	private String generateZipEntry(String file)
	{
		return file.substring(SOURCE_FOLDER.length() , file.length());
	}
}