package wrh;

import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;


public class MatchRequester {
	private FSURLBuilder urlBuilder;
	
	public MatchRequester() {
		/* first, build the request url */
		urlBuilder = new FSURLBuilder();
	}
	
	private String get(String uri) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(uri))
				.build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}

	public String getResponse() throws Exception {
		return get(urlBuilder.getURL());
	}
}
