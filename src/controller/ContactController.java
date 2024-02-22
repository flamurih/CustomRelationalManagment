package controller;

import model.Contact;
import service.ContactService;
import service.impl.ContactServiceImpl;

import java.util.List;

public class ContactController {
    private ContactService contactService;

    public ContactController(){
        this.contactService = new ContactServiceImpl();
    }

    public void add(Contact contact){
        contactService.create(contact);
        System.out.printf("%s added. %n",contact);
    }

    public void update(Contact contact) {
        contactService.update(contact);
    }

    public List<Contact> getAll(){
        return contactService.findAll();
    }

    public void delete(int id){
        boolean deleted = contactService.deleteById(id);
        System.out.printf("Consumer deleted. %b%n",deleted);
    }

    public Contact getById(int id) {
        return contactService.findById(id);
    }

    public void list(){
        List<Contact> contactList = contactService.findAll();
        contactList.stream().forEach(System.out::println);
    }
}
