package projectOne;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Niyati.Shetty
 *
 * The class add the Contact to the map, deletes contact and updates the 
 * contact fields.
 */


public class ContactService {
	
    private final Map<String, Contact> contacts = new HashMap<>();
    
    // default constructor
    public ContactService() {
    }
    

    // returns a contact based on ContactID
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
    
    
    // Add a new contact (Contact ID should be unique)
    public void addContact(Contact contact) {
    	
        if (contact == null) {
            throw new IllegalArgumentException("Contact object cannot be null.");
        }
        
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by Contact ID
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        
        // Now delete the contact from the Map
        contacts.remove(contactId);
    }

    /*
     * Update Contact Fields - firstName, lastName, phoneNumber, Address
     */
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
    	
    	// Get the contact object based on contact ID
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        
        
        //Only update the field if values is not null.
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        
        if (phone != null) {
            contact.setPhoneNumber(phone);
        }
        
        if (address != null) {
            contact.setAddress(address);
        }
        
    }
    
}