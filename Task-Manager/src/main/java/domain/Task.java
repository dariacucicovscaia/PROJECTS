package domain;

import java.util.UUID;

public class Task {
	private UUID user_id;
	private String userName;
	private String taskTitle;
	private String TaskDescription;

	protected Task() {
		
	}

	public Task(UUID user_id, String userName, String taskTitle, String taskDescription) {
		setUser_id(user_id);
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

	public UUID getUser_id() {
		return user_id;
	}

	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}

	

}
