package edu.cornell.cals.biomat.config;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptTest {
	Logger logger = LoggerFactory.getLogger(BCryptTest.class);

	@Test
	public void encodeRowPassoword() {
		BCryptPasswordEncoder encryptor = new BCryptPasswordEncoder(15);
		String encodedPassword = encryptor.encode("test");
		logger.info("bcrypt Value of test  {} " + encodedPassword);
		boolean match = encryptor.matches( "test", encodedPassword);
		assert(match==true);
		
		encodedPassword = encryptor.encode("venky");
		logger.info("bcrypt Value of venky  {} " + encodedPassword);
		match = encryptor.matches( "venky", encodedPassword);
		
		assert(match==true);

		
	}
	
}
