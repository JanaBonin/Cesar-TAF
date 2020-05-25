package selenium_pages;

import java.util.List;
import java.util.Map;

public class testCode {
	public static void main(String[] Args) {
		Page_SF_Login standard = new Page_SF_Login();
		standard.openChromeWindow();
		standard.makeLogin();
		//standard.newObject("Work Type");
	}
}
