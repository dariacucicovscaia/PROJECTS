package InvalidExceptions;

public class InvalidUUIDException extends Exception {
	
	public InvalidUUIDException(String text) {

	}

	public String getMessage() {
		return "Invalid UUID!";
	}

}
