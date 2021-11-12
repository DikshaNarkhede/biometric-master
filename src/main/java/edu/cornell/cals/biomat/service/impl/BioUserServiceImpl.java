package edu.cornell.cals.biomat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioUser;
import edu.cornell.cals.biomat.repository.BioUserRepository;
import edu.cornell.cals.biomat.service.BioUserService;

@Service
public class BioUserServiceImpl implements BioUserService{
	@Autowired
	BioUserRepository bioUserRepository;

	@Override
	public BioUser getBioUser(String userName) {
		BioUser bu = bioUserRepository.getBioUserByUserName(userName);
		return bu;
	}
	
	@Override
	public List<BioUser> getBioUsers() {
		List<BioUser> list = bioUserRepository.findAll();
		return list;
	}

	@Override
	public BioUser updateBioUser(BioUser bioUser) {
		BioUser bu =bioUserRepository.save(bioUser);
		return bu;
	}
	
	@Override
	public BioUser addBioUser(BioUser bioUser) {
		BCryptPasswordEncoder encryptor = new BCryptPasswordEncoder(15);
		String encodedPassword = encryptor.encode(bioUser.getPassword());
		bioUser.setPassword(encodedPassword);
		BioUser bu =bioUserRepository.save(bioUser);
		return bu;
	}
}
