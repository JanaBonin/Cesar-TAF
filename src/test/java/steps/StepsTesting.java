package steps;

import org.openqa.selenium.By;
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
		standard.insert("Opportunity Name", "AP testing", "Text");
		standard.insert("Account Name", "Deloitte", "Wrapper");
		standard.insert("Discount Percentage", "20", "Text");
		standard.insert("Stage", "Prospecting", "Combobox");
		standard.insert("Type", "New Customer", "Combobox");
		
		standard.saveButton();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Cancel']")));
		standard.driver.findElement(By.xpath("//button[@title='Cancel']")).click();
		
		standard.openChromeWindow();
		standard.makeLogin();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-aura-class='uiButton forceHeaderButton unsNotificationsCounter']")));
		standard.jsclick(standard.driver.findElement(By.xpath("//button[@data-aura-class='uiButton forceHeaderButton unsNotificationsCounter']")));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Opportunity Name: AP testing')]/ancestor::a")));
		standard.jsclick(standard.driver.findElement(By.xpath("//span[contains(text(), 'Opportunity Name: AP testing')]/ancestor::a")));
		
	}

}
