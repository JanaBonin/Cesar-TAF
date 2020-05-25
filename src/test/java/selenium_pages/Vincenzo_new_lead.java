package selenium_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vincenzo_new_lead {
	
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://login.salesforce.com/");
	
	driver.findElement(By.id("username")).sendKeys("sfdevopsrpaframework@digita.com");
	driver.findElement(By.id("password")).sendKeys("sfdevopsezn88");
	
	driver.findElement(By.id("Login")).click(); 
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://eu31.lightning.force.com/lightning/page/home");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//driver.findElement(By.id("143:0;p")).sendKeys("need support");
	//driver.findElement(By.id("143:0;p")).sendKeys(Keys.ENTER);
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//driver.findElement(By.linkText("Need support")).click();
	
	driver.get("https://eu31.lightning.force.com/lightning/o/Lead/list?filterName=Recent");
	driver.findElement(By.xpath("//li/a/div")).click();
	   
	driver.findElement(By.xpath("//div[2]/div/div/div/input")).sendKeys("+393284531982");
	driver.findElement(By.xpath("//div[3]/input")).sendKeys("Vincenzo");
	driver.findElement(By.xpath("//div[3]/div/div/div/div/input")).sendKeys("Deloitte");
	  
	    
	    driver.findElement(By.xpath("//div[2]/button[3]/span")).click();

    }
}
