package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Search {
	
	public AppiumDriver driver;
	
	//second section
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public WebElement Search_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement EnterSearch_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Invalid_msg;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement Valid_msg;
	
	
	//first section
	public PageObject_Search(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	//third section
	
	public void ClickSearchtxtbox()
	{
		Search_txtbox.click();
	}
	

	public void Enter_Search(String Value)
	{
		EnterSearch_txtbox.sendKeys(Value +"\n");
	}
	
	public String getInvalidsearchresult()
	{
		return Invalid_msg.getText();
		
	}
	
	
	public String getValidsearchresult()
	{
		return Valid_msg.getText();
		
	}
	
}
