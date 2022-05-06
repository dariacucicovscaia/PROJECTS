package Repository;

import java.util.ArrayList;
import java.util.List;

import Storage.TaskFileAccess;
import domain.Task;

public class TaskRepo {

	TaskFileAccess<Task> task = new TaskFileAccess<Task>();
	List<Task> usersTasks = new ArrayList<>();
	Task usertask;

	// 3 -- add a task to the user (insert username, Task Title, Description)
	public void addTasks(String username, String taskTitle, String taskDescription) {
		usertask = new Task(username, taskTitle, taskDescription);
		usersTasks.add(usertask);
		
	}

	// 4 --show user's tasks (print: Task title, Description)
	public Task showTasks(String username) {
		return (Task) task.deserialize(usersTasks);
	}
}
