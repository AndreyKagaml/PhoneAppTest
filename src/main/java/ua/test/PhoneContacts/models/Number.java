package ua.test.PhoneContacts.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table
public class Number {

    @Id
    @Column(name = "id_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_number;

    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
    private Contact contact;

    @Column(name = "phone_number")
    @NotEmpty(message = "Number shouldn\'t be empty")
    @Pattern(regexp = "^\\+380\\d{9}$", message = "Incorrect format number")
    private String phoneNumber;

    public Number() {
    }

    public Number(Contact contact, String phoneNumber) {
        this.contact = contact;
        this.phoneNumber = phoneNumber;
    }

    public int getId_number() {
        return id_number;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
