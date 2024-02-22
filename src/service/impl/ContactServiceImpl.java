package service.impl;

import model.Contact;
import repository.ContactRepository;
import repository.TelecomRepository;
import repository.impl.ContactFileRepository;
import service.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    public ContactServiceImpl(){
        this.contactRepository = new ContactFileRepository();
    }
    @Override
    public void create(Contact contact) {
        contactRepository.create(contact);
    }

    @Override
    public Contact findById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return contactRepository.deleteById(id);
    }

    @Override
    public void update(Contact contact) {
        contactRepository.update(contact);
    }

}