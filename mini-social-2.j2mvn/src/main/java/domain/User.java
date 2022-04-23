package domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import InvalidExceptions.InvalidDoBException;
import InvalidExceptions.InvalidEmailException;
import InvalidExceptions.InvalidPasswordException;
import InvalidExceptions.InvalidUUIDException;
import InvalidExceptions.InvalidUserNameException;

public class User {

	private UUID uuid;
	private String UserName;
	private String email;
	private String password;
	private LocalDateTime dob;
	private boolean real;

	LocalDateTime lastOnline;
	String avatarURL;

	public User() {

	}

	public User(UUID uuid, String UserName, String email, String password, String dob, boolean real, String avatarURL)
			throws InvalidEmailException, InvalidPasswordException, InvalidUserNameException, InvalidUUIDException,
			InvalidDoBException {
		super();
		setUuid(uuid);
		setUserName(UserName);
		setEmail(email);
		setPassword(password);
		setDob(dob);
		setReal(real);
		setAvatarURL(avatarURL);
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid.toString();
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(UUID uuid) throws InvalidUUIDException {
		if (uuid.equals(null)) {
			throw new InvalidUUIDException("This field needs to be filled!");
		} else {
			this.uuid = UUID.randomUUID();
		}

	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) throws InvalidUserNameException {
		if (userName.length() < 2 || userName.length() > 16) {
			throw new InvalidUserNameException("The limit of characters for the username is (between 2 and 16)");
		} else {
			this.UserName = userName;
		}
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) throws InvalidEmailException {

		if (!email.contains("@")) {
			throw new InvalidEmailException("Email must contain \"@\"");
		} else if (!email.contains(".")) {
			throw new InvalidEmailException("Email must contain \".\"");
		} else if (email.indexOf('@') > email.indexOf('.')) {
			throw new InvalidEmailException("The \"@\" needs to be before\".\"");
		} else {
			this.email = email;
		}

	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) throws InvalidPasswordException {

		String upperCaseChars = "(.*[A-Z].*)";
		String lowerCaseChars = "(.*[a-z].*)";
		String numbers = "(.*[0-9].*)";
		String specialChars = "(.*[@,#,$,%].*$)";

		if (password.length() > 32 || password.length() < 6) {
			throw new InvalidPasswordException(
					"Password has to contain at least 6 characters, and can't have more than 32");
		}
		if (!password.matches(upperCaseChars)) {
			throw new InvalidPasswordException("Password must contain at least 1 Upper case character!");
		}
		if (!password.matches(lowerCaseChars)) {
			throw new InvalidPasswordException("Password must contain at least 1 Lower case character!");
		}
		if (!password.matches(numbers)) {
			throw new InvalidPasswordException("Password must contain at least one digit");
		}
		if (!password.matches(specialChars)) {
			throw new InvalidPasswordException("Password must contain at least one sign like @,#,$,% etc");
		} else {
			this.password = password;
		}
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob.toString();
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) throws InvalidDoBException {
		/// min age and max age 1950....2021

		if (dob.equals(null)) {
			throw new InvalidDoBException("This field needs to be filled!");
		} else {
			this.dob = LocalDateTime.parse(dob);
		}
	}

	/**
	 * @return the real
	 */
	public boolean isReal() {
		return real;
	}

	/**
	 * @param real the real to set
	 */
	public void setReal(boolean real) {
		this.real = real;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(uuid, other.uuid);
	}

	public String getLastOnline() {
		return lastOnline.toString();
	}

	public void setLastOnline(String lastOnline) {
		this.lastOnline = LocalDateTime.parse(lastOnline);
	}

	public String onlineTimeAgo() {
		String status = null;
		long minutes = lastOnline.until(LocalDateTime.now(), ChronoUnit.MINUTES);
		long hours = lastOnline.until(LocalDateTime.now(), ChronoUnit.HOURS);
		long days = lastOnline.until(LocalDateTime.now(), ChronoUnit.DAYS);

		long weeks = lastOnline.until(LocalDateTime.now(), ChronoUnit.WEEKS);

		if (minutes <= 5) {
			status = "Online";
		} else if (minutes >= 5 && minutes <= 55) {
			status = "Last seen " + minutes + " minutes ago";
		} else if (hours >= 1 && hours <= 23) {
			status = "Last seen " + hours + " hours ago";
		} else if (hours >= 24 && days <= 6) {
			status = "Last seen " + days + " day/s ago";
		} else if (days >= 7 && days <= 30) {
			status = "Last seen " + days + "days ago";
		} else {
			status = "Last seen" + weeks + " weeks ago";
		}

		return status;

	}

	public boolean isOnline() {
		return lastOnline.until(LocalDateTime.now(), ChronoUnit.MINUTES) <= 5;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

}
