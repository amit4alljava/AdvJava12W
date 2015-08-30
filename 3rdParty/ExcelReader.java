import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ExcelReader {
	
	public static Object[][] readExcel() throws Exception{
		Object array[][] = new Object[4][3];
		FileInputStream fi = new FileInputStream("D:\\Java2-5WS\\Data.xls");
		HSSFWorkbook workBook = new HSSFWorkbook(fi);
		HSSFSheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		int row = 0;
		boolean isFirstTimeLoop = false;
		while(rows.hasNext()){
			Row currentRow = rows.next();
			if(!isFirstTimeLoop){
				isFirstTimeLoop = true;
				continue;
			}
			Iterator<Cell> cells = currentRow.cellIterator();
			int col = 0;
			while(cells.hasNext()){
				Cell currentCell = cells.next();
				int value = (int)currentCell.getNumericCellValue();
				array[row][col]=value;
				col++;
			}
			row++;
		}
	return  array;
	}

}
