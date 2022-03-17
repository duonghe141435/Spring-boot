package edu.poly.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.spring.models.User;
import edu.poly.spring.models.UserDTO;
import edu.poly.spring.sevice.UserSevice;

@RestController
public class UserController {
	@Autowired
	UserSevice userSevice;
	User users;
	
	@RequestMapping("/")
	public String viewHome() {

		return "welcomePage";
	}
	
//	@RequestMapping("/users")
//    public List<UserDTO> getUserList() {
//        return userSevice.getAllUsers();
//    }
//	
//	@PostMapping("/users")
//    public String creatUser(@RequestBody User user) {
//		userSevice.save(user);
//        return "Successfull!";
//    }
//	
//	@RequestMapping("/users/{id}")
//	public List<UserDTO> findUserByName(@PathVariable String name) {		
//		return userSevice.getUserByName(name);
//	}
//	
//	@GetMapping("/login")
//	public ModelAndView login() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("user",new User());
//		return mav;
//	}
//	@GetMapping("/users/{id}")
//	public List<UserDTO> findUserById(@PathVariable Long id) {		
//		return userSevice.getUserById(id);
//	}
	
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
