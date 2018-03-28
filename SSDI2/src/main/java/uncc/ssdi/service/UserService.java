package uncc.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;

import uncc.ssdi.dao.ProductRepository;
import uncc.ssdi.dao.UserRepository;
import uncc.ssdi.model.User;

public class UserService implements IUserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public void addUser(User u) {
		userRepository.save(u);
	}

}
