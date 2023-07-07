package ua.test.PhoneContacts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.test.PhoneContacts.models.Contact;
import ua.test.PhoneContacts.models.User;
import ua.test.PhoneContacts.repositories.ContactRepository;
import ua.test.PhoneContacts.repositories.EmailRepository;
import ua.test.PhoneContacts.repositories.NumberRepository;
import ua.test.PhoneContacts.validators.ContactValidator;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ContactService {

    private final ContactRepository contactRepository;
    private final NumberRepository numberRepository;
    private final EmailRepository emailRepository;
    private final ContactValidator contactValidator;

    @Autowired
    public ContactService(ContactRepository contactRepository, NumberRepository numberRepository, EmailRepository emailRepository, ContactValidator contactValidator) {
        this.contactRepository = contactRepository;
        this.numberRepository = numberRepository;
        this.emailRepository = emailRepository;
        this.contactValidator = contactValidator;
    }

    public List<Contact> showAllContacts(){
        return contactRepository.findAll();
    }

    public List<Contact> showAllUsersContacts(User user){
        return contactRepository.findByUser(user);
    }

    public Contact findById(int id){
        contactValidator.validate(id, contactRepository.findAll());
        return contactRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void save(Contact contact){
        contactValidator.validate(contact, contactRepository.findAll());
        contactRepository.save(contact);
        numberRepository.saveAll(contact.getNumbers());
        emailRepository.saveAll(contact.getEmails());
    }

    @Transactional
    public void update(int id, Contact updatedContact){
        contactValidator.validate(id, contactRepository.findAll());
        contactValidator.validate(updatedContact, contactRepository.findAll());

        updatedContact.setId_contact(id);
        contactRepository.save(updatedContact);
        numberRepository.saveAll(updatedContact.getNumbers());
        emailRepository.saveAll(updatedContact.getEmails());
    }

    @Transactional
    public void delete(int id){
        contactRepository.deleteById(id);
    }


}
