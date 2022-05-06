package Repository;

import java.util.ArrayList;
import java.util.List;

import Factory.UserFactory;
import Storage.UserFileAccess;
import domain.User;

public class UserRepo {

	
	TaskRepo tasks = new TaskRepo();
	UserFactory userFactory = new UserFactory();

	

	// 2 --show all users (prin: FirstName, LastName, number of tasks)
	public List<String> showAllUsers() {
		
		List<String> show = new ArrayList<String>();

		for (User u : userFactory.getUsers()) {
			show.add("FIRSTNAME:" + u.getFirstName() + ", LASTNAME:" + u.getLastName() + ", TASKS:");
			//System.out.println(u.getFirstName());
		}
		
		return show;
	}
}
