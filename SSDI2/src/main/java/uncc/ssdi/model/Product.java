package uncc.ssdi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

	@Entity
	@Table(name = "PRODUCTS")
	@EntityListeners(AuditingEntityListener.class)
	@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
	        allowGetters = true)
	public class Product implements Serializable, IProduct {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @NotBlank
	    private String name;
	    
	    @NotBlank
	    private String description;
	    
	    @NotBlank
	    private float basePrice;
	    
	    @NotBlank
	    private float minPrice;
	    
	    @NotBlank
	    private int quantity;

	    @NotBlank
	    private String sellerId;
	    
	    @NotBlank
	    private String imageurl;
	    
	   

	   /* @Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;*/

	   /* @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;*/

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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

		public float getBasePrice() {
			return basePrice;
		}

		public void setBasePrice(float basePrice) {
			this.basePrice = basePrice;
		}

		public float getMinPrice() {
			return minPrice;
		}
		
		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}
		
		public String getImageurl() {
			return imageurl;
		}

		public void setMinPrice(float minPrice) {
			this.minPrice = minPrice;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getSellerId() {
			return sellerId;
		}

		public void setSellerId(String sellerId) {
			this.sellerId = sellerId;
		}

	/*	public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}*/

	    
	}
