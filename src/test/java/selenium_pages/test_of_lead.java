package selenium_pages;

import org.openqa.selenium.WebElement;

public class test_of_lead {
	public static void main(String[] args) {
		Page_SF_Lead leadPage = new Page_SF_Lead();
		leadPage.openFirefoxWindow();
		leadPage.makeLogin();
		//leadPage.goToLeadPage();
		//leadPage.search("CanarinoStudio", "Lead ", "Leads");
		
		/*leadPage.insertNewLead("Domenico","Esposito","desposito@deloitte.it","+393348494752","Deloitte","Web","Working - Contacted","Cold","Descrizione");
		if(leadPage.checkIfLeadCreated())
			System.out.println("Inserimento ok");
		else
			System.out.println("Inserimento non ok");
		//leadPage.closeWindow();*/
		WebElement result = leadPage.search("Ciro Tesposito","Contacts"); 
		
		if(result != null){
			System.out.println("Elemento trovato");
			result.click();
		}else
			System.out.println("Elemento non trovato");
	}
}
	