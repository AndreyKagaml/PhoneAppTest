package ua.test.PhoneContacts.validators;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.test.PhoneContacts.models.Contact;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactValidator {
    public void validate(Contact contact, List<Contact> contacts) {
        List<String> names = new ArrayList<>();

        for (Contact c : contacts){
            names.add(c.getName());
        }

        if (names.contains(contact.getName())) {
            throw new RuntimeException("Contact with this name already exists");
        }
    }

    public void validate(int id, List<Contact> contacts){
        List<Integer> ids = new ArrayList<>();

        for (Contact c : contacts){
            ids.add(c.getId_contact());
        }

        if (!ids.contains(id)) {
            throw new RuntimeException("Contact not found");
        }
    }

}
