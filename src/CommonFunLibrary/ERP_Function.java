package CommonFunLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ERP_Function 
{
	WebDriver driver;
	String res;
	
	public String lunchApp(String url) 
	{
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		if(driver.findElement(By.id("btnsubmit")).isDisplayed())
		{
			res="Pass";
		}else{
			res= "Fail";
		}
		return res;
		
	}
	
	public String login(String uid, String pswd) throws Exception
	{
		System.out.println(uid+"  "+pswd);
		
		Thread.sleep(5000);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uid);
		Thread.sleep(5000);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pswd);
		Thread.sleep(5000);
		driver.findElement(By.id("btnsubmit")).click();
		Thread.sleep(5000);
		if(driver.findElement(By.id("logout")).isDisplayed())
		{
			res="Pass";
		}else{
			res= "Fail";
		}
		
		//driver.close();
		
		return res;
		
		
	}
	
	public String supplier(String sname,String address,String city,String country,
			String cperson,String pnumber,String mail,String mnumber,String note) throws Exception
	{
		
		driver.findElement(By.linkText("Suppliers")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		Thread.sleep(5000);
		String expdata=driver.findElement(By.name("x_Supplier_Number")).getAttribute("value");
		driver.findElement(By.name("x_Supplier_Name")).sendKeys(sname);
		driver.findElement(By.name("x_Address")).sendKeys(address);
		driver.findElement(By.name("x_City")).sendKeys(city);
		driver.findElement(By.name("x_Country")).sendKeys(country);
		driver.findElement(By.name("x_Contact_Person")).sendKeys(cperson);
		driver.findElement(By.name("x_Phone_Number")).sendKeys(pnumber);
		driver.findElement(By.name("x__Email")).sendKeys(mail);
		driver.findElement(By.name("x_Mobile_Number")).sendKeys(mnumber);
		driver.findElement(By.name("x_Notes")).sendKeys(note);
		
		driver.findElement(By.name("btnAction")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='OK!']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[text()='OK'])[6]")).click();
		Thread.sleep(5000);
		
		if(driver.findElement(By.id("psearch")).isDisplayed()){
			driver.findElement(By.id("psearch")).sendKeys(expdata);
			driver.findElement(By.id("btnsubmit")).click();
		}else{
			driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button/span")).click();
			driver.findElement(By.id("psearch")).sendKeys(expdata);
			driver.findElement(By.id("btnsubmit")).click();
		}
		
		String actdata=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
		
		
		if(expdata.equalsIgnoreCase(actdata)){
			res="Pass";
		}else{
			res="Fail";
		}
		
		return res;
	
	}
	public void closeApp() 
	{
		driver.close();
		
	}
	
}


