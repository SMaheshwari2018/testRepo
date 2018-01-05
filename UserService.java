package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository UserRepository;
	
	// Retrieves one row from table based on given id
	public User getPersonDetails(String name) {
		return UserRepository.findUserDetailsByName(name);
	
	}

}
