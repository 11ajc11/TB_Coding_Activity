package excelCompiler;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;

public class CombineExcel {
	
	//set email and path for data
	
	public static final String id = "11ajc11@gmail.com";
	public static final String DATA1_PATH = "./Data1.xlsx";
	public static final String DATA2_PATH = "./Data2.xlsx";
	
	public static void main(String[] args) throws Exception {
		
		//copy the data to memory in workbooks
		
		Workbook workbook1 = WorkbookFactory.create(new File(DATA1_PATH));
		Workbook workbook2 = WorkbookFactory.create(new File(DATA2_PATH));
		
		//select sheet from workbooks
		
		Sheet sheet1 = workbook1.getSheetAt(0);
		Sheet sheet2 = workbook2.getSheetAt(0);
		
		//checks if sheets have same amount of rows
		SizeChecker.checker(sheet1.getLastRowNum(), sheet2.getLastRowNum());
		
		//initialize arrays
		
		ArrayList<Integer> numberSetOne = new ArrayList<Integer>();
		ArrayList<Integer> numberSetTwo = new ArrayList<Integer>();
		ArrayList<String> wordSetOne = new ArrayList<String>();
		
		//iterate through sheet 1
		
		for (Row row: sheet1) {
            for(Cell cell: row) {
            	
            	//keep track of current location
            	
            	int x = cell.getColumnIndex();
            	int y = cell.getRowIndex();
            	
            	//checks if two objects are same type
            	TypeChecker.checker(cell, sheet2.getRow(y).getCell(x));
            	
            	//do specified task based on current column
            	//multiply column 0
            	
            	if (x == 0 & y > 0) {
            		double cell1 = cell.getNumericCellValue();
            		double cell2 = sheet2.getRow(y).getCell(x).getNumericCellValue();
            		int ans = (int) (cell1 * cell2);
            		numberSetOne.add(ans);
            	}
            	
            	//divide column 1
            	
            	if (x == 1 & y > 0) {
            		double cell1 = cell.getNumericCellValue();
            		double cell2 = sheet2.getRow(y).getCell(x).getNumericCellValue();
            		int ans = (int) (cell1 / cell2);
            		numberSetTwo.add(ans);
            	}
            	
            	//concat column 2
            	
            	if (x == 2 & y > 0) { 
            		String cell1 = cell.getStringCellValue();
            		String cell2 = sheet2.getRow(y).getCell(x).getStringCellValue();
            		String ans = cell1 + " " + cell2;
            		wordSetOne.add(ans);
            	}
            }
        }
		
		//print out arrays 
		System.out.println(id);
		System.out.println(numberSetOne);
		System.out.println(numberSetTwo);
		System.out.println(wordSetOne);
		Send_Post.post_me(id, numberSetOne, numberSetTwo, wordSetOne);
	}	
}