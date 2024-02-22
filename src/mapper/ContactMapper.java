package mapper;

import entity.ContactData;
import exception.ContactException;
import model.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class ContactMapper {
    public Contact fromContactData(ContactData contactData){
        return new Contact(contactData.getId(), contactData.getIdType(), contactData.getName(), contactData.getLastName(),contactData.getCustomerName(), contactData.getGender(),contactData.getDob(),contactData.getCreatedDate(),contactData.getState());
    }

    public ContactData toContactData(Contact contact){
        return new ContactData(contact.getId(), contact.getIdType(), contact.getName(), contact.getLastName(),contact.getCustomerName(), contact.getGender(),contact.getDob(),contact.getCreatedDate(),contact.getState());
    }

    public List<Contact> fromContactData(List<ContactData> contacts) throws ContactException {
        return contacts.stream().map(this::fromContactData).collect(Collectors.toList());
    }
}
