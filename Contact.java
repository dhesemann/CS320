package project1;
public class Contact {
	
	// private attributes
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		// Throw exception if ID too long or null
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID.");
		}
		// Throw exception if firstName is too long or null
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		// Throw exception if lastName is too long or null
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		// Throw exception if phone is not 10 digits
		// Assumes phone is input on number-only keypad
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		// Throw excpetion if address is too long or null
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address.");
		}
		// Assign attributes
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	//public mutators
	public void setId(String idNum) {
		id = idNum;
	}
	
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}
	
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}
	
	public void setPhone(String phoneNum) {
		phone = phoneNum;
	}
	
	public void setAddress(String newAddress) {
		address = newAddress;
	}
	
	//public accessors
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
}