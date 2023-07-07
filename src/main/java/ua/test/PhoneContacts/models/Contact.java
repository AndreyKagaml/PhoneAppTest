package ua.test.PhoneContacts.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @Column(name = "id_contact")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contact;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @NotEmpty(message = "Name shouldn\'t be empty")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "contact")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Number> numbers;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Email> emails;

    public Contact() {
    }

    public Contact(User user, String name, List<Number> numbers, List<Email> emails) {
        this.user = user;
        this.name = name;
        this.numbers = numbers;
        this.emails = emails;
    }

    public int getId_contact() {
        return id_contact;
    }

    public void setId_contact(int id_contact) {
        this.id_contact = id_contact;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
}
