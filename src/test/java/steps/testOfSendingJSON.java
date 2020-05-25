package steps;

import sendingSalesforce.SendingJSONResult;

public class testOfSendingJSON {
	public static void main(String[] args) {
		SendingJSONResult send = new SendingJSONResult();
		send.sendJSONFile("./target/cucumber.json");
	}
}
