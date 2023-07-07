package ua.test.PhoneContacts.exceptions;

public class ContactNotAddedOrUpdatedException extends RuntimeException{
    public ContactNotAddedOrUpdatedException(String message) {
        super(message);
    }
}
