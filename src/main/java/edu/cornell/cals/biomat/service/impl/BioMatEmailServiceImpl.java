package edu.cornell.cals.biomat.service.impl;

import java.security.Principal;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioUser;
import edu.cornell.cals.biomat.dao.BioUserPrincipal;
import edu.cornell.cals.biomat.service.BioMatEmailService;

@Service
public class BioMatEmailServiceImpl implements BioMatEmailService{
	@Autowired
    private JavaMailSender sender;
	@Autowired
	private UserDetailsService userDetailService;
	Logger logger = LoggerFactory.getLogger(BioMatEmailServiceImpl.class);
	
	@Override
	public void emailBioMaterialAdded(Principal principal){
		logger.info("Start {} ",  principal);
		try {
			BioUserPrincipal bioUserPrincipal = (BioUserPrincipal)userDetailService.loadUserByUsername(principal.getName());
			logger.info("UserDetails {} ",  bioUserPrincipal );
			String email = bioUserPrincipal.getBioUser().getEmail();
			logger.info("email {} ",  email);
			logger.info("Email TO Address of principal {} {}  ",  principal.getName(),email);
			sendSimpleEmail(email,"Your Contribution is added to Bio-Material Database",""
					+ "We thank you for your contribution. Your Contribution is now in pending state. An administrator will review and update the status. You will get another email after Administartor takes an action."
					+ "");
			logger.info("Successfully sent email");
		}
		catch(Exception ex) {
			throw new RuntimeException("An Error occured in sending email. " + ex.getMessage(), ex);
		}
	}
	

	private void sendSimpleEmail(String to, String subject, String emailMessage) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(emailMessage);
        sender.send(message);
    }

}
