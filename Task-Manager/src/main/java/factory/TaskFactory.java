package factory;

import java.sql.SQLException;

import domain.Task;
import domain.User;
import repository.UserRepo;

public class TaskFactory {
	Task t;
	public Task createTask(String userName, String tasktitle, String taskdescription) throws SQLException {
		UserRepo userrepo = new UserRepo();
		
		for (User u : userrepo.showAllUsers()) {
			if(u.getUserName().equals(userName)) {
			  t = new Task(u.getUuid(), userName, taskdescription, taskdescription );
			}
		}
		
		return t;
	}
}
