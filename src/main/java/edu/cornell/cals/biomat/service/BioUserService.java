package edu.cornell.cals.biomat.service;

import java.util.List;

import edu.cornell.cals.biomat.dao.BioUser;

public interface BioUserService {
	BioUser getBioUser(String userName);
	List<BioUser> getBioUsers();
	BioUser updateBioUser(BioUser bioUser);
	BioUser addBioUser(BioUser bioUser);
}
