package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
   private UserService userService;
  
    
    // ------------ Retrieve a Person Details ------------
	@RequestMapping(value = "/User/{name}", method = RequestMethod.GET)
	public User getPersonDetails(@PathVariable String name) {
		return userService.getPersonDetails(name);
}
        
        

    
        
    
        
}
