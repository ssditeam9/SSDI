package uncc.ssdi.service;

import java.util.List;
import java.util.Optional;
import uncc.ssdi.model.Product;

public interface IProductService {

	public List<Product> getAllProducts();
	public Product addProduct(Product product);
	//public  Optional<Product> getProductDetails(int id);
}
