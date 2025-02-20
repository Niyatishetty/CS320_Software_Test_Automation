package projectOne;

/**
 * 
 * @author Niyati.Shetty
 *
 * The "Contact" class stores contact ID, first name, last name, phone number and address. 
 */

public class Contact {
	
    private final String contactId;
    
    private String firstName;
    
    private String lastName;
    
    private String phoneNumber;
    
    private String address;

    // Constructor - with 5 attributes
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate each field according to requirements
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException(
            		"Invalid Contact ID: it cannot be NULL and it cannot be longer than 10 characters.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
            		"Invalid First Name: it cannot be NULL and it cannot be longer than 10 characters.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
            		"Invalid Last Name: it cannot be NULL and it cannot be longer than 10 characters.");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
            		"Invalid Phone: it cannot be NULL and it must be exact 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
            		"Invalid Address: it cannot be NULL and it cannot be longer than 30 characters.");
        }

        this.contactId  = contactId;
        this.firstName  = firstName;
        this.lastName  = lastName;
        this.phoneNumber = phone;
        this.address = address;
    }
    
    /**
     *  Getter method
     */
    
    // returns Contact ID 
    public String getContactId() {
        return contactId;
    }

    // returns First Name 
    public String getFirstName() {
        return firstName;
    }

    
    // returns lastName 
    public String getLastName() {
        return lastName;
    }

    
    // returns Phone Number 
    public String getPhoneNumber() {
        return phoneNumber;
    }

    
    // returns Address 
    public String getAddress() {
        return address;
    }

    /**
     *  Setter method
     */
    
    // sets First Name
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name.");
        }
        this.firstName = firstName;
    }

    
    // sets Last Name
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name.");
        }
        this.lastName = lastName;
    }

    
    // sets Phone Number
    public void setPhoneNumber(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid Phone Number.");
        }
        this.phoneNumber = phone;
    }

    
    // sets Address
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address.");
        }
        this.address = address;
    }
    
    
}