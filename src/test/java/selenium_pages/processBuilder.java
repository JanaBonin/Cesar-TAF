package selenium_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class processBuilder{
	public static void main(String[] args) {
			System.setProperty("webdriver.gecko.driver","geckodriver-v0.26.0-win64/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor executor = ((JavascriptExecutor)driver);
			WebDriverWait wait = new WebDriverWait(driver,30);
			driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();
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
			driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Leads']")).click();
			
			//sono sulla pagina leads
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Vincenzo Lucignano']")));
			driver.findElement(By.xpath("//a[@title='Vincenzo Lucignano']")).click();
			
			//sono sulla pagina del lead
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-label='Details']")));
			driver.findElement(By.xpath("//a[@data-label='Details']")).click();
			
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
			driver.findElement(By.xpath("//button[@title='Edit Company']")).click();
			
			//sono nella pagina di edit del lead
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='slds-form-element__label' and text()='Rating']/../div/lightning-base-combobox/div/div/input")));
			executor.executeScript("window.scrollBy(0,200)");
			driver.findElement(By.xpath("//label[@class='slds-form-element__label' and text()='Rating']/../div/lightning-base-combobox/div/div")).click();
			
			//clicco sul bottone di rating
			
			driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Hot']")).click();
			
			//ho cliccato sul bottone di save
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Save']")));
			driver.findElement(By.xpath("//button[@title='Save']")).click();
			Page_SF_Login temp = new Page_SF_Login();
			temp.driver = driver;
			temp.search(companyname, "Accounts");
		}
}
