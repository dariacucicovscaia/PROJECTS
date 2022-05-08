package Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import Factory.UserFactory;
import Storage.FileStorage;
import Storage.UserFileStorage;
import domain.User;

public class UserRepo {

	UserFileStorage userfile = new UserFileStorage(new User());

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
		userfile.serialize(users);// serialize(users);
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