package ContactBookProApp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Exceptions.DuplicateContactException;
import Exceptions.EmptyFieldException;
import Exceptions.InvalidPhoneException;

public class PhoneBook {
	
	private List<Contact> contacts = new ArrayList<>();
	private Set<String> phoneNumber = new HashSet<>();
	
	//Validate phone Number format
	private void validatePhone(String phone) throws InvalidPhoneException{
		if(!phone.matches("\\d{10}")) {
			throw new InvalidPhoneException("Phone number must be exactly 10 digits"); 
		}
	}
	
	//Add Contacts
	public void addContacts(String name,String phone) throws DuplicateContactException,EmptyFieldException,InvalidPhoneException{
		
		if(name.isEmpty() || phone.isEmpty()) {
			throw new EmptyFieldException("Name or Phone cannot be Empty!");
		}
		validatePhone(phone);
		
		if(phoneNumber.contains(phone)) {
			throw new DuplicateContactException("Phone Number Already Exists!");
			
			
		}
		
		contacts.add(new Contact(name,phone));
		phoneNumber.add(phone);
		System.out.println("Contact Added Successfully!");
		
		
	}
	
	public void searchByName(String name) throws  EmptyFieldException{
		if(name.isEmpty()) {
			throw new EmptyFieldException("Search name cannot be empty!");
		}
		
		boolean found = false;
		for(Contact c:contacts) {
			if(c.getName().equalsIgnoreCase(name)) {
				found = true;
				System.out.println("Contact Found:");
				System.out.println("Name: "+c.getName() +"|phone :"+c.getPhone());
				
			}
		}
		
		if(!found) {
			System.out.println("No Contact Found With Phone: ");
		}
		
	}
	// Search by Phone
	public void searchByPhone(String phone) {
	    boolean found = false;

	    for (Contact c : contacts) {
	        if (c.getPhone().equals(phone)) {
	            found = true;
	            System.out.println("Contact Found:");
	            System.out.println("Name: " + c.getName() + " | Phone: " + c.getPhone());
	        }
	    }

	    if (!found) {
	        System.out.println("No Contact Found With Phone: " + phone);
	    }
	}
	
	//Update Contact
	public void updateContact(String oldPhone,String newName,String newPhone) throws InvalidPhoneException,DuplicateContactException{
		validatePhone(newPhone);
		
		for(Contact c:contacts) {
			if(c.getPhone().equals(oldPhone)) {
				
				if(!oldPhone.equals(newPhone) && phoneNumber.contains(newPhone)) {
					throw new DuplicateContactException("This phone number already exists!");
					
				}
				
				phoneNumber.remove(oldPhone);
				phoneNumber.add(newPhone);
				c.setName(newName);
				c.setPhone(newPhone);
				System.out.println("Contact updated Successfully!");
				return;
			}
			
		}
		
		System.out.println("No contact found with phone: "+oldPhone);
		
	}
	
	public void deleteContact(String phone) {
		Iterator<Contact> itr =contacts.iterator();
		while(itr.hasNext()) {
			Contact c=itr.next();
			if(c.getPhone().equals(phone)) {
				itr.remove();
				phoneNumber.remove(phone);
				System.out.println("Contact deleted Successfully!");
				return;
				
			}
			
		}
		System.out.println("No Contact Found With Phone :"+phone);
	}
	
	//Sort Contacts By Name
	public void sortByName() {
		contacts.sort(Comparator.comparing(Contact :: getName));
		System.out.println("Contacts Sorted By Name!");
	}
	
	//Display All Contacts(sorted)
	public void displayContacts() {
		if(contacts.isEmpty()) {
			System.out.println("No Contacts Available!");
			return;
			
		}
		
		sortByName();
		System.out.println("All Contacts:");
		for(Contact c:contacts) {
			System.out.println("Name :"+c.getName()+"| phone :"+c.getPhone());
			
		}
	}
}
