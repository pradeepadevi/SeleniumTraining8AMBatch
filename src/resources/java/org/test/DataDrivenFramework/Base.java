package org.test.DataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {

	static List <LinkedHashMap<String,String>> mapDataList = new ArrayList<LinkedHashMap<String,String>>();
	private static WebDriver driver=null;
	
	public static WebDriver getDriver()
	{
		return driver;     
	}
	
	
	public static void initializeDriver(String website) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Greens-12\\pradeepa\\DataDrivenFramework\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(website);
	}
	
	public static File openExcel(String fileLocation) {
		// TODO Auto-generated method stub
		File excelLocation = new File(fileLocation);
		return excelLocation;

	}
	
	public static String getData(int rowNum, String columnName)
	{
		return mapDataList.get(rowNum).get(columnName);
	}
	
	
	public static void initializeExcelData(File excelLocation, String sheetName) throws IOException {
		// TODO Auto-generated method stub
		
		
		FileInputStream stream = new FileInputStream(excelLocation);
		
		Workbook wb = new XSSFWorkbook(stream);
		
		Sheet s = wb.getSheet(sheetName);
		
		
		//List <LinkedHashMap<String,String>> mapDataList = new ArrayList<LinkedHashMap<String,String>>();
		
		Row headerRow = s.getRow(0);
		
		for (int i = 1; i < s.getPhysicalNumberOfRows() ; i++)
		{
			Row currentRow = s.getRow(i);
			LinkedHashMap<String,String> hashMap = new LinkedHashMap<String, String>();
			
			for (int j=0; j< headerRow.getPhysicalNumberOfCells();j++)
			{
				Cell cellValue = currentRow.getCell(j);
				
				int cellType = cellValue.getCellType();
				
				
				if(cellType == 1)
				{
					String stringCellValue = cellValue.getStringCellValue();
					hashMap.put(headerRow.getCell(j).getStringCellValue(), stringCellValue);
				}
				
				else if (cellType == 0)
				{
					long numericCellValue = (long)cellValue.getNumericCellValue();
					hashMap.put(headerRow.getCell(j).getStringCellValue(), String.valueOf(numericCellValue));
				}
				
				//System.out.println(hashMap);
			}
			
			mapDataList.add(hashMap);
			
		}
		//System.out.println(mapDataList);
		//return mapDataList.get(rowNum).get(columnName);

	}
	
	public static void updateExcel(File excelLocation,String sheetName, String columnName, String str) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream stream = new FileInputStream(excelLocation);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet(sheetName);
		Row row = s.getRow(0);
		int physicalNumberOfCells = row.getPhysicalNumberOfCells();
		row.createCell(physicalNumberOfCells).setCellValue(columnName);
		
		row = s.getRow(1);
		physicalNumberOfCells = row.getPhysicalNumberOfCells();
		row.createCell(physicalNumberOfCells).setCellValue(str);
		
		FileOutputStream o = new FileOutputStream(excelLocation);
		w.write(o);
		o.close();
	

	}
	
	public static WebElement findElementById(WebDriver driver, String id)
	{
	  WebElement webElement = driver.findElement(By.id(id));
	  return webElement;
	}
	
	public static WebElement findElementByXPath(WebDriver driver, String xpath)
	{
	  WebElement webElement = driver.findElement(By.xpath(xpath));
	  return webElement;
	}
	
	public static void maximizeWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
	}
	
	public static void selectByValue(WebElement wb,String str) {
		// TODO Auto-generated method stub
		Select s = new Select(wb);
		s.selectByValue(str);
	}
	
	public static void sendText(WebElement element, String s)
	{
		element.sendKeys(s);
	}
	
}
