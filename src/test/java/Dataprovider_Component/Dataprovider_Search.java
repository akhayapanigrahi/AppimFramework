package Dataprovider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class Dataprovider_Search {
	
	@DataProvider(name="dp_Invalidsearch")
	public static Iterator<Object[]> getInvalidsearchdata() throws IOException
	{
		
		List<Object[]> Obj = Loaddata("InvalidSearch");
		return Obj.iterator();
		
	}
	
	@DataProvider(name="dp_ValidSearch")
	public static Iterator<Object[]> getValidsearchdata() throws IOException
	{
		
		List<Object[]> Obj = Loaddata("ValidSearch");
		return Obj.iterator();
		
	} 
	
	
	public static List<Object[]> Loaddata(String scriptname) throws IOException 
	{
		ExcelReadWrite xl= new ExcelReadWrite("F:\\Akshaya\\Appium\\March4_BB_project\\TestData\\TestData.xls");
		
		HSSFSheet Scenario_Search = xl.Setsheet("Scenario_Search");
		int RowCount = xl.getrowcount(Scenario_Search);		
		int Colcount = xl.getcolcount(Scenario_Search, 0);
		
		List<Object[]> list_search= new ArrayList<Object[]>();
		
		for(int i=1;i<=RowCount;i++)
		{
			String Execute_Flag = xl.Readvalue(Scenario_Search, i, "Execute_Flag");
			String Script_name = xl.Readvalue(Scenario_Search, i, "Script_name");
			
			if((Execute_Flag.equals("Y")) &&(Script_name.equals(scriptname)))
			{
				Map<String,String> dMap= new HashMap<String,String>();
				
				for(int j=0;j<=Colcount;j++)
				{
					
					String Skey = xl.Readvalue(Scenario_Search, 0, j);
					String Value = xl.Readvalue(Scenario_Search, i, j);
					
					dMap.put(Skey, Value);
					
					
				}
				
				Object[] x= new Object[1];
				x[0]=dMap;
				list_search.add(x);
				
				
				
			}//end of if
			
			
			
		}//end of for
		
		return list_search;
		
	}
	

}
