package wrh;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
	private String json;
	private ObjectMapper om;
	private JsonNode jNode;
	
	public JsonParser(String json) {
		this.json = json;
		om = new ObjectMapper();
		setJNode();
	}
	
	private void setJNode() {
		try {
			this.jNode = om.readTree(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int numMatches() {
		return jNode.get("totalCount").asInt();
	}
	
	public ArrayList<Match> getMatches(){
		ArrayList<Match> matches = new ArrayList<>(numMatches());
		Match newMatch;
		
		for (JsonNode jn : jNode.get("page")) {
			newMatch = parsePage(jn);
			matches.add(newMatch);
		}
		
		return matches;
	}
	
	private Match parsePage(JsonNode jn) {
		Match m = new Match();
		
		m.setHomeTeam(jn.get("homeTeam").get("name").asText());
		m.setAwayTeam(jn.get("awayTeam").get("name").asText());
		m.setLocalMatchTime(jn.get("date").asText());
		
		return m;
	}
	
}
