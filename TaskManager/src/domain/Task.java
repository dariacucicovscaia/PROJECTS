package domain;

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

	protected Task() {

	}

	protected Task(UUID uuid, String userName, String taskTitle, String taskDescription) {
		setUUID(uuid);
		setUserName(userName);
		setTaskTitle(taskTitle);
		setTaskDescription(taskDescription);
	}


	protected String getUserName() {
		return userName;
	}

	protected void setUserName(String userName) {
		this.userName = userName;
	}

	protected String getTaskTitle() {
		return taskTitle;
	}

	protected void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	protected String getTaskDescription() {
		return TaskDescription;
	}

	protected void setTaskDescription(String taskDescription) {
		TaskDescription = taskDescription;
	}

	@Override
	public String toString() {
		return "UserTask [userName=" + userName + ", taskTitle=" + taskTitle + ", TaskDescription=" + TaskDescription
				+ "]";
	}

	

}
