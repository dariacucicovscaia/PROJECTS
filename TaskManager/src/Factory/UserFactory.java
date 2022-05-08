package Factory;
import Domain.UUIDEntity;
import Domain.User;

public class UserFactory extends UUIDEntity {
	
	 
	/**
	 * 
	 * creates a user
	 * 
	 * 
	 * UUID - all our users will have a unique identifier
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
