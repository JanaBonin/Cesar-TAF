package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_pages.Page_SF;
import sendingSalesforce.SetProfileUser;

public class StepsTesting {
	public static Page_SF standard = new Page_SF();
	
	public static void main(String[] args) {
		
		SetProfileUser send = new SetProfileUser("sftestautomation2@digita.com", "Custom: Sales Profile");
		standard.openChromeWindow();
		standard.makeLoginOtherUser("Second");
		
		WebDriverWait wait = new WebDriverWait(standard.driver, 15);
		
		standard.goToTab("Opportunities");
		standard.newButton();
		
		standard.insert("Close Date", "31/05/2020", "Text");
		standard.insert("Amount", "20000", "Text");
		standard.insert("Opportunity Name", "Michele Test", "Text");
		standard.insert("Account Name", "Deloitte", "Wrapper");
		standard.insert("Stage", "Prospecting", "Combobox");
		standard.insert("Discount Percentage", "20", "Text");
		standard.insert("Type", "New Customer", "Combobox");
		
		standard.saveButton();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Cancel']")));
		standard.driver.findElement(By.xpath("//button[@title='Cancel']")).click();
		standard.closeWindow();
		
		
		standard.openChromeWindow();
		standard.makeLogin();
		
		wait = new WebDriverWait(standard.driver, 15);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-aura-class='uiButton forceHeaderButton unsNotificationsCounter']")));
		standard.jsclick(standard.driver.findElement(By.xpath("//button[@data-aura-class='uiButton forceHeaderButton unsNotificationsCounter']")));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Opportunity Name: Testing AP')]/ancestor::a")));
		standard.jsclick(standard.driver.findElement(By.xpath("//span[contains(text(), 'Opportunity Name: Michele Test')]/ancestor::a")));
		
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='slds-truncate' and text()='Approve']")));
		standard.driver.findElement(By.xpath("//div[@class='slds-truncate' and text()='Approve']")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Approve']/ancestor::button")));
		standard.driver.findElement(By.xpath("//span[text()='Approve']/ancestor::button")).click();
		
		WebElement element = standard.search("Michele Test", "Opportunities");
		element.click();
		standard.goToDetails();
		String status = standard.getTextForm("Approval Status");
		if(!status.equals("Approved")) {
			Assert.fail();
		}
	}

}
