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

public class Page_SF_Lead extends Page_SF {

	public Page_SF_Lead() {
		super();
	}
	
	public void goToLeadPage(){
		goToUrl(LINK+"/lightning/o/Lead/list?filterName=Recent");		
	}
	
}
