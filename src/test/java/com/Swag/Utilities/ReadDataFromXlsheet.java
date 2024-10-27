package com.Swag.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ReadDataFromXlsheet {
	@DataProvider(name="testdata")
	public String [][] readData() throws IOException
	{
		String path="C:\\Users\\bobbi\\KCSA3\\Testing project\\SwagLabs\\src\\test\\java\\com\\Swag\\Testdata\\sitedata.xlsx";
		int nfRows=XLUtils.getRowCount(path,"sheet1");
		int nfCols=XLUtils.getCellCount(path, "sheet1", 0);
		String a[][]= new String [nfRows][nfCols];
		for(int i=1; i<nfRows; i++)
		{
			for(int j=0; j<nfCols; j++)
			{
				a[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return a;
		
	}
	

}
