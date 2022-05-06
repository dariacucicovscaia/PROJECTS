package Repository;

import java.util.ArrayList;
import java.util.List;

import Storage.UserFileAccess;
import domain.User;

public class UserRepo  {
	
	UserFileAccess<User> user = new UserFileAccess<User>();
	TaskRepo tasks = new TaskRepo();
	List<User> users = new ArrayList<User>();
	User u;
	
	
	//1 --create new users (insert: FirstName, LastName, userName)
		public void createUser( String firstName, String lastName, String userName) {
			u = new User(firstName, lastName, userName);
			users.add(u);
			user.serialize(users);;
			
		}
	    public User getUser() {
	    	return (User) user.deserialize(u);
	    }


	 // 2 --show all users (prin: FirstName, LastName, number of tasks)
	 	public List<String> showAllUsers() {	
	 		User userr = ((User) user.deserialize(u));
	 		List<String> show = new ArrayList<String>();
	 	//needs a loop
	 			show.add("FIRSTNAME:" + userr.getFirstName() + ", LASTNAME:" 
	 		+ userr.getLastName() + ", TASKS:") ;		//add method to calculate the tasks				
	 		
	 		return show; 
	 	}
}
