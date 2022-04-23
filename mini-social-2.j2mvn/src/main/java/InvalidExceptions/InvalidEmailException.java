package InvalidExceptions;

public class InvalidEmailException extends Exception {

	public InvalidEmailException(String text) {

	}

	public String getMessage() {
		return "Invalid email!";
	}

}
