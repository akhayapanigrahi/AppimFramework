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

public class DataProvider_Cart {
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<Object[]> getAddCartdata() throws IOException
	{
		List<Object[]> Obj = Loaddata("AddCart");
		return Obj.iterator();
	}
	
	@DataProvider(name="dp_DeleteCart")
	public static Iterator<Object[]> getDeleteCartdata() throws IOException
	{
		List<Object[]> Obj = Loaddata("DeleteCart");
		return Obj.iterator();
		
	} 
	
	
	public static List<Object[]> Loaddata(String Scriptname) throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("F:\\Akshaya\\Appium\\March4_BB_project\\TestData\\TestData.xls");
		HSSFSheet Scenario_Cart = xl.Setsheet("Scenario_Cart");
		
		int RowCount = xl.getrowcount(Scenario_Cart);
		int Colcount = xl.getcolcount(Scenario_Cart, 0);
		
		List<Object[]> arr_list= new ArrayList<Object[]>();
		
		for(int i=1;i<=RowCount;i++)
		{
			String Execute_Flag = xl.Readvalue(Scenario_Cart, i, "Execute_Flag");
			String Script_name = xl.Readvalue(Scenario_Cart, i, "Script_name");
			
			if((Execute_Flag.equals("Y"))&&(Script_name.equals(Scriptname)))
			{
				Map<String,String> dMap= new HashMap<String,String>();
				
				for(int j=0;j<=Colcount;j++)
				{
					String SKey = xl.Readvalue(Scenario_Cart, 0, j);
					String Value = xl.Readvalue(Scenario_Cart, i, j);
					
					dMap.put(SKey, Value);
				}
				
				Object[] x= new Object[1];
				x[0]=dMap;
				arr_list.add(x);
			}//end of if
			
		}//end of for
		
		return arr_list;
	}
	

}
