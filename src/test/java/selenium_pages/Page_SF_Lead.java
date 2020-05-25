package selenium_pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_SF_Lead extends Page_SF_Login {

	private String FLASTNAME = "//div/label/span[text()='Last Name']/../following::input[1]";
	private String FEMAIL = "//div/label/span[text()='Email']/../following::input[1]";
	private String FCOMPANY = "//div/label/span[text()='Company']/../following::input[1]";
	private String FLEADSOURCE = "//span[text()='Lead Source']/../following::a[1]";
	private String FRATING = "//span[text()='Rating']/../following::a[1]";
	private String FDESCRIPTION ="//div/label/span[text()='Description']/../following::textarea[1]";
	private String FLEADSTATUS = "//div[@role='listitem']/div/div/div/span/span[text()='Lead Status']/../following::a[1]";
	private String BSAVE = "//button[@title='Save']";
	private String tempLastName;
	
	public Page_SF_Lead() {
		super();
	}
	
	public void goToLeadPage(){
		goToUrl(LINK+"/lightning/o/Lead/list?filterName=Recent");		
	}
	
	public void insertNewLead(String FirstName, String LastName,String Email,String Phone, String Company,String LeadSource,String LeadStatus ,String Rating, String Description) {
		tempLastName = FirstName+" "+LastName;
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BNEW))).click();
		//getElementByXpath(BNEW).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FFNAME)));
		getElementByXpath(FFNAME).sendKeys(FirstName);
		getElementByXpath(FLASTNAME).sendKeys(LastName);
		getElementByXpath(FCOMPANY).sendKeys(Company);
		getElementByXpath(FEMAIL).sendKeys(Email);
		getElementByXpath(FPHONE).sendKeys(Phone);
		getElementByXpath(FLEADSOURCE).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='"+LeadSource+"']")));
		getElementByXpath("//a[@title='"+LeadSource+"']").click();
		getElementByXpath(FLEADSTATUS).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='"+LeadStatus+"']")));
		getElementByXpath("//a[@title='"+LeadStatus+"']").click();
		getElementByXpath(FRATING).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='"+Rating+"']")));
		getElementByXpath("//a[@title='"+Rating+"']").click();
		getElementByXpath(FDESCRIPTION).sendKeys(Description);
		getElementByXpath(BSAVE).click();
		//Page_base.driver.findElement(By.cssSelector(".forceActionButton:nth-child(3) > .label")).click();
	}
	
	public boolean checkIfLeadCreated()  {
		if(tempLastName.isEmpty())
			Assert.fail("Wrong use of checkIfLeadCreated (Try to use first insertNewLead)");
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.titleIs( tempLastName+" | Salesforce"));
		return true;
	}
	
	public boolean checkIfLeadNotCreated() {
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.titleIs( "New Lead | Salesforce"));
		return true;
	}	
	
}
