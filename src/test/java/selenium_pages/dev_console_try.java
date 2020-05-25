package selenium_pages;

import java.util.Set;

import org.openqa.selenium.Cookie;

public class dev_console_try {
	public static void main(String[] arg) {
		Page_DevConsole devCons = new Page_DevConsole();
		Page_SF_Login sfLogin = new Page_SF_Login();
		sfLogin.openChromeWindow();
		sfLogin.goToUrl("https://www.google.it");
		sfLogin.insertText("sfdevopsrpaframework@digita.com","username");
		sfLogin.insertText("sfdevopsezn88","password");
		sfLogin.clickAccess();
		/*Set<Cookie> cookies = Page_base.driver.manage().getCookies();
		System.out.println(cookies);
		sfLogin.closeWindow();
		devCons.openChromeWindow();
		for(Cookie cook : cookies) {
			System.out.println("nel for "+cook);
			Page_base.driver.manage().addCookie(cook);
			break;
		}*/
		devCons.goToConsole();
		devCons.makeQuery("id, Name", "Account","");
		
	}
}
