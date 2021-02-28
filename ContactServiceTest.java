package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import project1.Contact;
import project1.ContactService;

class ContactServiceTest {
	
	ContactService myContactService = new ContactService();
	
	@BeforeEach
	void setUpTests() {
		// Add contact to list
		Contact newContact = new Contact("12345678", "George", "Foreman", "1234567890", 
				"123 Avenue Road");
		myContactService.contactList.add(newContact);
	}
	
	@AfterEach
	void tearDownTests() {
		// Clear contacts from lists
		myContactService.contactList.clear();
	}
	
	@Test
	void testAddContact() {
		
		myContactService.addContact("87654321", "Tim", "Nguyen", "0123456789", 
				"5 Circle Way");
		
		assertNotNull(myContactService.contactList.get(1));
		assertTrue(myContactService.contactList.get(1).getId().equals("87654321"));
		assertTrue(myContactService.contactList.get(1).getFirstName().equals("Tim"));
		assertTrue(myContactService.contactList.get(1).getLastName().equals("Nguyen"));
		assertTrue(myContactService.contactList.get(1).getPhone().equals("0123456789"));
		assertTrue(myContactService.contactList.get(1).getAddress().equals("5 Circle Way"));
		
	}
	
	@Test
	void testIdNotUnique() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.addContact("12345678", "Tim", "Nguyen", "0123456789", 
					"5 Circle Way");
		});
	}
	
	@Test
	void testDeleteContact() {
		myContactService.deleteContact("12345678");
		assertTrue(myContactService.contactList.size() == 0);
	}
	
	@Test
	void testIdDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.deleteContact("87654321");
		});
	}
	
	@Test
	void testUpdateFirstName() {
		myContactService.updateFirstName("12345678", "Roland");
		assertTrue(myContactService.contactList.get(0).getFirstName().equals("Roland"));
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updateFirstName("12345678", "George Tony");
		});
	}
	
	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updateFirstName("12345678", null);
		});
	}
	
	@Test
	void testUpdateFirstNameWrongId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updateFirstName("87654321", "Roland");
		});
	}
	
	@Test
	void testUpdateLastName() {
		myContactService.updateLastName("12345678", "Ramirez");
		assertTrue(myContactService.contactList.get(0).getLastName().equals("Ramirez"));
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updateLastName("12345678", "Foreman-Tui");
		});
	}
	
	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updateLastName("12345678", null);
		});
	}
	
	@Test
	void testUpdateLastNameWrongId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updateFirstName("87654321", "Ramirez");
		});
	}
	
	@Test
	void testUpdatePhone() {
		myContactService.updatePhone("12345678", "0987654321");
		assertTrue(myContactService.contactList.get(0).getPhone().equals("0987654321"));
	}
	
	@Test
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updatePhone("12345678", "12345678910");
		});
	}
	
	@Test
	void testPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updatePhone("12345678", "123456789");
		});
	}
	
	@Test
	void testPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updatePhone("12345678", null);
		});
	}
	
	@Test
	void testUpdatePhoneWrongId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updateFirstName("87654321", "0987654321");
		});
	}
	
	@Test
	void testUpdateAddress() {
		myContactService.updateAddress("12345678", "5 Circle Way");
		assertTrue(myContactService.contactList.get(0).getAddress().equals("5 Circle Way"));
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updateAddress("12345678", "012345678910 Avenue Road Circle");
		});
	}
	
	@Test
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updateAddress("12345678", null);
		});
	}
	
	@Test
	void testUpdateAddressWrongId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myContactService.updateFirstName("87654321", "5 Circle Way");
		});
	}

}
