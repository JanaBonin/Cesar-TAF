package sendingSalesforce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class SendingJSONResult {
	
	
	private String USERNAME;
	private String PASSWORD;
	private String LOGINURL = "https://login.salesforce.com";
	private String GRANTSERVICE= "/services/oauth2/token?grant_type=password";;
	private String CLIENTID;
	private String CLIENTSECRET;
	private String API_VERSION;
	private Header oauthHeader;
	private Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");
	
	public SendingJSONResult() {
		File configFile = new File("src/configuration.properties");
		FileReader reader;
		try {
			reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			USERNAME = props.getProperty("Username");
			PASSWORD = props.getProperty("Password");
			CLIENTID = props.getProperty("ClientId");
			CLIENTSECRET = props.getProperty("ClientSecret");
			API_VERSION = "/v32.0";
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private  String readFile(String filename) {
	    String result = "";
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(filename));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        line = br.readLine();
	        
	        while (line != null) {
	        	if(line.contains("error_message")) {
	        		line = line.replaceAll("✽", "");
	        		System.out.println("Linea file che sto leggendo "+line);
	        	}
	        	sb.append(line);
	            line = br.readLine();
	        }
	        sb.deleteCharAt( sb.length() - 1 );
	        result = sb.toString();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public void sendJSONFile(String pathToJSON) {
		try {
			
			HttpClient httpclient = HttpClientBuilder.create().build();
			String loginURL = LOGINURL +
                    GRANTSERVICE +
                    "&client_id=" + CLIENTID +
                    "&client_secret=" + CLIENTSECRET +
                    "&username=" + USERNAME +
                    "&password=" + PASSWORD;
			
			// Login requests must be POSTs
	        HttpPost httpPost = new HttpPost(loginURL);
	        HttpResponse response = null;
	        response = httpclient.execute(httpPost);
			
	     // verify response is HTTP OK
	        int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != HttpStatus.SC_OK) {
	            System.out.println("Error authenticating to Force.com: "+statusCode);
	            // Error is in EntityUtils.toString(response.getEntity())
	            return;
	        }
	        String getResult = null;
	        try {
	            getResult = EntityUtils.toString(response.getEntity());
	        } catch (IOException ioException) {
	            ioException.printStackTrace();
	        }
	        JSONObject jsonObject = null;
	        String loginAccessToken = null;
	        String loginInstanceUrl = null;
	 
	        try {
	            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
	            loginAccessToken = jsonObject.getString("access_token");
	            loginInstanceUrl = jsonObject.getString("instance_url");
	        } catch (JSONException jsonException) {
	            jsonException.printStackTrace();
	        }
	 
	        oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken) ;
	        System.out.println("oauthHeader1: " + oauthHeader);
	        System.out.println("\n" + response.getStatusLine());
	        System.out.println("Successful login");
	        System.out.println("instance URL: "+loginInstanceUrl);
	        System.out.println("access token/session ID: "+loginAccessToken);
	        System.out.println("baseUri: "+ loginInstanceUrl);        

	        // A me serve un oggetto di tipo JSONObject (org.json) che vado a prendere i dati dal file json
	        String jsondata = readFile(pathToJSON);
	        System.out.println("Dati del json "+jsondata);
	        JSONObject jobj = new JSONObject(jsondata);
	        System.out.println("Dati del jobj "+jobj);
	        String uri = loginInstanceUrl + "/services/apexrest/sendReportJSON/";
	        
	        System.out.println("uri "+uri);
	        
	        httpPost = new HttpPost(uri);
            httpPost.addHeader(oauthHeader);
            httpPost.addHeader(prettyPrintHeader);
	        
	       
            
	        StringEntity body = new StringEntity(jobj.toString());
	        body.setContentType("application/json");
	        System.out.println("Stampo il body "+body);
	        httpPost.setEntity(body);
	        response = httpclient.execute(httpPost);
	        
	        
	        //Process the results
            statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != HttpStatus.SC_OK)
            	System.out.println("Error sending");
            else
            	System.out.println("Sending successfully");
            //JSONObject json = new JSONObject(response_string);
            // Store the retrieved lead id to use when we update the lead.
            
		} catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

		}	
}
