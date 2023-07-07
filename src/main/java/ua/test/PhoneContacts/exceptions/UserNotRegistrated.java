package ua.test.PhoneContacts.exceptions;

public class UserNotRegistrated extends RuntimeException{
    public UserNotRegistrated(String message) {
        super(message);
    }
}
