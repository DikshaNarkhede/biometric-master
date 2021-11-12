package edu.cornell.cals.biomat.dao;

import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class BioUserPrincipal implements UserDetails {
	private static final long serialVersionUID = 9210203030901844438L;

	private BioUser bioUser;
	Logger logger = LoggerFactory.getLogger(BioUserPrincipal.class);
	
	public BioUserPrincipal(BioUser bu) {
		bioUser = bu;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(bioUser.getUserRole()));
	}

	@Override
	public String getPassword() {
		return 	bioUser.getPassword();
	}

	@Override
	public String getUsername() {
		return 	bioUser.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public BioUser getBioUser() {
		return bioUser;
	}

	public void setBioUser(BioUser bioUser) {
		this.bioUser = bioUser;
	}

	@Override
	public String toString() {
		return "BioUserPrincipal [bioUser=" + bioUser + ", logger=" + logger + "]";
	}
	
}
