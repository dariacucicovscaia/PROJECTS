package Repository;

import java.util.ArrayList;
import java.util.List;

import Storage.TaskFileAccess;
import domain.Task;

public class TaskRepo {

	TaskFileAccess task = new TaskFileAccess(new Task());
	List<Task> usersTasks = new ArrayList<>();
	

	// 3 -- add a task to the user (insert username, Task Title, Description)
	public void addTasks(String username, String taskTitle, String taskDescription) {
		Task usertask = new Task(username, taskTitle, taskDescription);
		usersTasks.add(usertask);
		task.serialize(usersTasks);
	}

	// 4 --show user's tasks (print: Task title, Description)
	public List<Task> showTasks(String username) {
		return task.deserialize(usersTasks);
	}
}
