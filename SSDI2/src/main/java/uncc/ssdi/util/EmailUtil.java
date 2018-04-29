package uncc.ssdi.util;

import java.util.Date;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class EmailUtil {

	
	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");
	      msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));
	      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
	      msg.setSubject(subject, "UTF-8");
	      msg.setText(body, "UTF-8", "html");
	      msg.setSentDate(new Date());
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
	      SMTPTransport t =
	              (SMTPTransport)session.getTransport("smtps");
	          t.connect("smtp.gmail.com", "hi5.ankit@gmail.com", "password!");
	          t.sendMessage(msg, msg.getAllRecipients());
//    	  Transport.send(msg);  
	      System.out.println("EMail Sent Successfully!!");
	      System.out.println("Response: " + t.getLastServerResponse());
	      t.close();
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
