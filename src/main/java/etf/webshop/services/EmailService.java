package etf.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
    private JavaMailSender mailSender;
	
	public void sendMail(String to, String pin) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Verifikacija naloga");
		String text="Vaš kod za verifikaciju naloga je: "+pin;
		message.setText(text);
		mailSender.send(message);
	}
}
