package Domain;

import java.io.Serializable;
import java.util.UUID;

public class Task extends UUIDEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String taskTitle;
	private String TaskDescription;

	public Task() {

	}

	public Task(UUID uuid, String userName, String taskTitle, String taskDescription) {
		setUuid(uuid);
		setUserName(userName);
		setTaskTitle(taskTitle);
		setTaskDescription(taskDescription);
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return TaskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		TaskDescription = taskDescription;
	}

	@Override
	public String toString() {
		return "UserTask [userName=" + userName + ", taskTitle=" + taskTitle + ", TaskDescription=" + TaskDescription
				+ "]";
	}

}
