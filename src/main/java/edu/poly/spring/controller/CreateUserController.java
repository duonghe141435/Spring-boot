package edu.poly.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.Validate;

import edu.poly.spring.models.User;
import edu.poly.spring.reposirity.UserRepository;
import edu.poly.spring.sevice.UserSevice;
import edu.poly.spring.validate.ValidaterUser;




@Controller
public class CreateUserController {
	@Autowired
    private UserSevice userService;
	
	
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("saveUser", new User());
        return "createAccount";
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@ModelAttribute("saveUser") User saveUser) {
        return userService.createUser(saveUser);
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginUser", new User());
        return "login";
    }
//    
//    @RequestMapping(value = "loginUser", method = RequestMethod.POST)
//    public ResponseEntity<String> loginUser(@ModelAttribute("loginUser") User user) {
//        return userService.login(user);
//    }   
    
    @RequestMapping(value = "loginUser", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("loginUser") User user) {
//	   
//	    if (validaterUser.isUserExit(userName, password)==true) {
//	        return "user";
//	    }
//	    if (!validaterUser.isLengthUserNameValid(userName)==true && !validaterUser.isLengthUserNameValid(password)==true) {
//	        return "login";
//	    }
	    	return userService.login(user);
    }
}
