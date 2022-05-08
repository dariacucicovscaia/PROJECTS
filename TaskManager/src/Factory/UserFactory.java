package Factory;

import Domain.User;

public class UserFactory {

	public User createUser(String firstName, String lastName, String userName) {
		User u = new User(firstName, lastName, userName);

		return u;
	}

}
