package edu.poly.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.poly.spring.models.User;
import edu.poly.spring.models.UserDTO;
import edu.poly.spring.sevice.UserSevice;




@Controller
public class CreateUserController {
	@Autowired
    private UserSevice userService;
	
	
    @GetMapping("/create")
    public String create(Model model) {
    	
    		List<UserDTO> users = userService.getAllUsers();
    	    model.addAttribute("users", users);
            model.addAttribute("saveUser", new User());
            return "createAccount";
    	
    	
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("create") User saveUser, Model model) {    	
        return userService.createUser(saveUser, model);
    }
    
//    
//    @GetMapping("/login")
//    public String login(Model model, HttpSession session) {
//    	//session.removeAttribute("USENAME");
//        model.addAttribute("loginUser", new User());
//        return "login";
//    }
//    
//    @RequestMapping(value = "userLogin", method = RequestMethod.POST)
//    public String loginUser(@ModelAttribute("loginUser") User user, Model model , HttpSession session) {
//    	
//	    return userService.login(user, model,session);
//    }
    
    @GetMapping("/user")
    public String getUser(Model model, HttpSession session) {    
    		List<UserDTO> user = userService.getAllUsers();
    	    model.addAttribute("user", user);
            return "user";    	
    }
    
    @GetMapping("logout")
    	public String logout(HttpSession session) {
    		session.removeAttribute("USENAME");
    	return "redirect:/login";
    }
}
