package domain;

import java.io.Serializable;

public class Task implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String taskTitle;
	private String TaskDescription;

	public Task() {

	}

	public Task(String userName, String taskTitle, String taskDescription) {
		setUserName(userName);
		setTaskTitle(taskTitle);
		setTaskDescription(taskDescription);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
