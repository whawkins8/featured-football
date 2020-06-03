package wrh;

public class App {
	public static void main(String[] args) {
		MatchRequester mr = new MatchRequester("20200604");
		String response;
		
		try {
			response = mr.getResponse();
		} catch (Exception e) {
			e.printStackTrace();
			response = "";
		}
		
		JsonParser json = new JsonParser(response);
		for (Match m : json.getMatches()) {
			System.out.println(m);
		}
	}
}
    
