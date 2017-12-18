package Upload.utility.excelvalidation;




import org.apache.poi.ss.usermodel.Cell;



public  class Excelutility {
	
	//for checking the sequence of a column
public static ValidateResponseDTO MandatefieldValidation(Cell cell){
	ValidateResponseDTO dto=new ValidateResponseDTO();	
	if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
		Long celldata=(long) cell.getNumericCellValue();
			if(celldata == null || celldata==0){
				dto. status = "fail";
				dto.description="mandate filed having some null";
			}else{
				dto. status = "pass";
				dto.description="mandate filed validation sucess";
				System.out.println("numeric");
			}	
	}else {
		String celldata=cell.getStringCellValue();
		System.out.println("celldata :::::"+celldata);
		if(celldata == null || celldata.equals("")){
			dto. status = "fail";
			dto.description="mandate filed having some null";
			System.out.println("string");
		}else{
			dto. status = "pass";
			dto.description="mandate filed validation sucess";
		}
	}
	
	
	
	
	return dto;
}








}


	
	
	


