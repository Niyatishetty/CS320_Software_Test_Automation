package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projectOne.Contact;
import projectOne.ContactService;

/**
 * 
 * @author Niyati.Shetty
 * 
 * This class verifies "ContactService"
 */

class ContactServiceTest {

	/**
	 * Test to Add Contact
	 */
    @Test
    void testAddContact() {
    	
        ContactService service = new ContactService();
        Contact contact = new Contact("Contact1", "Niyati", "Shetty", "8006681249", "2500 NRiver Rd, Manchester,NH");
        
        service.addContact(contact);
        assertAll("Test addContact",
      			() -> assertThrows(IllegalArgumentException.class, () -> service.addContact(null)),      	
      			() -> assertEquals(contact, service.getContact("Contact1"))
        );
        
    }

    
    /**
     * Test to add duplicate contact object.
     */
    @Test
    void testAddDuplicateContactObject() {
    
    	ContactService service = new ContactService();
        Contact contact = new Contact("Contact2", "Sunny", "Puppy", "8665551249", "1 River Rd, Manchester,NH");
        
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
        
    }

    
	/**
	 * Test to delete the contact from Map object
	 */
    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("Contact10", "Niyati", "Shetty", "8006681249", "2500 River Rd, Manchester,NH");

        service.addContact(contact);
        service.deleteContact("Contact10");
        assertAll("Test deleteContact",
      			() -> assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null)),   
      			() -> assertThrows(IllegalArgumentException.class, () -> service.deleteContact("NotFound")),   
      			() -> assertNull(service.getContact("Contact10"))
      		);
    }

    
    /**
     * Test to update some fields in contact object.
     */
    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("Contact10", "Niyati", "Shetty", "8006681249", "2500 River Rd, Manchester,NH");
        service.addContact(contact);
        service.updateContact("Contact10", "Sunny", null, "8006680000", "1 River Rd, Manchester,NH");
        
    	assertAll("Test Update contact fields",
    			() -> assertEquals("Sunny", contact.getFirstName()),
    			() -> assertEquals("Shetty", contact.getLastName()),
    			() -> assertEquals("8006680000", contact.getPhoneNumber()),
    			() -> assertEquals("1 River Rd, Manchester,NH", contact.getAddress()),
      			() -> assertThrows(IllegalArgumentException.class, () -> service.updateContact("NotFound","Niyati", "Shetty", "8006681249", "2500 River Rd,Manchester,NH"))   
    	);
    }

    
}