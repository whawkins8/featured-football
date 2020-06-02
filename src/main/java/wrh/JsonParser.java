package wrh;

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
	
}
