package uncc.ssdi.service;

import java.util.Properties;

import javax.mail.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uncc.ssdi.dao.PaymentRepository;
import uncc.ssdi.model.Payment;
import uncc.ssdi.util.EmailUtil;

@Service
public class PaymentService implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Override
	public void sendEmailWithLink(String email) {
		System.out.println("In email with link "+email);
		sendEmail(email);
	}
	
	
	private void sendEmail(String emailID) {
		String mailBody = "Greetings! \n Please click on below link to create an account and get the deal. \n"
				+"Please note the link will expire in 2 business days."
				+ "\n <a href='http://localhost:8080/user/registerBuyer?e2="+emailID+"'>E-Commerce.com</a>";
				
		System.out.println("SimpleEmail Start");
		String smtpHostServer = "smtp.gmail.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpHostServer);
		props.put("mail.smtps.auth","true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		Session session = Session.getInstance(props, null);
		EmailUtil.sendEmail(session, emailID,"Your recent purchase on E-Commerce", mailBody);
	}
	
	public void addPaymentDetails(Payment payment) {
		System.out.println("Entered service");
		paymentRepository.save(payment);
		
	}
	
	

}
