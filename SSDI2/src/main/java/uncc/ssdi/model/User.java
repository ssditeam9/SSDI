package uncc.ssdi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

	
	@Entity
	@Table(name = "USERS")
	
	
	public class User implements Serializable,IUser {


	    @NotBlank
	    private String firstname;
	    
	    @NotBlank
	    private String lastname;
	    
	    
	    @NotBlank
	    private String password;
	   
	    @Id
	    @NotBlank
	    private String emailid;

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		
		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPassword() {
			return password;}
		
		public void setPassword(String password) {
			this.password = password;
		}
			
		public String getEmailid() {
			return emailid;}
		
		public void setEmailid(String Emailid) {
			this.emailid = Emailid;
		}
		
	    
	}
