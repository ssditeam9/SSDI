package uncc.ssdi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import uncc.ssdi.model.Product;
import uncc.ssdi.service.IProductService;
import uncc.ssdi.service.IUserService;
import uncc.ssdi.service.ProductService;
import uncc.ssdi.service.UserService;

@RestController
@SessionAttributes({"uname","id"})
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IUserService userService;

	public ProductController() {
		productService = new ProductService();
		userService = new UserService();
	}
	
 
    
	@GetMapping("/DisplayProducts")
    public ModelAndView displayProducts() {
        ModelAndView mav = new ModelAndView("displayProducts");
        List<Product> productList = productService.getAllProducts();
	    mav.addObject("productList", productList);
	    return mav;
    }
	
	
	@GetMapping("/quote")
    public ModelAndView placeQuote(@ModelAttribute("prod") Product product) {
        ModelAndView mav = new ModelAndView("hello");
        List<Product> productList = productService.getAllProducts();
	    mav.addObject("productList", productList);
	   
	    return mav;
    }
	
	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {
		 ModelAndView mav = new ModelAndView("addProduct");
		 mav.addObject("product", new Product());
		 return mav;
	}
	
	@RequestMapping(value = "/addproductsuccess", method = RequestMethod.POST)
	public ModelAndView addProductSuccess( @ModelAttribute("product")Product product,@SessionAttribute("id")int i) {
		product.setSellerid(i);
		productService.addProduct(product);
		ModelAndView mav = new ModelAndView("addProductSuccess");
		return mav;
	}
	
	
	
}
