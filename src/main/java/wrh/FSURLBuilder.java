package wrh;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
/**
 * Class that wraps building the fox sports api url.
 * Note: the api key isn't secret, it's a default key.
 * 
 * We build the url using today's data, to get football matches
 * happening today.
 * 
 * Usage: to get the url, use getURL().
 * @author william
 *
 */
public class FSURLBuilder {
	private String url = "http://api.foxsports.com/sportsdata/v1/soccer/popular/events.json?";
	
	/* default apikey for the fox sports api. */
	private String apikey = "jE7yBJVRNAwdDesMgTzTXUUSx1It41Fq";
	
	/*
	 * Constructor to build the URL for TODAY.
	 */
	public FSURLBuilder() {
		buildURL();
	}
	
	/*
	 * Constructor to build the URL for a data passed in.
	 * date format: yyyymmdd, eg: june 1 2020 <=> 20200601.
	 */
	public FSURLBuilder(String date) {
		buildURL(date);
	}
	
	private String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	private void buildURL() {
		url = url + "date=" + getDate() + "&" + "apikey=" + apikey;
	}
	
	private void buildURL(String date) {
		url = url + "date=" + date + "&" + "apikey=" + apikey;
	}
	
	/* use to get the url, after it's built. */
	public String getURL() {
		return this.url;
	}
}
