package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Orbitz_pages;


public class Orbitz_test {

	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}	
	
	@BeforeMethod
	public void urlload()
	{		
		driver.get("https://www.orbitz.com");
		driver.manage().window().maximize();		
	}
	
	@Test
	public void test() throws Exception
	{
		Orbitz_pages ob=new Orbitz_pages(driver);
		ob.titleverification();
		ob.logo();
		ob.contentverification();	
	//	ob.screenshot();
	//	ob.register();
	//	ob.login();
		ob.booking();
		ob.windowhandling();
	//	ob.linkvalidation();	
	}
}
