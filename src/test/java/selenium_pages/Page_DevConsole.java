package selenium_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.List;
import java.util.StringTokenizer;

public class Page_DevConsole extends Page_base {
	
	public void goToConsole() {
		driver.get("https://eu31.salesforce.com/_ui/common/apex/debug/ApexCSIPage");
	}
	
	public void makeQuery(String select, String field, String condition) {
		String query = "Select "+select+" From "+ field;
		if(!condition.isBlank()) {
			query = query+" Where "+condition;
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickButton("tab-1173-btnEl"); 		//id button "Query Editor"
		WebElement textBoxQuery = driver.findElement(By.id("queryEditorText-inputEl"));
		textBoxQuery.sendKeys(query);
		clickButton("queryExecuteButton-btnEl");
		try {
			Thread.sleep(4000);
			WebElement tableResults = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div/div[3]/div//table")); //dobbiamo usare Xpath completo 
			String tableElements = tableResults.getText();
			StringTokenizer st = new StringTokenizer(tableElements,"\n");
			while (st.hasMoreTokens()) {
				
				System.out.println(st.nextToken());
		     }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
