package uncc.ssdi.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class PaymentController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IUserService userService;

	public PaymentController() {
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
	
	
	@RequestMapping(value = "/buyProduct", method = RequestMethod.GET)
	public ModelAndView buyProduct(@RequestParam("prodId")int prodId) {
		System.out.println(prodId);
		ModelAndView mav = new ModelAndView("displaySingleProduct");
		List<Product> productListAll = productService.getAllProducts();
		List<Product> productListOne = new ArrayList<Product>();
		for(Product prod: productListAll) {
			if (prod.getId() == prodId) {
				productListOne.add(prod);
				break;
			}
		}
		mav.addObject("productList", productListOne);
		return mav;
	}
	
	
	
}
