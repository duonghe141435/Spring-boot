package edu.poly.spring.sevice;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.poly.spring.models.User;
import edu.poly.spring.models.UserDTO;
import edu.poly.spring.reposirity.UserRepository;
import edu.poly.spring.validate.ValidaterUser;

@Service

public class UserSevice {
	@Autowired
	UserRepository userRepository;

	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userDTOs = users.stream().map(user -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setName(user.getName());
			userDTO.setAge(user.getAge());
			userDTO.setUserName(user.getUserName());
			userDTO.setAddrest(user.getAddrest());
			userDTO.setUrlImage(user.getUrlImage());
			return userDTO;
		}).collect(Collectors.toList());		       
		    	
		return userDTOs;
		//return userRepository.findAll();
	}

//	public void save(User user) {
//		userRepository.save(user);
//	}
//
//
	public List<UserDTO> getUser(String UserName) {
		List<User> users = userRepository.findByUserName(UserName);
		List<UserDTO> userDTOs = users.stream().map(user -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setName(user.getName());
			userDTO.setAge(user.getAge());
			userDTO.setUserName(user.getUserName());
			userDTO.setAddrest(user.getAddrest());
			userDTO.setUrlImage(user.getUrlImage());
			return userDTO;
		}).collect(Collectors.toList());		       
		    	
		return userDTOs;
		
	}
//	
//	public List<UserDTO> getUserById(Long Id) {
//		Optional<User> userOptional = userRepository.findById(Id);
//		
//		List<UserDTO> userDTOs = userOptional.stream().map(user -> {
//			UserDTO userDTO = new UserDTO();
//			userDTO.setName(user.getName());
//			userDTO.setAge(user.getAge());
//			userDTO.setUserName(user.getUserName());
//			userDTO.setAddrest(user.getAddrest());
//			userDTO.setUrlImage(user.getUrlImage());
//			return userDTO;
//		}).collect(Collectors.toList());		       
//		if(userOptional.isPresent()) {
//			return userDTOs;
//		}
//		return null;
//		
//	}
//	
//	public Optional<User> login(String userName, String passWord) {
//		Optional<User> user = userRepository.findByUserNameAndPassword(userName, passWord);
//		return user;
//	}
	
    @Autowired
    private ValidaterUser validateUser;

//    public ResponseEntity<String> createUser(User user) {
//        String userName = user.getUserName();
//        String password = user.getPassword();
//        if (validateUser.isUserExited(userName)) {
//            return new ResponseEntity<>("User Existed", HttpStatus.BAD_REQUEST);
//        }
//        if (!validateUser.isLengthUserNameValid(userName) && !validateUser.isLengthUserNameValid(password)) {
//            return new ResponseEntity<>("Length of user name and password must be >= 6", HttpStatus.BAD_REQUEST);
//        }
//        userRepository.save(user);
//
//        return new ResponseEntity<>("Create user Success", HttpStatus.OK);
//    }
    
	  public String createUser(User user, Model model) {
		  String userName = user.getUserName();
	  if (validateUser.isUserExited(userName)) {
	      return "user";
	  }
	  	userRepository.save(user);
	  	List<UserDTO> users = getAllUsers();
	    model.addAttribute("users", users);
	  	return "createAccount";
	  }
	  
	  

    
//    public ResponseEntity<String> login(User user) {
//        String userName = user.getUserName();
//        String password = user.getPassword();
//        if (!validateUser.isUserExit(userName, password)) {
//            return new ResponseEntity<>("User not Exist", HttpStatus.BAD_REQUEST);
//        }
//        if (!validateUser.isLengthUserNameValid(userName) && !validateUser.isLengthUserNameValid(password)) {
//            return new ResponseEntity<>("Length of user name and password must be >= 6", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>("Login Success", HttpStatus.OK);
//    }
    
    public String login(User user, Model model) {
        String userName = user.getUserName();
        String password = user.getPassword();
        if (!validateUser.isUserExit(userName, password)) {
            return "login";
        }
        List<UserDTO> userList = getAllUsers();
        model.addAttribute("user", userList);
        return "user";
    }
}
