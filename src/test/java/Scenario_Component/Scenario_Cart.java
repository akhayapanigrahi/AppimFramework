package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Cart;
import PageObject_Component.PageObject_Search;

public class Scenario_Cart extends Base_Class {
	
	public static Logger log=Logger.getLogger(Scenario_Cart.class);
	
	@Test(dataProvider="dp_AddCart",dataProviderClass=Dataprovider_Component.DataProvider_Cart.class)
	public void testAddCart(Map Cart) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Cart.get("TC_ID").toString();
		String Order_Set = Cart.get("Order_Set").toString();
		String Search_Item = Cart.get("Search_Item").toString();
		String Exp_Result = Cart.get("Exp_Result").toString();
		
		Start_Server();
		log.info("Executing the Testcase " +TC_ID +" Order set is "+Order_Set);
		Init_App();
		
		PageObject_Search c1= new PageObject_Search(driver);
		Explicit_wait(c1.Search_txtbox, 20);
		c1.ClickSearchtxtbox();
		
		Explicit_wait(c1.EnterSearch_txtbox, 20);
		c1.Enter_Search(Search_Item);
		
		PageObject_Cart c2=new PageObject_Cart(driver);
		c2.Additem();
		String Actual_Result = c2.getAddcartmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is "+Actual_Result + " Expected Result is " +Exp_Result);
		}else
		{
			log.info("Failed as Actual Result is "+Actual_Result + " Expected Result is " +Exp_Result);
			Capture_screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is "+Actual_Result + " Expected Result is " +Exp_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
		
		
	}
	
	@Test(dataProvider="dp_DeleteCart",dataProviderClass=Dataprovider_Component.DataProvider_Cart.class)
	public void testDeleteCart(Map Cart) throws IOException, InterruptedException
	{
	
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Cart.get("TC_ID").toString();
		String Order_Set = Cart.get("Order_Set").toString();
		String Search_Item = Cart.get("Search_Item").toString();
		String Exp_Result = Cart.get("Exp_Result").toString();
		
		Start_Server();
		log.info("Executing the Testcase " +TC_ID +" Order set is "+Order_Set);
		Init_App();
		
		PageObject_Search c1= new PageObject_Search(driver);
		Explicit_wait(c1.Search_txtbox, 20);
		c1.ClickSearchtxtbox();
		
		Explicit_wait(c1.EnterSearch_txtbox, 20);
		c1.Enter_Search(Search_Item);
		
		PageObject_Cart c2=new PageObject_Cart(driver);
		c2.Additem();
		String Actual_Result = c2.DeletCartmsg();
		
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is "+Actual_Result + " Expected Result is " +Exp_Result);
		}else
		{
			log.info("Failed as Actual Result is "+Actual_Result + " Expected Result is " +Exp_Result);
			Capture_screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is "+Actual_Result + " Expected Result is " +Exp_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
	}
}
