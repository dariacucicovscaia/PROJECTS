package Factory;

import java.util.ArrayList;
import java.util.List;

import Storage.UserFileAccess;
import domain.User;

public class UserFactory{
	
	UserFileAccess user = new UserFileAccess(new User());
	List<User> users = new ArrayList<User>();
	
	public void createUser(String firstName, String lastName, String userName) {
		User u = new User(firstName, lastName, userName);
		//System.out.println("user created");
		users.add(u);
		user.serialize(users);
	}
	
	public List<User> getUsers() {
		return user.deserialize(users);
	}
}
