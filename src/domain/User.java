package domain;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String FirstName;
	private String LastName;
	private String userName;

	public User() {

	}

	public User(String firstName, String lastName, String userName) {
		super();
		
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User FirstName=" + FirstName + ", LastName=" + LastName + " ";
	}

	
	

}