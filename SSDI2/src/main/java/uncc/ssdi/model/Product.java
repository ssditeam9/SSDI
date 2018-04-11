package uncc.ssdi.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


	@Entity
	@Table(name = "PRODUCTS")
	
	public class Product implements Serializable, IProduct {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column
	    private String name;
	    
	    @Column
	    private String description;
	    
	    @Column
	    private Double basePrice;
	    
	    @Column
	    private Double minPrice;
	    
	    @Column
	    private Integer quantity;

	    @Column
	    private String imageurl;
	    
	    @Column
	    private int sellerid;
	    
	    public int getSellerid() {
			return sellerid;
		}

		public void setSellerid(int sellerid) {
			this.sellerid = sellerid;
		}

		public Product() {
	    	
	    }

	/* @Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;*/

	   /* @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;*/

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public  Double getBasePrice() {
			return basePrice;
		}

		public void setBasePrice( Double d) {
			this.basePrice = d;
		}

		public Double getMinPrice() {
			return minPrice;
		}
		
		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}
		
		public String getImageurl() {
			return imageurl;
		}

		public void setMinPrice(Double minPrice) {
			this.minPrice = minPrice;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Product(int id, String name, String description, Double basePrice, Double minPrice, Integer quantity,
				String imageurl, int sellerid) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.basePrice = basePrice;
			this.minPrice = minPrice;
			this.quantity = quantity;
			this.imageurl = imageurl;
			this.sellerid = sellerid;
		}
		
		

	}
