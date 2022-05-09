package factory;

import java.util.UUID;

import domain.User;

public class UserFactory {
	public User createUser(String firstName, String lastName, String userName) {
		User u = new User(UUID.randomUUID(), firstName, lastName, userName);
		return u;
	}
	
}
