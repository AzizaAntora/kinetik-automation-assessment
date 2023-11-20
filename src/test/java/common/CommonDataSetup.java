package common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonDataSetup {
	
	protected WebDriver driver;
	protected ConfigFileReader configFileReader;
	
	@BeforeSuite
	public void dataSetup() 
	{
		System.out.println("Initiating Test Suit");
		configFileReader= new ConfigFileReader();
		String url = configFileReader.getApplicationUrl();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}
	

	@AfterSuite
	public void dataTeardown() 
	{
		System.out.println("Closing Test Suit");
		driver.close();
	}
}
