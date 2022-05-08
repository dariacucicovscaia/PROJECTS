package Factory;

import Domain.Task;
import Domain.UUIDEntity;


public class TaskFactory extends UUIDEntity {
	/**
	 * creates a task for a user
	 * 
	 * @param firstName
	 * @param tasktitle
	 * @param taskdescription
	 * @return
	 */
	public Task createTask(String firstName, String tasktitle, String taskdescription) {
		Task t = new Task(generateUserUUID(), firstName, tasktitle, taskdescription);
		return t;
	}
}
