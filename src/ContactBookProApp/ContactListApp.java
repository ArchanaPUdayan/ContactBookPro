package ContactBookProApp;

import java.util.Scanner;

public class ContactListApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PhoneBook phoneBook = new PhoneBook();
		
		while(true) {
			try {
				System.out.println(" =======WELCOME TO CONTACT LIST MANAGER ======");
				System.out.println("1.Add Contact");
				System.out.println("2.Search by Name:");
				System.out.println("3.Search by Phone");
				System.out.println("4.Update Contact");
				System.out.println("5.Delete Contact");
				System.out.println("6.Display All Contacts");
				System.out.println("7.Exit");
				System.out.println("Enter your choice :");
				
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				
				case 1:
					System.out.println("Enter Name:");
					String name = sc.nextLine();
					System.out.println("Enter Phone:");
					String phone =sc.nextLine();
					phoneBook.addContacts(name, phone);
					break;
					
				case 2:
					System.out.println("Enter Name to Search :");
					phoneBook.searchByName(sc.nextLine());
					break;
					
				case 3:
					System.out.println("Enter Phone To Search :");
					phoneBook.searchByPhone(sc.nextLine());
					break;
					
				case 4:
					System.out.println("Enter Old Phone :");
					String oldPhone = sc.nextLine();
					System.out.println("Enter New Name :");
					String newName = sc.nextLine();
					System.out.println("Enter New Phone");
					String newPhone = sc.nextLine();
					phoneBook.updateContact(oldPhone, newName, newPhone);
					break;
					
				case 5:
					System.out.println("Enter Phone To Delete :");
					phoneBook.deleteContact(sc.nextLine());
					break;
					
				case 6:
					phoneBook.displayContacts();
					break;
					
				case 7:
					System.out.println("Existing PhoneBook...");
					System.exit(0);
					
					default:
						System.out.println("Invalid option!");
				
				}
				
			}
			catch(Exception e) {
				System.out.println("Error: "+e.getMessage());
				
			}
		}
	}

}
