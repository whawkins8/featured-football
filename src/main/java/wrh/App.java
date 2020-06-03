package wrh;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		
		/* 
		 * parse cl args, eg to email, from email, authentication...
		 */
		
		
		/* 
		 * run an api request, get match information from FS.
		 */
		MatchRequester mr = new MatchRequester();
		String response;
		try {
			response = mr.getResponse();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unable to connect to server.");
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
		ArrayList<Match> matches = jp.getMatches();
		
		/* 
		 * send the email 
		 */
		
		
	}
}
    
