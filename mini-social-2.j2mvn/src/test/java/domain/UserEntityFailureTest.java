package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import InvalidExceptions.InvalidDoBException;
import InvalidExceptions.InvalidEmailException;
import InvalidExceptions.InvalidPasswordException;
import InvalidExceptions.InvalidUUIDException;
import InvalidExceptions.InvalidUserNameException;

class UserEntityFailureTest {
	
	private User u;

	@BeforeEach
	public void initDefaultUser() {
		u = new User();
	}

	@Test
	public void setIncorrectUUIDTest() {
		try {
			u.setUuid(new UUID(0, 0));
		}catch(InvalidUUIDException ex) {
			assertEquals("Invalid UUID!",  ex.getMessage());
		}
	}

	@Test
	public void setIncorrectUserNameTest() {
		try {
			u.setUserName("(.*[a-z].*)");
		}catch(InvalidUserNameException ex){
			assertEquals("Invalid UserName!", ex.getMessage());
		}
		
		try {
			u.setUserName("(.*[A-Z].*)");
		}catch(InvalidUserNameException ex){
			assertEquals("Invalid UserName!", ex.getMessage());
		}
	}

	@Test
	public void invalidEmailFieldTest() {
		try {
			u.setEmail("this_is_an_invalid_email");

		} catch (InvalidEmailException ex) {
			assertEquals("Invalid email!", ex.getMessage());
		}

	}

	@Test
	public void setIncorrectPasswordTest() {
		try {
			u.setPassword("123456789");
		} catch (InvalidPasswordException ex) {
			assertEquals("Invalid password!",  ex.getMessage());
		}

	}

	@Test
	public void setIncorrectDobTest() throws InvalidDoBException {
		try {
			u.setDob("jjjjj");
		}catch(InvalidDoBException ex) {
			assertEquals("Invalid date of birth!",  ex.getMessage());
		}
	}

}















