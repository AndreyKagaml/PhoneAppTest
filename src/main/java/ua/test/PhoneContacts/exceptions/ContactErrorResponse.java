package ua.test.PhoneContacts.exceptions;

public class ContactErrorResponse {
    private String message;

    public ContactErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
