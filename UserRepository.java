package hello;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  {

	
	User findUserDetailsByName(String name);
}
