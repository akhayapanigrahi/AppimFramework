package Scenario_Component;

import java.io.IOException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	public static Logger log=Logger.getLogger(Scenario_Search.class);
	
	
	@Test(dataProvider="dp_Invalidsearch",dataProviderClass=Dataprovider_Component.Dataprovider_Search.class,groups={"smoke"})
	public void testInvalidSearch(Map Search) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Search.get("TC_ID").toString();
		String Order_Set = Search.get("Order_Set").toString();
		String Search_Item = Search.get("Search_Item").toString();
		String Exp_Result = Search.get("Exp_Result").toString();
		
		Start_Server();
		
		log.info("Executing the Testcase  " +TC_ID+ " Order set is  "+Order_Set);
		
		Init_App();
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		
		Explicit_wait(BS_Pob.Search_txtbox,25);
		BS_Pob.ClickSearchtxtbox();		
		
		Explicit_wait(BS_Pob.EnterSearch_txtbox,25);
		BS_Pob.Enter_Search(Search_Item);
		
		Explicit_wait(BS_Pob.Invalid_msg,25);
		String Actual_Result = BS_Pob.getInvalidsearchresult();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual msg is " +Actual_Result + " Expected msg is "+Exp_Result);
			
		}
		else
		{
			log.info("Failed as Actual msg is " +Actual_Result + " Expected msg is "+Exp_Result);
			Capture_screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual msg is " +Actual_Result + " Expected msg is "+Exp_Result);
		}
		
				
		Stop_Server();
		sAssert.assertAll();
		
		
	}
	
		
	
	@Test(dataProvider="dp_ValidSearch",dataProviderClass=Dataprovider_Component.Dataprovider_Search.class,groups={"regression"})
	public void testValidSearch(Map Search) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Search.get("TC_ID").toString();
		String Order_Set = Search.get("Order_Set").toString();
		String Search_Item = Search.get("Search_Item").toString();
		String Exp_Result = Search.get("Exp_Result").toString().replace(".0", "");
		
		Start_Server();
		
		log.info("Executing the Testcase  " +TC_ID+ " Order set is  "+Order_Set);
		
		Init_App();
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		
		Explicit_wait(BS_Pob.Search_txtbox,25);
		BS_Pob.ClickSearchtxtbox();		
		
		Explicit_wait(BS_Pob.EnterSearch_txtbox,25);
		BS_Pob.Enter_Search(Search_Item);
		
		Explicit_wait(BS_Pob.Valid_msg,25);
		String Result = BS_Pob.getValidsearchresult();
		
		String Actual_Result = Result.replace(" products", "");
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual msg is " +Actual_Result + " Expected msg is "+Exp_Result);
			
		}
		else
		{
			log.info("Failed as Actual msg is " +Actual_Result + " Expected msg is "+Exp_Result);
			Capture_screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual msg is " +Actual_Result + " Expected msg is "+Exp_Result);
		}
		
				
		Stop_Server();
		sAssert.assertAll();
		
		
		
		
		
		
	}

}
