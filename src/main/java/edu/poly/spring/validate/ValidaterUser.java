package edu.poly.spring.validate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.poly.spring.models.User;
import edu.poly.spring.reposirity.UserRepository;

@Component
public class ValidaterUser {
	@Autowired
	private UserRepository userRepository;
	
	private final int MIN_LENGTH = 6;
	
	public boolean isUserExited(String userName) {
		List<User> user = userRepository.findByUserName(userName);
		return !user.isEmpty();
		
	}
	
	public boolean isUserExit(String userName, String password) {
		Optional<User> user = userRepository.findByUserNameAndPassword(userName, password);		
		return user.isPresent();		
	}
	
	public boolean isLengthUserNameValid(String userName) {
		if(userName == null) {
			return false;
		}
		return userName.length() >=MIN_LENGTH;		
	}
}
