package generic_utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {
	
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream file=new FileInputStream("./src/test/resources/common.properties");
		Properties pr=new Properties();
		pr.load(file);
		return pr.getProperty(key);
	}
	public String getDataFromJsonFile(String key) throws IOException, ParseException  {
		FileReader fis=new FileReader("./src/test/resources/common.json");
		
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fis);
		
		JSONObject jsonObj=(JSONObject) obj;
		
		String value= jsonObj.get(key).toString();
		fis.close();
		return value;
	}
	public String getDataFromExcel(String SheetName,int Row,int Cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/getDataFromExcel.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row rw=sh.getRow(Row);
		Cell cellname=rw.getCell(Cell);
		String name=cellname.getStringCellValue();
		wb.close();
		return name;
	}
}
