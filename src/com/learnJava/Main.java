package com.learnJava;

import java.util.Scanner;

public class Main {
	/**
	 * Create a program that implements a simple mobile phone with the following capabilities.
	 * Able to store, modify, remove and query contact names.
	 * You will want to create a separate class for Contacts (name and phone number).
	 * Create a master class (MobilePhone) that holds the ArrayList of Contacts
	 * The MobilePhone class has the functionality listed above.
	 * Add a menu of options that are available.
	 * Options:  
	 * - Quit
	 * - Print list of contacts
	 * - Add new contact
	 * - Update existing contact
	 * - Remove contact
	 * - Search / find contact
	 * When adding or updating be sure to check if the contact already exists (use name)
	 * Be sure not to expose the inner workings of the Arraylist to MobilePhone
	 * e.g. no ints, no .get(i) etc
	 * MobilePhone should do everything with Contact objects only.
	 */
	public static void main(String[] args) {
		
		printMenu();
		boolean quit = false;
		while(!quit) {
			System.out.println("Choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
				case 1:
					printListOfContacts();
					break;
				case 2:
					addContact();
					break;
				case 3:
					updateContact();
					break;
				case 4:
					removeContact();
					break;
				case 5:
					searchContact();
					break;
				case 6:
					quit = true;
					quit();
					break;
				default:
					System.out.println("Invalid option");
					printMenu();
			}
		}
	}

	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone();
	
	private static void printMenu() {
		System.out.println("Print:");
		System.out.println("\t 1- Print list of contacts");
		System.out.println("\t 2- Add new contact");
		System.out.println("\t 3- Update existing contact");
		System.out.println("\t 4- Remove contact");
		System.out.println("\t 5- Search / find contact");
		System.out.println("\t 6- Quit");
	}
	
	private static void printListOfContacts() {
		mobilePhone.printListOfContacts();
	}
	
	private static void addContact() {
		System.out.println("Enter contact name: ");
		String name = scanner.nextLine();
		System.out.println("Enter contact number: ");
		int number = scanner.nextInt();
		scanner.nextLine();
		
		mobilePhone.addContact(new Contact(name, number));
	}
	
	private static void updateContact() {
		System.out.println("Enter contact you want to update: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter contact new name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter contact new number: ");
		int newPhoneNumber = scanner.nextInt();
		scanner.nextLine();
		
		Contact newContact = new Contact(newName, newPhoneNumber);
		
		mobilePhone.updateContact(name, newContact);
	}
	
	private static void removeContact() {
		System.out.println("Enter contact you want to remove: ");
		String name = scanner.nextLine();
		
		mobilePhone.removeContact(name);
	}
	
	private static void searchContact() {
		System.out.println("Enter contact name: ");
		String name = scanner.nextLine();
		
		int contactPosition = mobilePhone.findContact(name);
		if(contactPosition < 0) {
			System.out.println("Contact not found");
		}
		System.out.println(name + ": " + mobilePhone.getContacts().get(contactPosition).getNumber());
	}
	
	private static void quit() {
		System.out.println("/*--- Goodbye ---*/");
	}
	
}
