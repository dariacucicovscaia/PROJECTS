package domain;

import java.util.UUID;

public class Task {
	public UUID UUID;
	public String userName;
	public String taskTitle;
	public String TaskDescription;

	public Task() {
		
	}

	public Task(UUID user_id, String userName, String taskTitle, String taskDescription) {
		setUser_id(user_id);
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

	public UUID getUser_id() {
		return UUID;
	}

	public void setUser_id(UUID user_id) {
		this.UUID = user_id;
	}

	

}
