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
import org.openqa.selenium.TimeoutException;
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
	
	
	public boolean checkLogin(){
		if(driver.getTitle().equals("Accedi | Salesforce")) {
			return false;
		}
        WebDriverWait wait = new WebDriverWait(driver,30);
        try {
        	wait.until(ExpectedConditions.titleIs("Home | Salesforce"));
        }catch (TimeoutException e) {
        	return false;
        }
		return true;
	}
	
	public boolean makeLogin() {
		goToUrl("https://login.salesforce.com");
		insertText(USERNAME,"username");
		insertText(PASSWORD,"password");
		clickButton("Login");
		if(checkLogin())
			return true;
		else
			return false;
	}
	
	public boolean makeLoginOtherUser(String name) {
		goToUrl("https://login.salesforce.com");
		File configFile = new File("src/configuration.properties");
		FileReader reader;
		String tUsername = new String();
		String tPassword = new String();
		try {
			reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			tUsername = props.getProperty(name+"_username");
			tPassword = props.getProperty(name+"_password");			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		insertText(tUsername,"username");
		insertText(tPassword,"password");
		clickButton("Login");
		if(checkLogin())
			return true;
		else
			return false;
	}

	public void goToTab(String tab) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='slds-truncate' and text()='"+tab+"']")));
		WebElement tabElement = getElementByXpath("//span[@class='slds-truncate' and text()='"+tab+"']");
		jsclick(tabElement);
	}

	public void selectRecord(String object) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='"+object+"']")));
		getElementByXpath("//a[@title='"+object+"']").click();
	}
	
	public void goToDetails() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@title='Details']//a[@data-label='Details']")));
		getElementByXpath("//li[@title='Details']//a[@data-label='Details']").click();
	}
	
	public boolean findLabel(String label){
		WebDriverWait wait = new WebDriverWait(driver,10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']")));
		}
		catch(TimeoutException ex) {
			Assert.fail("No such label found");
		}
		
		WebElement element = getElementByXpath("//span[@class='test-id__field-label' and text()='"+label+"']");
		String field = element.getText();
		
		if(field.equals(label)) {
			return true;
		}else{
			return false;}		
	}
	
	public String getTextForm(String label) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-text[1]")));
		WebElement element = getElementByXpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-text[1]");
		String field = element.getText();
		return field;
	}
	
	public String getNameForm(String label) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-name[1]")));
		WebElement element = getElementByXpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-name[1]");
		String field = element.getText();
		return field;
	}
	
	public String getClickableTextForm(String label) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::a[1]")));
		WebElement element = getElementByXpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::a[1]");
		String field = element.getText();
		
		return field;
	}
	
	public String getPhoneForm(String label) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-phone[1]")));
		WebElement element = getElementByXpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::lightning-formatted-phone[1]");
		String field = element.getText();
		
		return field;
	}
	
	public String getEmailForm(String label) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::a[1]")));
		WebElement element = getElementByXpath("//span[@class='test-id__field-label' and text()='"+label+"']/../following::a[1]");
		String field = element.getText();
		
		return field;
	}
	
	public void newButton() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='slds-truncate' and text()='New']")));
		getElementByXpath("//div[@class='slds-truncate' and text()='New']").click();
	}
	
	public void setValueCombobox (String label, String value) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-aura-class='uiPicklistLabel']//span[text()='"+label+"']/../following::a[1]")));
			getElementByXpath("//span[@data-aura-class='uiPicklistLabel']//span[text()='"+label+"']/../following::a[1]").click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@role='menuitemradio' and @title='"+value+"']")));
			getElementByXpath("//a[@role='menuitemradio' and @title='"+value+"']").click();
		}
		catch(TimeoutException ex) {
			System.out.println("No TextForm with this label found");
		}
	}
	
	public void writeTextForm(String label, String value) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@data-aura-class='uiLabel']//span[text()='"+label+"']/../following::input[1]")));
			WebElement element = getElementByXpath("//label[@data-aura-class='uiLabel']//span[text()='"+label+"']/../following::input[1]");
			element.clear();
			element.sendKeys(value);
		}
		catch(TimeoutException ex) {
			System.out.println("No TextForm with this label found");
		}
	}
	
	public void writeTextArea(String label, String value) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@data-aura-class='uiLabel']//span[text()='"+label+"']/../following::textarea[1]")));
			WebElement element = getElementByXpath("//label[@data-aura-class='uiLabel']//span[text()='"+label+"']/../following::textarea[1]");
			element.clear();
			element.sendKeys(value);
		}
		catch(TimeoutException ex) {
			System.out.println("No TextArea with this label found");
		}
		
	}
	
	public void saveButton() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Save']")));
		getElementByXpath("//button[@title='Save']").click();
	}
	
	public WebElement search(String text,String field) {
		goToUrl(LINK+"/lightning/page/home");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Salesforce']")));
			
		try {
			Thread.sleep(2500);
			WebElement fieldBox = getElementByXpath("//input[@id='input-5']");
			fieldBox.sendKeys(Keys.BACK_SPACE+""+Keys.BACK_SPACE+""+Keys.BACK_SPACE+""+field);
			Thread.sleep(500);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-base-combobox-formatted-text[@title='"+field+"']")));
			jsclick(getElementByXpath("//lightning-base-combobox-formatted-text[@title='"+field+"']"));
		
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains (@title, 'Search')]")));
			WebElement inputBox = getElementByXpath("//input[contains (@title, 'Search')]");
				
			Thread.sleep(1500);
			inputBox.click();
			inputBox.sendKeys(text);
			inputBox.sendKeys(Keys.ENTER);
		
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		wait.until(ExpectedConditions.titleIs(text+" - Search | Salesforce"));
		
			//-----------------------------------------------------------------------------------------------------------
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
		getElementByXpath("//div[@class='windowViewMode-normal oneContent active lafPageHost']//slot[@slot='header']//li[@data-aura-class='oneActionsDropDown']//lightning-icon").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Edit']")));
		getElementByXpath("//a[@title='Edit']").click();
		
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
					insert(row.get("Field"), row.get("Value"), row.get("Type"));
				}
				saveButton();
		}else
			Assert.fail("Can't find the record to update");
		
	}
	
	public void goToPage(String object) {
		goToUrl(LINK+"/lightning/o/"+object+"/list?filterName=Recent");	
	}
	
	public void newRecord(String object,List<Map<String,String>> value) {
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

	public boolean checkIfRecordCreated() throws TimeoutException {
		WebDriverWait wait = new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.urlContains("/view"));
		}
		catch(TimeoutException ex) {
			return false;
		}
		return true;
	}
	
}

