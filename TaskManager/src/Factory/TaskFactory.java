package Factory;

import java.util.UUID;

import Domain.Task;


public class TaskFactory extends UUIDgenerator {
	
	public Task createTask(String firstName, String lastName, String userName) {
		Task u = new Task(generateUserUUID(), firstName, lastName, userName);
		return u;
	}
}
