package ua.test.PhoneContacts.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "emails")
public class Email {

    @Id
    @Column(name = "id_email")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_email;

    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
    private Contact contact;

    @jakarta.validation.constraints.Email
    @NotEmpty(message = "Email shouldn\'t be empty")
    @Column(name = "email")
    private String email;

    public Email() {
    }

    public Email(Contact contact, String email) {
        this.contact = contact;
        this.email = email;
    }

    public int getId_email() {
        return id_email;
    }

    public void setId_email(int id_email) {
        this.id_email = id_email;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
