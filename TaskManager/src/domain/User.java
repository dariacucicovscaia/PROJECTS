package domain;

import java.io.Serializable;
import java.util.UUID;

public class User extends UUIDEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String FirstName;
	private String LastName;
	private String userName;

	protected User() {
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userName
	 */
	protected User(UUID uuid, String firstName, String lastName, String userName) {
		super();
		setUUID(uuid); 
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
	}



	protected String getFirstName() {
		return FirstName;
	}

	protected void setFirstName(String firstName) {
		FirstName = firstName;
	}

	protected String getLastName() {
		return LastName;
	}

	protected void setLastName(String lastName) {
		LastName = lastName;
	}

	protected String getUserName() {
		return userName;
	}

	protected void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User FirstName=" + FirstName + ", LastName=" + LastName + " " ;
	}

	

}