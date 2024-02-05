package pages;

import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Orbitz_pages {
	
	WebDriver driver;
	
	By logo=By.xpath("//*[@id=\"app-layer-base\"]/div[1]/div[1]/div[5]/header/div/a/img");
	
	By signin=By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/button");
	By createaccount=By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/div/div[1]/div/div/a[2]");
	
	By emailid=By.xpath("//*[@id=\"signupFormEmailInput\"]");	
	By fname=By.xpath("//*[@id=\"signupFormFirstNameInput\"]");
	By lname=By.xpath("//*[@id=\"signupFormLastNameInput\"]");
	By password=By.xpath("//*[@id=\"signupFormPasswordInput\"]");
	By register=By.xpath("//*[@id=\"signupFormSubmitButton\"]");
	By continu=By.xpath("//*[@id=\"app-layer-base\"]/div/div/div/a");
	By account=By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/button");
	By signout=By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/div/div[3]/a[4]");
	
	By loginsignin=By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/div/div[1]/div/div/a[1]");
	By loginemail=By.xpath("//*[@id=\"loginFormEmailInput\"]");
	By loginpswd=By.xpath("//*[@id=\"loginFormPasswordInput\"]");
	By loginbtn=By.xpath("//*[@id=\"loginFormSubmitButton\"]");
	
	By place=By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[1]/div/div/div[2]/div[1]/button");
	By goingto=By.xpath("//*[@id=\"destination_form_field\"]");
	By nextmonth=By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/div[2]/div/div/div[2]/button");
	By dates=By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/div/div/div/button");
	By months=By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/div[2]/div/div/div[3]/div/div[2]/span");
	By day=By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr[2]/td[5]/div");
	By allday=By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr/td/div/div[2]");
	By datedone=By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/footer/div/button");
	By travelers=By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[3]/div/div[1]/button");
	By child=By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[3]/div/div[2]/div/div/section/div[1]/div[2]/div[1]/div/button[2]");
	By childage=By.xpath("//*[@id=\"age-traveler_selector_children_age_selector-0-0\"]");
	By traveldone=By.xpath("//*[@id=\"traveler_selector_done_button\"]");
	By search=By.xpath("//*[@id=\"search_button\"]");
	By searchresult=By.xpath("//*[@id=\"app-layer-base\"]/div/main/div/div/div/div/div[2]/section[2]/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div/div/a");
	By save=By.xpath("//*[@id=\"app-layer-base\"]/div/main/div/div/section/div[1]/div[1]/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/div/button/svg[2]");
					    
	
	// --------------------constructor--------------------
	public Orbitz_pages(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//-------------------- title verification--------------------
	public void titleverification()
	{
		String actualtitle=driver.getTitle();
		String expecttitle="Orbitz Hotel Deals, Flights, Cheap Vacations & Rental Cars";
		if(actualtitle.equals(expecttitle))
		{
			System.out.println("Title Verified");
		}
		else
		{
			System.out.println("Title Not Verified");
		}
	}
	
	// --------------------content verification--------------------	
	public void contentverification()
	{
		String content=driver.getPageSource();
		
		if(content.contains("More travel"))
		{
			System.out.println("Content Verified");
		}
		else
		{
			System.out.println("Content Not Verified");
		}
	}
	
	//-------------------- link validation --------------------
	public void linkvalidation() throws Exception
	{
		String baseurl="https://www.orbitz.com";
		driver.get(baseurl);
		URL ob=new URL(baseurl);
		HttpURLConnection con=(HttpURLConnection)ob.openConnection();
		con.connect();
		
		if(con.getResponseCode()==200)	
		{
			System.out.println("Valid url : " +baseurl);
		}
		else
		{
			System.out.println("Invalid url : " +baseurl);
		}
	}
	
	
	//--------------------  logo is present or not --------------------
	public void logo()
	{
		WebElement logos= driver.findElement(logo);
		if(logos.isDisplayed())
		{
			System.out.println("Logo is present");
		}
		else
		{
			System.out.println("Logo is not present");
		}
	}
	
	// -------------------- screenshot --------------------
	public void screenshot() throws Exception
	{	
		System.out.println("------------- screenshot -------------");
		WebElement day=driver.findElement(logo);
		File src=day.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("./screenshot//logo2.png"));
		
		
		File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	FileHandler.copy(src1,new File("./screenshot//scnst123.png"));
		
		FileHandler.copy(src1,new File("D:\\screenshots\\orbitz.png"));
		
	}
	
	// -------------------- registration --------------------
	public void register() throws Exception
	{
		driver.findElement(signin).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(createaccount).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Thread.sleep(1000);
		
		driver.findElement(emailid).sendKeys("atharv633@gmail.com");
		driver.findElement(fname).sendKeys("revathy");
		driver.findElement(lname).sendKeys("kp");
		driver.findElement(password).sendKeys("Revathykp&27");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(register).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(continu).click();
		
		//logout
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(account).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(signout).click();
	}
	
	// -------------------- login --------------------
	public void login() throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(signin).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(loginsignin).click();
		Thread.sleep(10000);
		
		File f=new File("D:\\project_excel.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println("last row number : "+sh.getLastRowNum());
		
		for(int i=1;i<=sh.getLastRowNum()-1;i++)
		{
			String uname=sh.getRow(i).getCell(0).getStringCellValue();
			String pswd=sh.getRow(i).getCell(1).getStringCellValue();
			
			driver.findElement(loginemail).clear();
			driver.findElement(loginemail).sendKeys(uname);
			Thread.sleep(2000);
			System.out.println("email : "+uname);
			driver.findElement(loginpswd).clear();
			driver.findElement(loginpswd).sendKeys(pswd);
			Thread.sleep(2000);
			System.out.println("password : "+pswd);
			driver.findElement(loginbtn).click();
			Thread.sleep(2000);
		}		
		
	/*	driver.findElement(loginemail).sendKeys("revathykp@gmail.com");
		driver.findElement(loginpswd).sendKeys("Revathy&27");
		driver.findElement(loginbtn).click();	*/
		
		System.out.println("Login successful...");
	}
	
	
	// --------------------- booking --------------------
	public void booking() throws Exception
	{
		//Thread.sleep(7000);	
		driver.findElement(place).click();			
		driver.findElement(goingto).sendKeys("paris",Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));			
		driver.findElement(dates).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		
		while(true)
		{													
			WebElement selectedmonth=driver.findElement(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/div[2]/div/div/div[3]/div/div[2]/span"));
			String month1=selectedmonth.getText();
			System.out.println(month1);
			
			if(month1.equals("May 2024"))
			{
				System.out.println(month1);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/div[2]/div/div/div[2]/button")).click();
				//break;
			}									
		}
			
		List<WebElement>alldates=driver.findElements(allday);
		System.out.println(alldates);
		for(WebElement dateelement:alldates)
		{
			String date=dateelement.getText();
			System.out.println(date);
			if(date.equals("25"))
			{
				System.out.println(date);
				dateelement.click();
				System.out.println("--------date selected-------");
				break;
			}
			
		}
		driver.findElement(datedone).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		//travelers
		driver.findElement(travelers).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		js.executeScript("window.scrollBy(0,100)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(child).click();
		// drop down
		WebElement cage=driver.findElement(childage);
		Select ages=new Select(cage);
		ages.selectByValue("5");		
		driver.findElement(traveldone).click();
	}
	
	
	// ----------------- window handling -------------------------
	public void windowhandling() throws Exception
	{
		String parentwindow=driver.getWindowHandle();
		System.out.println("Parent window :  " + driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(search).click();	
		Thread.sleep(8000);
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		System.out.println("------------search------------");
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		driver.findElement(searchresult).click();

		//System.out.println("current window : "+ driver.getCurrentUrl());
		
		Set<String> allwindowhandles=driver.getWindowHandles();
		for(String handle:allwindowhandles)
		{
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handle);
				System.out.println("child window : "+ driver.getTitle());
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				js.executeScript("window.scrollBy(0,100)", "");
				Thread.sleep(7000);
				driver.findElement(By.xpath("//*[@id=\"navigation\"]/div[2]/div/div/div/button")).click();
				System.out.println("--------------reserved--------------");
				File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src1,new File("D:\\screenshots\\reserve.png"));
			}
			//driver.close();
			driver.switchTo().window(parentwindow);
		}	
		
	}	
}
	
