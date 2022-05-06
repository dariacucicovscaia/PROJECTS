package Repository;

import java.util.ArrayList;
import java.util.List;

import Factory.UserFactory;
import Storage.FileStorage;
import domain.User;

public class UserRepo extends FileStorage<User>{

	
	public UserRepo(User obj) {
		super(obj);
	}



	UserFactory userFactory = new UserFactory();
	List<User> users = new ArrayList<User>();
	
	
	public void addAndSerializeUser(String firstName, String lastName, String userName) {
		users.add(userFactory.createUser(firstName, lastName, userName));
		serialize(users);
	}
	
	
	
	// 2 --show all users (prin: FirstName, LastName, number of tasks)
	public List<String> showAllUsers() {
		
		List<String> show = new ArrayList<String>();

		for (User u : deserialize(users)) {
			show.add("FIRSTNAME:" + u.getFirstName() + ", LASTNAME:" + u.getLastName() + ", TASKS:");
		}
		
		return show;
	}
}