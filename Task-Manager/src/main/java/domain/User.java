package domain;

import java.util.UUID;

public class User {
	public UUID UUID;
	public String firstName;
	public String lastName;
	public String userName;

	public User() {

	}

	public User(UUID uuid,String firstName, String lastName, String userName) {
		super();
		setUuid(uuid);
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [FirstName=" + firstName + ", LastName=" + lastName + ", userName=" + userName + "]";
	}

	public UUID getUuid() {
		return UUID;
	}

	public void setUuid(UUID uuid) {
		this.UUID = uuid;
	}
}
