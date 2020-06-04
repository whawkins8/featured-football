package wrh;

import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArgsInfo {
	private String toEmail;
	private String fromEmail;
	private String server;
	private String pw;
	private int port;
	
	/* instantiate using members */
	public ArgsInfo(String toEmail, String fromEmail, String server, String pw, int port) {
		this.toEmail = toEmail;
		this.fromEmail = fromEmail;
		this.server = server;
		this.pw = pw;
		this.port = port;
	}
	
	public ArgsInfo() {
		
	}
	
	/*
	 * Read jsonFile, and create a new ArgsInfo with that data.
	 */
	public static ArgsInfo fromJson(File jsonFile) throws Exception {
		ObjectMapper om = new ObjectMapper();
		return om.readValue(jsonFile, ArgsInfo.class);
	}
	
	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	/*
	 * Write the class to the file jsonFile.
	 */
	public void toJson(File jsonFile) throws IOException {
		ObjectMapper om = new ObjectMapper();
		om.writeValue(jsonFile, this);
	}
}
