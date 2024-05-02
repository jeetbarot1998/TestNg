import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;

public class ExcelReaderDemo {

    @SneakyThrows
    @Test
    public void ExcelReader(){
        String filePath = System.getProperty("user.dir") + "\\datasource\\student.xlsx";
        System.out.println(filePath);
        FileInputStream fis = new FileInputStream(filePath);
        Workbook book = new XSSFWorkbook(fis);
        Sheet sheet = book.getSheet("Student Info");
        int LastRow = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        for(int r = 0; r <= LastRow; r++){
            Row row = sheet.getRow(r);
            for(int col = 0; col< lastCellNum; col++){
                Cell cell = row.getCell(col);
                switch (cell.getCellType()){
                    case STRING:
                        System.out.println(cell.getStringCellValue());
                        break;

                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue());
                        break;
                }
//                System.out.print(" "  + cell.toString());
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    @SneakyThrows
    @Test
    public void ExcelReaderIterator(){
        String filePath = System.getProperty("user.dir") + "\\datasource\\student.xlsx";
        System.out.println(filePath);
        FileInputStream fis = new FileInputStream(filePath);
        Workbook book = new XSSFWorkbook(fis);
        Sheet sheet = book.getSheet("Student Info");
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()){
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.iterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                switch (cell.getCellType()){
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    @Test
    public void WriteToWorkBook() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Student Information");
        Object[][] studentInfo = {
                {"Name", "Age", "Gender", "Class"},
                {"ABC", 10, "F", 5},
                {"CDE", 12, "M", 7},
                {"ONS", 15, "F", 10}
        };
        int rows = studentInfo.length;
        int columns = studentInfo[0].length;
        for(int r = 0 ; r < rows; r++){

            Row row = sheet.createRow(r);
            for (int c = 0 ; c < columns; c++){
                Cell cell = row.createCell(c);
                Object value = studentInfo[r][c];
                if(value instanceof String){
                    cell.setCellValue((String) value);
                }
                if(value instanceof Integer){
                    cell.setCellValue((Integer) value);
                }
            }
        }
        String filePath = System.getProperty("user.dir") + "\\datasource\\student1.xlsx";
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
    }
}
