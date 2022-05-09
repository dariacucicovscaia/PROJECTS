package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;
import factory.UserFactory;
import services.DAOAbstract;

public class UserRepo extends DAOAbstract<User>{

	

		public UserRepo() throws SQLException {
		super();
	}

		UserFactory userFactory = new UserFactory();
		
		
		//TaskRepo t = new TaskRepo("domain.TaskFileStorage");

		public void addUser(String firstName, String lastName, String userName) throws SQLException {
			put(userFactory.createUser(firstName, lastName, userName));
		}
		

		// 2 --show all users (prin: FirstName, LastName, number of tasks)
		public List<String> showAllUsersS() throws SQLException {

			List<String> show = new ArrayList<String>();
			for (User u : getAll()) {
				show.add("FIRSTNAME:" + u.getFirstName() + ", LASTNAME:" + u.getLastName() + ", TASKS:");
			}

			return show;
		}

		/**
		 * to see if the user exists for task assigment(Task factory)
		 * @return user list of type user
		 */
		public List<User> showAllUsers() throws SQLException {
			return getAll();
		}

}
