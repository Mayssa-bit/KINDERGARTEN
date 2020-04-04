package tn.esprit.spring.Services;

import org.springframework.mail.SimpleMailMessage;

public interface IEmailService {
	public void sendEmail(SimpleMailMessage email);
}
