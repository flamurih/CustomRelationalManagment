package service;

import model.Contact;

import java.util.List;

public interface ContactService {
    void create(Contact contact);

    Contact findById(int id);

    List<Contact> findAll();

    boolean deleteById(int id);

    void update(Contact contact);

}
