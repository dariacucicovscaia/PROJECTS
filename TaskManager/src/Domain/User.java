package Domain;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private UUID uuid;
	private String FirstName;
	private String LastName;
	private String userName;

	public User() {
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userName
	 */
	public User(String firstName, String lastName, String userName) {
		super();
		setUUID(UUID.randomUUID()); //all our users will have a unique identifier , allows us to set the same username
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
	}

	public UUID getUUID() {
		return uuid;
	}

	public void setUUID(UUID uuid) {
		this.uuid = uuid;
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
		return "User FirstName=" + FirstName + ", LastName=" + LastName + " " ;
	}

}