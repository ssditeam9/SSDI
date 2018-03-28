package uncc.ssdi.api;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import uncc.ssdi.model.User;
import uncc.ssdi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	
	
	 @RequestMapping("/signUp")
	    public ModelAndView signUp(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
	        ModelAndView mav = new ModelAndView("signUp");
		    mav.addObject("name", name);
		    return mav;
	    }
	 
	 @RequestMapping("/signUpPost")
	    public String signUpPost() {
	        UserService userService = new UserService();
	        User user = new User();
	        user.setEmailid("hi5.ankit@gmail.com");user.setFirstname("Ankit");user.setLastname("Luthra");user.setPassword("ankit");
	        userService.addUser(user);
		    return "User created Successfully";
	    }
	

}
