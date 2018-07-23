package org.test.DataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Greens-12\\pradeepa\\DataDrivenFramework\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");	
		driver.manage().window().maximize();
		
		File excelLocation = new File("C:\\Users\\Greens-12\\pradeepa\\DataDrivenFramework\\Excel\\FB.xlsx");
FileInputStream stream = new FileInputStream(excelLocation);
		
		Workbook wb = new XSSFWorkbook(stream);
		
		Sheet s = wb.getSheet("Sheet1");
		
		
		List <LinkedHashMap<String,String>> mapDataList = new ArrayList<LinkedHashMap<String,String>>();
		
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
		
		System.out.println(mapDataList);
		
		WebElement name = driver.findElement(By.id("email"));
		name.sendKeys("kajsdfj");
		
		driver.findElement(By.id("email")).sendKeys(mapDataList.get(0).get("name"));
		driver.findElement(By.id("pass")).sendKeys(mapDataList.get(0).get("pass"));
		
	}
}
