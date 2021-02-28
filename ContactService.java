package project1;
import java.util.LinkedList;

public class ContactService {
	
	//Constructor
	public ContactService() {
	}

	// Data structure to store contacts
	public LinkedList<Contact> contactList = new LinkedList<Contact>();
	
	// Add contacts with unique ID
	// Assumes that input has been received for all attributes
	public void addContact(String newId, String newFirstName, String newLastName, 
			String newPhone, String newAddress) {
		// Throw exception if ID is not unique
		boolean match = false;
		int i = 0;
		for (i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId() == newId) {
				match = true;
				break;
			}
		}
		if (match == true) {
			throw new IllegalArgumentException("Invalid ID.");
		}
		Contact newContact = new Contact(newId, newFirstName, newLastName, newPhone, newAddress);
		contactList.add(newContact);
	}
	
	// Delete contacts per contact ID
	public void deleteContact(String contactId) {
		int i = 0;
		boolean match = false;
		// Find the index of the contact to delete
		for (i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId() == contactId) {
				match = true;
				break;
			}
		}
		if (match == true) {
			contactList.remove(i);
		}
		else {
			throw new IllegalArgumentException("ID does not exist.");
		}
	}
	
	// Update first name per contact ID
	// Assumes firstName input has been received
	public void updateFirstName(String contactId, String newFirstName) {
		if (newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		int i = 0;
		boolean match = false;
		// Find the index of the contact to update
		for (i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId() == contactId) {
				match = true;
				break;
			}
		}
		if (match == true) {
			contactList.get(i).setFirstName(newFirstName);
		}
		else {
			throw new IllegalArgumentException("ID does not exist.");
		}
	}
	
	// Update last name per contact ID
	// Assumes lastName input has been received
	public void updateLastName(String contactId, String newLastName) {
		if (newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		int i = 0;
		boolean match = false;
		// Find the index of the contact to update
		for (i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId() == contactId) {
				match = true;
				break;
			}
		}
		if (match == true) {
			contactList.get(i).setLastName(newLastName);
		}
		else {
			throw new IllegalArgumentException("ID does not exist.");
		}
	}
	
	// Update phone number per contact ID
	// Assumes phone input has been received
	public void updatePhone(String contactId, String newPhone) {
		if (newPhone == null || newPhone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		int i = 0;
		boolean match = false;
		// Find the index of the contact to update
		for (i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId() == contactId) {
				match = true;
				break;
			}
		}
		if (match == true) {
			contactList.get(i).setPhone(newPhone);
		}
		else {
			throw new IllegalArgumentException("ID does not exist.");
		}
	}
	
	// Update address per contact ID
	// Assumes address input has been received
	public void updateAddress(String contactId, String newAddress) {
		if (newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid address.");
		}
		int i = 0;
		boolean match = false;
		// Find the index of the contact to update
		for (i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId() == contactId) {
				match = true;
				break;
			}
		}
		if (match == true) {
			contactList.get(i).setAddress(newAddress);
		}
		else {
			throw new IllegalArgumentException("ID does not exist.");
		}
	}
	
}