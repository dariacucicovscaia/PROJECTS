package InvalidExceptions;

public class InvalidDoBException extends Exception {
	public InvalidDoBException(String text) {

	}

	public String getMessage() {
		return "Invalid date of birth!";
	}

}
