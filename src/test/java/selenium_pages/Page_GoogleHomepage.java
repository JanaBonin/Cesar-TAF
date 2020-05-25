package selenium_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Page_GoogleHomepage extends Page_base {
	
	public void lauchChromeBrowser() {
		this.openChromeWindow();
	}
	
	public void launchFirefoxBrowser() {
		this.openFirefoxWindow();
	}
	public void openGoogleURL() {
		driver.get("https://www.google.it");
	}
	public void checkSearchBoxIsDisplayed() {
		if(driver.findElement(By.name("q")).isDisplayed()) {
			System.out.println("Searchbox is displayed");
		}else {
			System.out.println("Searchbox is NOT displayed");
		}
	}
	public void checkGoogleSearchButtonIsDisplayed() {
		if(driver.findElement(By.name("btnK")).isDisplayed()) {
			System.out.println("Google Search button is displayed");
		}else {
			System.out.println("Google Search button is NOT displayed");
		}
	}
	public void checkImFeelingLuckyButtonIsDisplayed() {
		if(driver.findElement(By.name("btnI")).isDisplayed()) {
			System.out.println("I'm Feeling button is displayed");
		}else {
			System.out.println("I'm Feeling button is NOT displayed");
		}
	}
	
	public void searchElementGoogleHomepage(String Keyword) {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(Keyword);
		searchBox.submit();
	}
}
