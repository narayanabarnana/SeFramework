package factory;

import dataProvider.ConfigDataProvider;
//import dataProvider.ExcelDataConfig;
import dataProvider.ExcelDataConfig;

public class DataProviderFactory {
	
	
	public static ConfigDataProvider getConfig()
	{
		
		ConfigDataProvider config=new ConfigDataProvider();
		return config;
		
	}
	
	
	public static ExcelDataConfig getExcel()
	{
		
		ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\Nbarnana\\eclipse-workspace\\OrangeFramework\\TestData\\OrangeHRM.xlsx");
		return excel;
		
	}
	
	

}