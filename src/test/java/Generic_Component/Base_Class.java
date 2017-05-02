package Generic_Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {
	
	public static Process process;
	public static AppiumDriver driver;
	static String Appium_Node_Path = "C:\\Program Files (x86)\\Appium\\node.exe";
	static String Appium_JS_Path = "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	static AppiumDriverLocalService service;
	static String service_url;

	
	public static void Start_Server() throws IOException, InterruptedException
	{
		/*String Start_Server="D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!=null)
		{
			System.out.println("Started the appium Server");
		}
		else
		{
			System.out.println("NOT able to Start the Server");
		}
		
		Thread.sleep(12000);*/
		
		
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingPort(4723)
						.usingDriverExecutable(new File(Appium_Node_Path))
						.withAppiumJS(new File(Appium_JS_Path)));
		service.start();
		Thread.sleep(25000);
		service_url = service.getUrl().toString();
		
				
	}
	
	public static void Init_App() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","1c47b811");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
		
		//app details
		capabilities.setCapability("appPackage","com.bigbasket.mobileapp");
		capabilities.setCapability("appActivity","com.bigbasket.mobileapp.activity.SplashActivity");
		
		
		//Appium server details
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
	 
		
		Thread.sleep(10000);
		
	}
	
	
	public static void Explicit_wait(WebElement ele,long T1)
	{
		WebDriverWait wait= new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		
	}
	
	
	public static void Capture_screenshot1(String TC_ID, String Order_Set) throws IOException
	{
		
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		
		String str=df.format(date)+".png";
		//File file= new File(df.format(date)+".png");
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshotAs, new File("D:\\March4_BB_project\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+str));
		
		
	}
	
	
	public static void Stop_Server() throws InterruptedException
	{
						
		/*if(process!=null)
		{
			
			process.destroy();
			Thread.sleep(8000);
			System.out.println("Stoppped the Server");
			
		}*/
		service.stop();
	}

}
