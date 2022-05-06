package Repository;

import java.util.ArrayList;
import java.util.List;

import Factory.UserFactory;
import Storage.UserFileAccess;
import domain.User;

public class UserRepo {

	
	TaskRepo tasks = new TaskRepo();
	UserFactory userFactory = new UserFactory();
	UserFileAccess user = new UserFileAccess(new User());
	List<User> users = new ArrayList<User>();
	
	
	public void addAndSerializeUser(String firstName, String lastName, String userName) {
		users.add(userFactory.createUser(firstName, lastName, userName));
		user.serialize(users);
	}
	
	
	
	// 2 --show all users (prin: FirstName, LastName, number of tasks)
	public List<String> showAllUsers() {
		
		List<String> show = new ArrayList<String>();

		for (User u : user.deserialize(users)) {
			show.add("FIRSTNAME:" + u.getFirstName() + ", LASTNAME:" + u.getLastName() + ", TASKS:");
		}
		
		return show;
	}
}
