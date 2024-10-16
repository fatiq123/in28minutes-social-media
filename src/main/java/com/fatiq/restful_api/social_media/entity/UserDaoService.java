package com.fatiq.restful_api.social_media.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int userCount = 0;

	static {
		users.add(new User(++userCount, "fatiq", LocalDate.now().minusYears(21))); 
		users.add(new User(++userCount, "ali", LocalDate.now().minusYears(23)));
		users.add(new User(++userCount, "atif", LocalDate.now().minusYears(23)));
	}
	

	// get all users
    public List<User> findAll() {
        return users;
    }
    
    
    // get user by id
    public User userById(int id) {
    	Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
    }
    
    // delete user by id
    public void deleteUserById(int id) {
    	Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

    // create user
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
    

	
	
}
