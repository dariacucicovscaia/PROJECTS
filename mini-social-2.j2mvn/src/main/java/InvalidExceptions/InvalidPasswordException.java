package InvalidExceptions;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String text) {

	}

	public String getMessage() {
		return "Invalid password!";
	}

}
