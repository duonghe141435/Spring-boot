package edu.poly.spring.sevice;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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
	}

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

	@Autowired
	private ValidaterUser validateUser;

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

}
