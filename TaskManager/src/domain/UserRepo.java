package domain;

import java.util.ArrayList;
import java.util.List;
/**
 * users are stored and managed.
 * @author DARIA
 *
 */
public class UserRepo {

	UserFileStorage userfile;

	public UserRepo(String storege) {
		try {
			Class clazz = Class.forName(storege);
			userfile = (UserFileStorage) clazz.newInstance();

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	UserFactory userFactory = new UserFactory();
	List<User> users = new ArrayList<User>();

	public void addAndSerializeUser(String firstName, String lastName, String userName) {
		users.add(userFactory.createUser(firstName, lastName, userName));
		userfile.serialize(users);
	}

	// 2 --show all users (prin: FirstName, LastName, number of tasks)
	public List<String> showAllUsers() {

		List<String> show = new ArrayList<String>();

		for (User u : userfile.deserialize(users)) {
			show.add("FIRSTNAME:" + u.getFirstName() + ", LASTNAME:" + u.getLastName() + ", TASKS:");
		}
		
		return show;
	}
}