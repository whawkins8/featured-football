package wrh;

import java.util.ArrayList;

import javax.mail.MessagingException;

import java.io.*;

public class App {
	public static void main(String[] args) {
		/* 
		 * parse cl args, eg to email, from email, authentication...
		 */
		File configFile = new File("./config.json");
		ArgsParse ap = new ArgsParse();
		
		if (configFile.exists() && args.length == 0) {
			try{
				ap.getSettingsFromJson(configFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (!configFile.exists() || args[0].equals("config")) {
			try {
				ap.makeConfig(configFile);
				return;
			} catch (IOException e) {
				System.out.println("Could not create config file.");
				e.printStackTrace();
			}
		} else if (args[0].equals("help")) {
			System.out.println("Usage: config -- configure your mail settings.");
			System.out.println("no args -- send message.");
			return;
		} else {
			System.out.println("Did not understand -- run with argument \"help\" for more info.");
		}
		
		/* 
		 * run an API request, get match information from FS.
		 */
		MatchRequester mr = new MatchRequester();
		String response;
		try {
			response = mr.getResponse();
		} catch (Exception e) {
			/* if there is some error, terminate the program. */
			e.printStackTrace();
			System.out.println("unable to connect to FS server.");
			return;
		}
				
		/* 
		 * parse the api response into email format. 
		 */
		JsonParser jp = new JsonParser(response);
		
		/* if we have 0 matches today, terminate the program. */
		if (jp.numMatches() == 0) {
			return;
		}
		/* matches -- our actual match data. */
		ArrayList<Match> matches = jp.getMatches();
		
		/* 
		 * send the email 
		 */
		SendMail sm = new SendMail(ap.getInfo());
		try{
			sm.sendMessage(matches);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Could not send message.");
		}
		
	}
}
    
