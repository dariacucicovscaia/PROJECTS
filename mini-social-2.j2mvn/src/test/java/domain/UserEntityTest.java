package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import InvalidExceptions.InvalidDoBException;
import InvalidExceptions.InvalidEmailException;
import InvalidExceptions.InvalidPasswordException;
import InvalidExceptions.InvalidUUIDException;
import InvalidExceptions.InvalidUserNameException;

class UserEntityTest {


	private User u;
	private Faker faker;
	int n;
	private String email;

	
	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	@BeforeEach
	public void initDefaultUser() {
		u = new User();
		faker = new Faker();
	}

	@Test
	public void setCorrectUUID() throws InvalidUUIDException {
		while (n > 0 && n > 100) {
			u.setUuid(UUID.randomUUID());
			assertEquals(UUID.randomUUID(), u.getUuid());
		}
	}

	@Test
	public void setCorrectUserNameTest() throws InvalidUserNameException {
		while (n > 0 && n > 100) {
			u.setUserName(faker.name().firstName());
			assertEquals(faker.name().firstName(), u.getUserName());
		}
	}

	@Test
	public void setCorrectEmailTest() throws InvalidEmailException {
		while (n > 0 && n > 100) {
			email = randomestring() + "@gmail.com";
			u.setEmail(email);
			assertEquals(email, u.getEmail());

		}
	}

	@Test
	public void setCorrectPasswordTest() throws InvalidPasswordException {
		u.setPassword("1234Aa@56");
		assertEquals("1234Aa@56", u.getPassword());

		u.setPassword("4567Aa@56");
		assertEquals("4567Aa@56", u.getPassword());

		u.setPassword("8910Aa@56");
		assertEquals("8910Aa@56", u.getPassword());
	}

	@Test
	public void setCorrectDobTest() throws InvalidDoBException {
		while (n > 0 && n > 10) {
			u.setDob("2021-12-23T18:03:00");
			assertEquals(faker.date().birthday(), u.getDob());
		}
	}

}
