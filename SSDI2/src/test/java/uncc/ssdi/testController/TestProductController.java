package uncc.ssdi.testController;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import uncc.ssdi.api.ProductController;
import uncc.ssdi.model.Product;
import uncc.ssdi.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(value = ProductController.class, secure = false)
public class TestProductController {
	
	private MockMvc mockMvc;
	
	@Mock
    ProductService productService;
	
	@Mock
    View mockView;
	
	@InjectMocks
	private ProductController productController;
	
	
	//Product mockProduct=new Product(1.0,"watch","nice watch",65.23,35.23,2,"89","xyz.com");
	@Before
	public void setUp() throws Exception{
		
		//MockitoAnnotations.initMocks(this);
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/webapp");
        viewResolver.setSuffix(".jsp");
		mockMvc = MockMvcBuilders.standaloneSetup(productController).setViewResolvers(viewResolver)
                .build();
	}
	
	@Test
	public void testController() throws Exception{
		ArrayList<Product> products = new ArrayList<Product>();
		Product product1 = new Product();
		product1.setDescription("Sample Description 1");
		Product product2 = new Product();
		product2.setDescription("Sample Description 2");
		products.add(product1);
		products.add(product2);
		Mockito.when(productService.getAllProducts()).thenReturn(products);
		ModelAndView mav = productController.displayProducts();
		
		ArrayList<Product> productsreturned = new ArrayList<Product>();
		productsreturned=(ArrayList<Product>)mav.getModel().get("productList");
		assertEquals(2,productsreturned.size());
		assertEquals("Sample Description 1",productsreturned.get(0).getDescription());
		//assertEquals("SampleName", mav.getModel().get("name").toString());
	}
	
	@Test
	public void testGetAllProductsUrl() throws Exception {
		
		this.mockMvc.perform(get("/api/displayProducts"))
        .andExpect(status().isOk());

	}
	

	
	

}
