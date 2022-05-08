package Factory;
import Domain.User;

public class UserFactory extends UUIDgenerator {
	
	 
	/**
	 * UUID - all our users will have a unique identifier , allows us to set the
	 * same username
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @return
	 */
	public User createUser(String firstName, String lastName, String userName) {
		User u = new User(generateUserUUID(), firstName, lastName, userName);
		return u;
	}
	
	
}
