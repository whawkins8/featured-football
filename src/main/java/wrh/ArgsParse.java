package wrh;

import java.io.*;
import java.util.Scanner;

public class ArgsParse {
	private static Scanner in = new Scanner(System.in);
	private ArgsInfo info;
	
	public void makeConfig(File configFile) throws IOException {
		System.out.println("Welcome! We need to configure your email settings.");
		System.out.println("Note: your email settings will be stored in plain text. We "
				+ "--strongly-- recommend that your from email is used only for this purpose, and "
				+ "choose a good password that is ---only--- used for this purpose.");
		System.out.println("What address would you like to send the email to?");
		String to = in.nextLine();
		System.out.println("");
		
		System.out.println("What address are you sending email from?");
		String from = in.nextLine();
		System.out.println("");
		
		System.out.println("What is the password for the from email? --please read the above note.");
		String pw = in.nextLine();
		System.out.println("");
		
		System.out.println("What is your smtp server (for gmx, this is mail.gmx.com)");
		String server = in.nextLine();
		System.out.println("");
		
		System.out.println("Lastly, what port should we use to send mail? (for gmx, enter 25)");
		int port = in.nextInt();
		
		info = new ArgsInfo(to, from, server, pw, port);
		
		/* try to write to file. */
		info.toJson(configFile);
		System.out.println("Thanks. Please run again for normal usage.");
	}
	
	public void getSettingsFromJson(File jsonFile) throws Exception {
		this.info = ArgsInfo.fromJson(jsonFile);
	}
	
	public ArgsInfo getInfo() {
		return this.info;
	}
}
