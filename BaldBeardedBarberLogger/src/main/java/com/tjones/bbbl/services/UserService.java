package com.tjones.bbbl.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.tjones.bbbl.models.LoginUser;
import com.tjones.bbbl.models.User;
import com.tjones.bbbl.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
    
    // TO-DO: Write register and login methods!
	
	
		public User findUser(Long id) {
			Optional<User> person = userRepository.findById(id);
			if(person.isPresent()){
				return person.get();
			}

			else{
				return null;
			}
		}
	
	
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
    	
    	// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
    	if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email", "Unique", "Email already in use!");
    	}
        	
    	// Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("password", "Matches", "Your password and confirm password must match!!");
    	}   	
        
    	// Return null if result has errors
        if(result.hasErrors()) {
        	return null;
        }
        
        else {
        	
        	// Hash and set password, save user to database
        	String hashed = BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt());
        	newUser.setPassword(hashed);
        	return userRepository.save(newUser);
        }
       
    
        
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
    	
    	// TO-DO - Reject values:
        
    	// Return null if result has errors
    	//if(result.hasErrors()) {
    		//return null;
    //	}
    	
    	// Find user in the DB by email
    	// Reject if NOT present
    	Optional<User> potentialUser = userRepository.findByEmail(newLoginObject.getEmail());
        if(!potentialUser.isPresent()) {
        	result.rejectValue("email", "Unique", " Email does not exist in the database!");
        	return null;
        }
       
        User user = potentialUser.get();
    	
    	
        
        // Reject if BCrypt password match fails
        if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
        	result.rejectValue("password", "Matches", "That password does not match the password for this email");
        	return null;
        }
        
        if(result.hasErrors()) {
    		return null;
    	}
    
        
        // Otherwise, return the user object
        else {
        	return user;
        	
        }
        
    }

}
