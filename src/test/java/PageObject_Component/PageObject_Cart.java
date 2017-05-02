package PageObject_Component;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.Base_Class;

public class PageObject_Cart extends Base_Class {
	
	//public AppiumDriver driver;
	
	//second section
	
	@FindBy(id="com.bigbasket.mobileapp:id/btnAddToBasket")
	public WebElement btn_Add;
		
	@FindBy(id="com.bigbasket.mobileapp:id/basketimageview")
	public WebElement Img_Cart;	
		
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement AddCart_msg;	
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement btn_Delete;	
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Delete_msg;	
	
	
	public PageObject_Cart(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	//3rd section is creating methods
	
	public void Additem()
	{
		Explicit_wait(btn_Add,25);
		btn_Add.click();
		Explicit_wait(Img_Cart, 25);
		Img_Cart.click();
		Explicit_wait(AddCart_msg,25);
		
	}
	
	
	public String getAddcartmsg()
	{		
		return AddCart_msg.getText();
	}
	
	public String DeletCartmsg()
	{
		btn_Delete.click();
		Explicit_wait(Delete_msg, 20);
		return Delete_msg.getText();
	}

	
	

}
