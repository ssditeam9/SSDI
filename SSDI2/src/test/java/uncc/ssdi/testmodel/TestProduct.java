package uncc.ssdi.testmodel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uncc.ssdi.model.Product;

public class TestProduct {

	Product p=new Product();
	@Test
	@SuppressWarnings("deprecation")
	public void testGettersAndSetters() {
		p.setName("watch");
		p.setDescription("Nice watch");
		p.setBasePrice(35.0);
		p.setMinPrice(20.0);
		p.setImageurl("xyz.com");
		p.setQuantity(2);
		p.setSellerid(6);
		
		assertEquals("watch",p.getName());
		assertEquals("Nice watch",p.getDescription());
		assertEquals(35,p.getBasePrice(),1);
		assertEquals(20,p.getMinPrice(),1);
		assertEquals("xyz.com",p.getImageurl());
		assertEquals(String.valueOf("2"),p.getQuantity());
		assertEquals("65",p.getSellerid());
		
	}
	
}
