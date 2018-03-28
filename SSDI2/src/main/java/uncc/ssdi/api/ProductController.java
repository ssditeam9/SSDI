package uncc.ssdi.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import uncc.ssdi.model.Product;
import uncc.ssdi.service.IProductService;
import uncc.ssdi.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	public ProductController() {
		productService = new ProductService();
	}
	@GetMapping("/DisplayProducts")
	public List<Product> getProducts() {
		//return productService.getAllProducts();
		//System.out.println("*****************8iside controller");
		List<Product> list = new ArrayList<>();
		list=productService.getAllProducts();
		
		return list;
	}
	
	
	 @RequestMapping("/getProd")
	    public ModelAndView hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
	        ModelAndView mav = new ModelAndView("hello");
	        List<Product> productList = productService.getAllProducts();
		    mav.addObject("name", name);
		    mav.addObject("productList", productList);
		   
		    return mav;
	    }
	
	
}
