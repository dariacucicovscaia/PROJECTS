package repository;

import java.sql.SQLException;
import java.util.List;

import domain.Task;
import factory.TaskFactory;
import services.DAOAbstract;

public class TaskRepo extends DAOAbstract<Task>{

	public TaskRepo() throws SQLException {
		super();
	}
	TaskFactory taskFactory = new TaskFactory();
	
	// 3 -- add a task to the user (insert username, Task Title, Description)
	public void addTasks(String username, String taskTitle, String taskDescription) throws SQLException {
		put(taskFactory.createTask(username, taskTitle, taskDescription));

	}

	// 4 --show user's tasks (print: Task title, Description)
	public List<Task> showTasks(String username) throws SQLException {
		return getAll();
	 }
	
}
