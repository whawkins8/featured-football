package wrh;

import java.util.Properties;
import java.util.ArrayList;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	private ArgsInfo info;
	private Session session;
	private MimeMessage footballMessage;
	
	public SendMail(ArgsInfo info) {
		this.info = info;
		setSession();
	}
	
	private void setSession() {
	    Properties props = new Properties();

	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.host", info.getServer());
	    props.put("mail.smtp.port", Integer.toString(info.getPort()));
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.user", info.getFromEmail());
	    props.put("mail.smtp.password", info.getPw());
	    props.put("mail.smtp.starttls.enable", "true");
	    
	    this.session = Session.getInstance(props, new Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    		return new PasswordAuthentication(info.getFromEmail(), info.getPw());
    		}
 		});
	}
	
	private void setMessage(ArrayList<Match> matches) throws MessagingException {
		footballMessage = new MimeMessage(session);
		footballMessage.setFrom(new InternetAddress(info.getFromEmail()));
		footballMessage.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(info.getToEmail()));
		footballMessage.setSubject("Today's Featured Football Matches");
		footballMessage.setText(MessageMaker.makeMessageBody(matches));
	}
	
	public void sendMessage(ArrayList<Match> matches) throws MessagingException {
		setMessage(matches);
		Transport.send(footballMessage);
	}
}
