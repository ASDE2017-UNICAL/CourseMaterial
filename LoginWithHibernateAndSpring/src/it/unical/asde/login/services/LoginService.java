package it.unical.asde.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde.login.daos.CredentialsDao;

@Service
public class LoginService {
	
	@Autowired
	private CredentialsDao credentialsDao;

	public boolean loginAttempt(String username, String password) {
		
		return credentialsDao.credentialsExist(username, password);
	}

}
