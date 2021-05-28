package com.deeppatel;

import javax.crypto.Cipher;
import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> contact;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contact = new ArrayList<Contacts>();
    }

    public boolean addContact(Contacts contacts){
        if(findContact(contacts.getName())>=0){
            System.out.println("Phone Number already in the contact list !");
            return false;
        }
        contact.add(contacts);
        return true;
    }

    private int findContact(Contacts contacts){
        return this.contact.indexOf(contacts);
    }

    private int findContact(String name){
        for(int i=0; i<this.contact.size();i++){
            Contacts contacts = this.contact.get(i);
            if(contacts.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contacts old, Contacts latest){
        int position = findContact(old);
        if(position<0){
            System.out.println(old.getName()+" was not found in the directory !");
            return false;
        }

        this.contact.set(position,latest);
        System.out.println(old.getName() + " is changed with " + latest.getName());
        return true;
    }

    public String query(Contacts contacts){
        if(findContact(contacts)>0){
            return contacts.getName();
        }
        return null;
    }

    public Contacts query(String name){
        int position = findContact(name);
        if(position>=0){
            return this.contact.get(position);
        }
        return null;
    }

    public boolean remove(Contacts contacts){
        int position = findContact(contacts);
        if(position<0){
            System.out.println(contacts.getName()+" was not found in the directory !");
            return false;
        }
        this.contact.remove(position);
        System.out.println(contacts.getName() +" was deleted !");
        return true;
    }
    
    public void printContacts(){
        System.out.println("Contact List");
        for(int i=0; i<this.contact.size();i++){
            System.out.println((i+1)+". " + this.contact.get(i).getName() + " ---> " + this.contact.get(i).getPhoneNumber());
        }
    }

}
