package edu.cornell.cals.biomat.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioUser;
import edu.cornell.cals.biomat.dao.BioUserPrincipal;
import edu.cornell.cals.biomat.repository.BioUserRepository;

@Service
public class BioMaterialUserDetailsServiceImpl implements UserDetailsService{
	Logger logger = LoggerFactory.getLogger(BioMaterialUserDetailsServiceImpl.class);
	@Autowired
	BioUserRepository bioUserRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Start userName {} " + username);
		BioUser bu = bioUserRepository.getBioUserByUserName(username);
		logger.info("Fetched  {} " + bu);
		return new BioUserPrincipal( bu);
	}

}
