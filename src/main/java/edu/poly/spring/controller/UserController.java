package edu.poly.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.spring.models.User;
import edu.poly.spring.models.UserDTO;
import edu.poly.spring.reposirity.UserRepository;
import edu.poly.spring.sevice.UserSevice;

@Controller
public class UserController {
	@Autowired
	UserSevice userSevice;
	User users;
	
//	@RequestMapping("/")
//	public String viewHome() {
//
//		return "home";
//	}
	
	@RequestMapping("/users")
    public List<UserDTO> getUsersList() {
        return userSevice.getAllUsers();
    }
	

	
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
	
//	@RequestMapping("/created")
//	public String objectServletContext(Model model, HttpServletRequest request) {
//	    //String[] flowers = new String[] {"Rose","Lily", "Tulip", "Carnation", "Hyacinth" }; 
//	    List<UserDTO> flowers = userSevice.getAllUsers();
//	    model.addAttribute("flowers", flowers);
//	    return "createAccount";
//	}
}
