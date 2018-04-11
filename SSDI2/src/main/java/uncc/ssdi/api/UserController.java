package uncc.ssdi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import uncc.ssdi.model.Product;
import uncc.ssdi.model.User;
import uncc.ssdi.service.IProductService;
import uncc.ssdi.service.IUserService;

@RestController
@SessionAttributes({"uname","id"})
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IProductService productService;

	@RequestMapping("/signUp")
	public ModelAndView signUp(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView mav = new ModelAndView("signUp");
		mav.addObject("name", name);
		return mav;
	}

	@RequestMapping("/signUpPost")
	public String signUpPost(@RequestParam(value = "fname", required = true) String fname,
			@RequestParam(value = "lname", required = true) String lname,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "pass", required = true) String pass) {
		ModelAndView mav = new ModelAndView("signUp");
		User user = new User();
		user.setEmailid(email);
		user.setFirstname(fname);
		user.setLastname(lname);
		user.setPassword(pass);
		userService.addUser(user);
		System.out.println("Hallelujah");
		return "User created Successfully";
	}

	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping(value = "/compRegister", method = RequestMethod.POST)
	public ModelAndView compRegister( @ModelAttribute("user")User user) {
		
		userService.addUser(user);
		ModelAndView mav = new ModelAndView("regSuccess");
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping(value = "/compLogin", method = RequestMethod.POST)
	public ModelAndView compLogin( @ModelAttribute("user")User user) {
		User u=new User();
		u=userService.checkUser(user);
		if(u.getEmailid()=="invalid") {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("error", "Wrong credentials please try again");
		return mav;
		}
		else {
			
			ModelAndView mav = new ModelAndView("loginSuccess");
			mav.addObject("uname", u.getFirstname());
			mav.addObject("id", u.getId());
			return mav;
		}
	}
	@RequestMapping(value = "/logout")
	public ModelAndView logout(@ModelAttribute("uname")String username,SessionStatus status) {
		status.setComplete();
		List<Product> productList = productService.getAllProducts();
		ModelAndView mav = new ModelAndView("displayProducts");
		mav.addObject("productList", productList);
		return mav;
	}

}
