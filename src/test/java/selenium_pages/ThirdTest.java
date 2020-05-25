		package selenium_pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThirdTest {

public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", 
			"chromedriver_win32/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	System.out.println("il titolo della pagina è: "+driver.getTitle());
	driver.findElement(By.id("username")).sendKeys("sfdevopsrpaframework@digita.com");
	driver.findElement(By.id("password")).sendKeys("sfdevopsezn88");
	driver.findElement(By.id("Login")).click();
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.titleIs("Home | Salesforce"));
	
	//login effettuato
	
	driver.get("https://eu31.lightning.force.com/lightning/page/home");
	wait.until(ExpectedConditions.titleIs("Home | Salesforce"));
	
	//sono sulla pagina service

	WebElement inputBox = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
	WebElement categoryHome = driver.findElement(By.xpath("//input[@id='input-5']"));
	categoryHome.click();
	driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='FILTER:Lead:Leads']")).click();
	inputBox.click();
	inputBox.clear();
	inputBox.sendKeys("Ciro");
	//inputBox.click();
	inputBox.sendKeys(Keys.RETURN);
	
	//invia ricerca
	
	wait.until(ExpectedConditions.titleIs("Ciro - Search | Salesforce"));
	System.out.println(driver.getTitle());
	
	//trova elemento
	
	try {
		Thread.sleep(3000);
		WebElement lead = driver.findElement(By.linkText("Ciro"));
		System.out.println(lead.getText());
		if(!lead.getText().equalsIgnoreCase("Ciro")) {
			Assert.fail();
		}
		
		//trova numero di telefono
		//Thread.sleep(3000);
		//driver.findElement(By.linkText("+393348494753")).click();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//tab lead = xpath=//one-app-nav-bar-item-root[2]/a/span
	//bottone new = xpath=//li/a/div
	//bottone phone = xpath=//div[2]/div/div/div/input
	//last name = xpath=//div[3]/input
	//company = xpath=//div[3]/div/div/div/div/input
	//bottone save = xpath=//div[2]/button[3]/span
	}
}