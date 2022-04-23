package InvalidExceptions;

public class InvalidUserNameException extends Exception {

	public InvalidUserNameException(String text) {

	}

	public String getMessage() {
		return "Invalid UserName!";
	}

}
