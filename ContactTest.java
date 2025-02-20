package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projectOne.Contact;

/**
 * 
 * @author Niyati.Shetty
 * 
 * This class verifies "Contact"  constructor and its methods
 */

class ContactTest {

    @Test
    void testContactConstructor() {
        Contact contact = new Contact("Contact1", "Niyati", "Shetty", "8006681249", "2500 NRiver Rd, Manchester,NH");
        
        // Now call each getter method and verify correct value is returned
    	assertAll("Test Contact Constructor",
    			() -> assertEquals("Contact1", contact.getContactId()),
    			() -> assertEquals("Niyati", contact.getFirstName()),
    			() -> assertEquals("Shetty", contact.getLastName()),
    			() -> assertEquals("8006681249", contact.getPhoneNumber()),
    			() -> assertEquals("2500 NRiver Rd, Manchester,NH", contact.getAddress())
        );
    }

    @Test
    void testContactId() {
    	assertAll("Test Contact ID",
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
    					null, "Niyati", "Shetty", "8006681249", "2500 NRiver Rd, Manchester,NH")),
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
    					"Contact890123", "Niyati", "Shetty", "8006681249", "2500 NRiver Rd, Manchester,NH"))
    	);
    }

    @Test
    void testFirstName() {
    	assertAll("Test First name",
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
    					"Contact1", null, "Shetty", "8006681249", "2500 NRiver Rd, Manchester,NH")),
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
    					"Contact890123", "NiyatiSHETTY", "Shetty", "8006681249", "2500 NRiver Rd, Manchester,NH"))
    	);
    }

    @Test
    void testLastName() {
    	assertAll("Test Last Name",
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
    					"Contact1", "First", null, "8006681249", "2500 NRiver Rd, Manchester,NH")),
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
        		"Contact890123", "Niyati", "ShettyIsLastName", "8006681249", "2500 NRiver Rd, Manchester,NH"))
    			
    	);
    }

    @Test
    void testInvalidPhoneNumber() {

    	assertAll("Test Invalid Phone number",
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
    					"Contact123", "Niyati", "Shetty", null, "2500 NRiver Rd, Manchester,NH")),
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
    					"Contact123", "Niyati", "Shetty", "1249", "2500 NRiver Rd, Manchester,NH")),
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
    					"Contact123", "Niyati", "Shetty", "8006681249000", "2500 NRiver Rd, Manchester,NH")),
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
    					"Contact123", "Niyati", "Shetty", "ABC6681249", "2500 NRiver Rd, Manchester,NH"))
    		);

    }

    @Test
    void testAddress() {
    	assertAll("Test Address",
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
    					"Contact1", "Niyati", "Shetty", "8006681249", null)),
    			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
        		"Contact890123", "Niyati", "Shetty", "8006681249", "2500 NRiver Rd, Manchester, New Hampshire"))
    			
    	);
    }
    
    @Test
    void testUpdateValidFields() {
        Contact contact = new Contact("Contact123", "Niyati", "Shetty", "8006681249", "2500 NRiver Rd, Manchester,NH");
        
        contact.setFirstName("SNHU");
        
        contact.setLastName("University");
        
        contact.setPhoneNumber("8006007000");
        
        contact.setAddress("3500 Main Rd, Nashua, NH");

        assertAll("Test Update Valid Fields",

                // test setFirstName()
        		() -> assertEquals("SNHU", contact.getFirstName()),
        		() -> assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null)),
        		() -> assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("LargerThan 10 Chars")),


                // test setLastName()
        		() -> assertEquals("University", contact.getLastName()),
        		() -> assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null)),
        		() -> assertThrows(IllegalArgumentException.class, () -> contact.setLastName("LargerThan 10 Chars")),

                // test setPhoneNumber()
        		() -> assertEquals("8006007000", contact.getPhoneNumber()),
        		() -> assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber(null)),
        		() -> assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("LargerThan 10 Chars")),
        		() -> assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("80070060005000")),

                // test setAddress()
        		() -> assertEquals("3500 Main Rd, Nashua, NH", contact.getAddress()),
        		() -> assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null)),
        		() -> assertThrows(IllegalArgumentException.class, () -> contact.setAddress(
        				"500 Main Rd, Nashua, NH and more LargerThan 10 Chars"))
        );


    }
    
    
}