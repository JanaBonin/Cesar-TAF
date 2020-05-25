package selenium_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPBFirefox {
public static void main(String[] args) {
		
		//System.setProperty("webdriver.gecko.driver", 
				//"geckodriver-v0.26.0-win32\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor executor = ((JavascriptExecutor)driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get("https://login.salesforce.com/");
		//driver.manage().window().maximize();
		System.out.println("il titolo della pagina è: "+driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("sfdevopsrpaframework@digita.com");
		driver.findElement(By.id("password")).sendKeys("sfdevopsezn88");
		driver.findElement(By.id("Login")).click();
        wait.until(ExpectedConditions.titleIs("Home | Salesforce"));
        
        //sono sulla home
        
        driver.get("https://eu31.lightning.force.com/lightning/page/home");
		wait.until(ExpectedConditions.titleIs("Home | Salesforce"));
		
		//sono sulla pagina service
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='slds-truncate' and text()='Leads']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='slds-truncate' and text()='Leads']")));
		WebElement leadsbutton = driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Leads']"));
		executor.executeScript("arguments[0].click();", leadsbutton);
		
		//sono sulla pagina leads
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Test 1']")));
		WebElement lead = driver.findElement(By.xpath("//a[@title='Test 1']"));
		executor.executeScript("arguments[0].click();", lead);
		
		//sono sulla pagina del lead
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-label='Details']")));
		WebElement details = driver.findElement(By.xpath("//a[@data-label='Details']"));
		executor.executeScript("arguments[0].click();", details);
		
		
		//sono in details del lead
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='Company']/../following::lightning-formatted-text[1]")));
		WebElement company = driver.findElement(By.xpath("//span[@class='test-id__field-label' and text()='Company']/../following::lightning-formatted-text[1]"));
		WebElement name = driver.findElement(By.xpath("//span[@class='test-id__field-label' and text()='Name']/../following::lightning-formatted-name[1]"));
		String companyname = (company.getText());
		String leadname = (name.getText());
		System.out.println(companyname);
		System.out.println(leadname);
		
		//prendo nome company e nome
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Edit Company']")));
		WebElement editCompany = driver.findElement(By.xpath("//button[@title='Edit Company']"));
		executor.executeScript("arguments[0].click();", editCompany);
		
		
		//sono nella pagina di edit del lead
		
		executor.executeScript("window.scrollBy(0,200)");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='slds-form-element__label' and text()='Rating']/../div/lightning-base-combobox/div/div/input")));
		
		WebElement combobox = driver.findElement(By.xpath("//label[@class='slds-form-element__label' and text()='Rating']/../div/lightning-base-combobox/div/div/input"));
		combobox.click();
		//executor.executeScript("arguments[0].open();", combobox);
		System.out.println(combobox.getText());
		//clicco sul bottone di rating
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//lightning-base-combobox-item[@data-value='Hot']")));
		executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Hot']")));
		
		//ho cliccato sul bottone di save
		/*
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Save']")));
		executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@title='Save']")));
		
		//cerco gli account
		
		executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id='input-5']")));
		executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='FILTER:Account:Accounts']")));
		WebElement inputBox = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
		inputBox.click();
		inputBox.clear();
		inputBox.sendKeys(companyname);
		inputBox.sendKeys(Keys.RETURN);
		
		//sono nella pagina degli account
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Save']")));*/
		}
}
