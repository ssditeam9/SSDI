package uncc.ssdi.testController;


import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import uncc.ssdi.model.Product;

public class TestProductController {
	
	
	


		private static final Object[] Product = null;
		Product p=new Product();
		@Test
		@SuppressWarnings("deprecation")
		@RequestMapping("/getProd")
		public ModelAndView testController(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
			
			        ModelAndView mav = new ModelAndView("hello");
			        List<Product> productList = new ArrayList<Product>();
			        productList.add(p);
			        mav.addObject("name", name);
				    mav.addObject("productList", productList);
				    //assertArrayEquals(productList.toArray(Product), Product);
				    return mav;
			    }
			
		}

