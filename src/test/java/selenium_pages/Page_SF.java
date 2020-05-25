package selenium_pages;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_SF extends Page_base{
	
	protected String USERNAME;
	protected String PASSWORD;
	protected String LINK;
	
	public Page_SF() {
		File configFile = new File("src/configuration.properties");
		FileReader reader;
		try {
			reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			USERNAME = props.getProperty("Username");
			PASSWORD = props.getProperty("Password");
			LINK = props.getProperty("Link");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertUser(String testo) {
		insertText(testo,"username");
	}
	
	public void insertPassword(String testo) {
		insertText(testo,"password");
	}
	
	public void clickAccess() {
		clickButton("Login");
	}	
	
	public boolean checkLogin(){
		if(driver.getTitle().equals("Accedi | Salesforce")) {
			return false;
		}
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.titleIs("Home | Salesforce"));
		return true;
	}
	
	public boolean makeLogin() {
		goToUrl("https://login.salesforce.com");
		insertUser(USERNAME);
		insertPassword(PASSWORD);
		clickAccess();
		if(checkLogin())
			return true;
		else
			return false;
	}
		

	public void goToTab(String tab) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='slds-truncate' and text()='"+tab+"']")));
		WebElement tabElement = driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='"+tab+"']"));
		jsclick(tabElement);
	}
	public void selectObject(String object) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='"+object+"']")));
		driver.findElement(By.xpath("//a[@title='"+object+"']")).click();
	}
	
	public String getTextForm(String label) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-text[1]")));
		WebElement element = driver.findElement(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-text[1]"));
		String field = element.getText();
		
		return field;
	}
	
	public String getNameForm(String label) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-name[1]")));
		WebElement element = driver.findElement(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-name[1]"));
		String field = element.getText();
		
		return field;
	}
	
	public String getClickableTextForm(String label) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::a[1]")));
		WebElement element = driver.findElement(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::a[1]"));
		String field = element.getText();
		
		return field;
	}
	
	public String getPhoneForm(String label) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-phone[1]")));
		WebElement element = driver.findElement(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-phone[1]"));
		String field = element.getText();
		
		return field;
	}
	
	public String getEmailForm(String label) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::a[1]")));
		WebElement element = driver.findElement(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::a[1]"));
		String field = element.getText();
		
		return field;
	}
	
	public void newButton() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='slds-truncate' and text()='New']")));
		driver.findElement(By.xpath("//div[@class='slds-truncate' and text()='New']")).click();
	}
	
	public void setValueCombobox (String label, String value) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-aura-class='uiPicklistLabel']//span[text()='"+label+"']/../following::a[1]")));
		driver.findElement(By.xpath("//span[@data-aura-class='uiPicklistLabel']//span[text()='"+label+"']/../following::a[1]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@role='menuitemradio' and @title='"+value+"']")));
		driver.findElement(By.xpath("//a[@role='menuitemradio' and @title='"+value+"']")).click();
	}
	
	public void writeTextForm(String label, String value) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@data-aura-class='uiLabel']//span[text()='"+label+"']/../following::input[1]")));
		WebElement element = driver.findElement(By.xpath("//label[@data-aura-class='uiLabel']//span[text()='"+label+"']/../following::input[1]"));
		element.clear();
		element.sendKeys(value);
	}
	
	public void writeTextArea(String label, String value) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@data-aura-class='uiLabel']//span[text()='"+label+"']/../following::textarea[1]")));
		WebElement element = driver.findElement(By.xpath("//label[@data-aura-class='uiLabel']//span[text()='"+label+"']/../following::textarea[1]"));
		element.clear();
		element.sendKeys(value);
		
	}
	
	public void saveButton() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Save']")));
		driver.findElement(By.xpath("//button[@title='Save']")).click();
	}
	
	public WebElement search(String text,String field) {
		goToUrl(LINK+"/lightning/page/home");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Salesforce']")));
		
		
		WebElement fieldBox = getElementByXpath("//input[@id='input-5']");
		fieldBox.sendKeys(Keys.BACK_SPACE+""+Keys.BACK_SPACE+""+Keys.BACK_SPACE+""+field);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//lightning-base-combobox-formatted-text[@title='"+field+"']")));
		jsclick(getElementByXpath("//lightning-base-combobox-formatted-text[@title='"+field+"']"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='Search "+field+"']")));
		WebElement inputBox = getElementByXpath("//input[@title='Search "+field+"']");
		inputBox.sendKeys(text);
		try {
			Thread.sleep(300);
			inputBox.sendKeys(Keys.ENTER);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.titleIs(text+" - Search | Salesforce"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+field+"']/../following::span[@class='slds-badge slds-badge_lightest']")));
		if(getElementByXpath("//span[text()='"+field+"']/../following::span[@class='slds-badge slds-badge_lightest']").getAttribute("innerHTML").equals("0"))
			return null;
		else {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[@class='slds-cell-edit cellContainer']//child::a")));
			return getElementByXpath("//th[@class='slds-cell-edit cellContainer']//child::a"); //return the first element in the table of elements
		}
	}
	
	public void editButton(){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='windowViewMode-normal oneContent active lafPageHost']//slot[@slot='header']//li[@data-aura-class='oneActionsDropDown']//lightning-icon")));
		driver.findElement(By.xpath("//div[@class='windowViewMode-normal oneContent active lafPageHost']//slot[@slot='header']//li[@data-aura-class='oneActionsDropDown']//lightning-icon")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Edit']")));
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
	}
	
	public void insert(String Field, String Value, String Type) {
		Type = Type.toLowerCase();
		switch(Type) {
			case "combobox":
				setValueCombobox(Field,Value);
				break;
			case "text":
				writeTextForm(Field,Value);
				break;
			case "textarea":
				writeTextArea(Field,Value);
				break;
		}
	}
	
	public void update(String Object, String searchText, List<Map<String, String>> value) {
		WebElement find = search(searchText,Object);
		if(find!=null) {
			find.click();
			editButton();
			for(Map<String,String> row : value) {
				insert(row.get("Field"),row.get("Value"),row.get("Type"));
			}
			saveButton();
		}
		else
			Assert.fail("Elemento per update non trovato");
	}
	
	public void goToPage(String object) {
		goToUrl(LINK+"/lightning/o/"+object+"/list?filterName=Recent");	
	}
	
	public void newObject(String object,List<Map<String,String>> value) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		if(value.isEmpty())
			Assert.fail("Value is empty");
		object = object.replaceAll(" ","");
		goToPage(object);
		wait.until(ExpectedConditions.titleContains("Recently Viewed |"));
		newButton();
		for(Map<String,String> row: value) {
			insert(row.get("Field"),row.get("Value"),row.get("Type"));
		}
	}

	
	
	
	public boolean checkIfObjectNotCreated() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.urlContains("/new"));
		return true;
	}
	
	public boolean checkIfObjectCreated() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.urlContains("/view"));
		return true;
	
	}
	
}

