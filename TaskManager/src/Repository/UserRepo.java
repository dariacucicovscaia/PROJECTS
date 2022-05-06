package Repository;

import java.util.ArrayList;
import java.util.List;

import Storage.UserFileAccess;
import domain.User;

public class UserRepo {
	
	
	UserFileAccess user  = new UserFileAccess(new User());
	TaskRepo tasks = new TaskRepo();
	List<User> users = new ArrayList<User>();

	
	
	//1 --create new users (insert: FirstName, LastName, userName)
		public void createUser( String firstName, String lastName, String userName) {
			User u = new User(firstName, lastName, userName);
			users.add(u);
			user.serialize(users);
			
		}
	    public List<User> getUsers() {
	    	return (List<User>) user.deserialize(users);
	    }


	 // 2 --show all users (prin: FirstName, LastName, number of tasks)
	 	public List<String> showAllUsers() {
	 		List<String> show = new ArrayList<String>();
	 	//needs a loop
	 	for (User U : getUsers()) {
			show.add("FIRSTNAME:" + U.getFirstName() + ", LASTNAME:" 
	 		+ U.getLastName() + ", TASKS:") ;		//add method to calculate the tasks		
		}
	 					
	 		return show; 
	 	}
}
