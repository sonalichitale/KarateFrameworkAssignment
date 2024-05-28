package support;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.ibm.icu.text.PluralRules.Operand.n;

public class jsonfile {
    String data = null;



    public static String create_json_body(String id, String name) {
        String flag = null;
        try {
            flag = "{\n" +
                    "  \"id\": "+id+",\n" +
                    "  \"category\": {\n" +
                    "    \"id\":  0,\n" +
                    "    \"name\": \"string\"\n" +
                    "  },\n" +
                    "  \"name\": \"" + name + "\",\n" +
                    "  \"photoUrls\": [\n" +
                    "    \"string\"\n" +
                    "  ],\n" +
                    "  \"tags\": [\n" +
                    "    {\n" +
                    "      \"id\": 0,\n" +
                    "      \"name\": \"string\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"status\": \"available\"\n" +
                    "}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;

    }

    public static String read_And_Print_XL_AsPerTestData(String testcasename , String columnName){

        String data = null;

        try{

            String XLFilePath = System.getProperty("user.dir")+"/src/Petdata1.xlsx";
            FileInputStream myxlfile = new FileInputStream(XLFilePath);
            Workbook workbook = new XSSFWorkbook(myxlfile);
            Sheet sheet = workbook.getSheet("Petdata");
            int lastRow = sheet.getLastRowNum();
            // System.out.println("The last row which has data =="+lastRow);

            // Loop for Row Iteration...
            for(int i=0;i<=lastRow;i++){
                Row row = sheet.getRow(i);
                // Get the last Column which has data
                int lastCell = row.getLastCellNum();
                Cell cell = row.getCell(0);
                String runtimeTestCaseName = cell.getStringCellValue();
                //   System.out.println("The First Column Value is ==>"+runtimeTestCaseName);
                if(runtimeTestCaseName.equals(testcasename)) {
                    // Loop for Column Iteration ...
                    Row RowNew = sheet.getRow(0);
                    for(int j=0;j<lastCell;j++){
                        Cell cellnew = RowNew.getCell(j);
                        String RunTimeCallValue = cellnew.getStringCellValue();
                        if(RunTimeCallValue.equals(columnName)) {
                            data = sheet.getRow(i).getCell(j).toString();
                             System.out.println("The XL value is ==>" + data);
                        }
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
}





