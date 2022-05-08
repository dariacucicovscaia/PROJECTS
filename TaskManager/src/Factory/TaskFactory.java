package Factory;

import Domain.Task;


public class TaskFactory extends UUIDgenerator {
	
	public Task createTask(String firstName, String tasktitle, String taskdescription) {
		Task t = new Task(generateUserUUID(), firstName, tasktitle, taskdescription);
		return t;
	}
}
