package Repository;

import java.util.ArrayList;

import java.util.List;

import Domain.Task;
import Storage.FileStorage;

public class TaskRepo  {

//	public TaskRepo(Task obj) {
//		super(obj);
//	}
	List<Task> usersTasks = new ArrayList<>();
	

	// 3 -- add a task to the user (insert username, Task Title, Description)
	public void addTasks(String username, String taskTitle, String taskDescription) {
		Task usertask = new Task(username, taskTitle, taskDescription);
		usersTasks.add(usertask);
		//serialize(usersTasks);
	}

	// 4 --show user's tasks (print: Task title, Description)
//	public List<Task> showTasks(String username) {
//		return deserialize(usersTasks);
	//}
}