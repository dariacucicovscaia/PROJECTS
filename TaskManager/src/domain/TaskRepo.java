package domain;

import java.util.ArrayList;
import java.util.List;

import services.TaskFileStorage;
/**
 * tasks are stored and managed.
 * @author DARIA
 *
 */
public class TaskRepo {
	
	TaskFileStorage taskfile;

	public TaskRepo(String storege) {
		try {
			Class clazz = Class.forName(storege);
			taskfile = (TaskFileStorage) clazz.newInstance();

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	TaskFactory taskFactory = new TaskFactory();
	List<Task> usersTasks = new ArrayList<Task>();
	
	
	// 3 -- add a task to the user (insert username, Task Title, Description)
	public void addTasks(String username, String taskTitle, String taskDescription) {
		usersTasks.add(taskFactory.createTask(username, taskTitle, taskDescription));
		taskfile.serialize(usersTasks);

	}

	// 4 --show user's tasks (print: Task title, Description)
	public List<Task> showTasks(String username) {
		return taskfile.deserialize(usersTasks);
	 }
}
