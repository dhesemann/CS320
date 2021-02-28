package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project1.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("12345678", "George", "Foreman", "1234567890", 
				"123 Avenue Road");
		assertTrue(contact.getId().equals("12345678"));
		assertTrue(contact.getFirstName().equals("George"));
		assertTrue(contact.getLastName().equals("Foreman"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("123 Avenue Road"));
	}

	@Test
	void testIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "George", "Foreman", "1234567890", "123 Avenue Road");
		});
	}

	@Test
	void testIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "George", "Foreman", "1234567890", "123 Avenue Road");
		});
	}

	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678", "George Tony", "Foreman", "1234567890", "123 Avenue Road");
		});
	}

	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678", null, "Foreman", "1234567890", "123 Avenue Road");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678", "George", "Foreman-Tui", "1234567890", "123 Avenue Road");
		});
	}

	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678", "George", null, "1234567890", "123 Avenue Road");
		});
	}
	
	@Test
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678", "George", "Foreman", "12345678910", "123 Avenue Road");
		});
	}
	
	@Test
	void testPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678", "George", "Foreman", "123456789", "123 Avenue Road");
		});
	}

	@Test
	void testPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678", "George", "Foreman", null, "123 Avenue Road");
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678", "George", "Foreman", "1234567890", "012345678910 Avenue Road Circle");
		});
	}

	@Test
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678", "George", "Foreman", "1234567890", null);
		});
	}

}