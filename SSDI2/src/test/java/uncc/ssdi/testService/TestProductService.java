package uncc.ssdi.testService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.manager.DummyProxySession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import uncc.ssdi.dao.ProductRepository;
import uncc.ssdi.model.Product;
import uncc.ssdi.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestProductService {

	
	private MockMvc mockMvc;
	
	@Mock
	ProductRepository productRespository;
	
	@InjectMocks
	ProductService productService;
	
	Product dummyProd = new Product(6, "Apple Watch", "Apple Watch", 200.0, 169.0, 10, 
			"https://www.att.com/catalog/en/skus/Apple/Apple%20Watch%20Series%203/overview/326626-PDP-watch-S2-img1@2x.jpg", 2);
	
	
	@Test	
	public void testAddProduct() {
		//Given
		// we want to call real method for saving, but this call doesnt permits call to abstract methods
		Mockito.when(productRespository.save(dummyProd)).thenReturn(dummyProd);
		
		//productRespository.save(dummyProd);
		
		//When
		Product product = productService.addProduct(dummyProd);
		
		//Then
		assertThat(product, is(dummyProd));
		
		//verify
		verify(productRespository).save(dummyProd);
	}
	
	
	@Test	
	public void testgetAllProducts() {
		
		
		//Given
		List<Product> dummyProductList = new ArrayList<Product>();
		dummyProductList.add(dummyProd);
		Mockito.when(productRespository.findAll()).thenReturn(dummyProductList);
		
		//When
		List<Product> productList = productService.getAllProducts();
		
		//Then
		assertThat(productList, is(dummyProductList));
		
		//verify
		verify(productRespository).findAll();
	}
	
	
}
