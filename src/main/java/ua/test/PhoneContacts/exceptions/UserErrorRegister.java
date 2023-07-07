package ua.test.PhoneContacts.exceptions;

public class UserErrorRegister {
    private String message;

    public UserErrorRegister(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
