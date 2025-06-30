package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of all generic methods related to file operations
 * @author sidharth
 */
public class FileUtility 
{
	/**
	 * This method will read data from property file and return the value to caller
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	/**
	 * This method will read String  Data from the given row and cell and return the value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @returnS
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\datasheet.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	/**
	 * This method will read numeric data from excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public double readintDataFromExcelFile(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\datasheet.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		double numericValue =wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
		return numericValue;
	}
}
