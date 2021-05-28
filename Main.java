package com.deeppatel;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("2505528254");


    public static void main(String[] args) {
	    boolean quit = false;
	    startPhone();
        printActions();
        while(!quit){
            System.out.print("\nEnter action you want to perform : ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Shutting Down !");
                    quit = true;
                    break;
                case 1:
                    printDirectory();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    query();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }
    private static void addNewContact(){
        System.out.print("Enter the CONTACT Name: ");
        String name = sc.nextLine();
        System.out.print("Enter the CONTACT Number: ");
        String number = sc.nextLine();

        Contacts newContact = Contacts.createContact(name,number);

        if(mobilePhone.addContact(newContact)){
            System.out.println("Contact added successfully !");
        }else {
            System.out.println("Contact already on the file !");
        }
    }

    private static void updateContact(){
        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        Contacts exist = mobilePhone.query(name);

        if(exist == null){
            System.out.println("No Contact Found !");
            return;
        }

        System.out.print("Enter the CONTACT Number: ");
        String newNumber = sc.nextLine();

        Contacts newContact = Contacts.createContact(name,newNumber);

        if(mobilePhone.updateContact(exist,newContact)){
            System.out.println("Changed Successfully !");
        }else{
            System.out.println("Error !");
        }
    }

    private static void deleteContact(){
        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        Contacts exist = mobilePhone.query(name);

        if(exist == null){
            System.out.println("No Contact Found !");
            return;
        }

        if(mobilePhone.remove(exist)){
            System.out.println("Deleted Successfully !");
        }else{
            System.out.println("ERROR !");
        }
    }

    private static void query(){
        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        Contacts exist = mobilePhone.query(name);

        if(exist == null){
            System.out.println("No Contact Found !");
            return;
        }

        System.out.println("Name is "+ exist.getName()+" and Phone Number is "+ exist.getPhoneNumber());
    }



    private static void startPhone(){
        System.out.println("Starting Phone !");
    }

    private static void printActions(){
        System.out.println("\nAvailable actions:\nPress");
        System.out.println("0 - to shutdown\n"+
                           "1 - print the phone directory\n" +
                           "2 - Add new Contact\n"+
                           "3 - Update Contact\n" +
                           "4 - Check if contact exist\n"+
                           "5 - Delete Contact\n"+
                           "6 - Print Action List.");
    }

    private static void printDirectory(){
        mobilePhone.printContacts();

    }
}
