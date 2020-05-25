package selenium_pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Page_base {
	
	public static WebDriver driver;	
	
	public void openChromeWindow() {
		System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		Map prefs = new HashMap();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	}
	public void openFirefoxWindow() {
		System.setProperty("webdriver.gecko.driver", "geckodriver-v0.26.0-win64/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
	}

	public void goToUrl(String Url) {
		driver.get(Url);
	}
	
	public WebElement getElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	
	public WebElement getElementByXpath(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		return element;
	}
	
	public void insertText(String testo, String idElement) {
		WebElement field= getElementById(idElement);
		field.sendKeys(testo);
	}
	
	public void jsclick(WebElement element) {
		JavascriptExecutor executor = ((JavascriptExecutor)driver);
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void clickButton(String id) {
		WebElement field= getElementById(id);
		field.click();
	}
	
	public void closeWindow() {
		driver.close();
	}
	
	
	
}