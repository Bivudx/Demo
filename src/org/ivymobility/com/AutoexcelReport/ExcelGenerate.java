package org.ivymobility.com.AutoexcelReport;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.common.excelreport.ExcelReportGenerator;



public class ExcelGenerate {

public static void main(String[]args) throws ParserConfigurationException, IOException, SAXException
{
ExcelReportGenerator.generateExcelReport("MyProject.xls", "../Nestle/src/org/ivymobility/com/AutoexcelReport");

}
}
